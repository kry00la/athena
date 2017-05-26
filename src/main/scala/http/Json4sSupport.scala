package com.ph.athena.http

import java.text.SimpleDateFormat

import org.json4s.{DefaultFormats, jackson}
import com.ph.athena.model.Word
import org.json4s.jackson.Json4sScalaModule
import java.lang.reflect.InvocationTargetException

import akka.http.scaladsl.marshalling.{ Marshaller, ToEntityMarshaller }
import akka.http.scaladsl.model.ContentTypeRange
import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.unmarshalling.{ FromEntityUnmarshaller, Unmarshaller }
import akka.util.ByteString
import org.json4s.{ Formats, MappingException, Serialization }
import scala.collection.immutable.Seq



/**
  * Created by Led on 23/04/2017.
  */
trait Json4sSupport {

  sealed abstract class ShouldWritePretty

  final object ShouldWritePretty {
    final object True  extends ShouldWritePretty
    final object False extends ShouldWritePretty
  }


  def unmarshallerContentTypes: Seq[ContentTypeRange] =
    List(`application/json`)

  private val jsonStringUnmarshaller =
    Unmarshaller.byteStringUnmarshaller
      .forContentTypes(unmarshallerContentTypes: _*)
      .mapWithCharset {
        case (ByteString.empty, _) => throw Unmarshaller.NoContentException
        case (data, charset)       => data.decodeString(charset.nioCharset.name)
      }

  private val jsonStringMarshaller = Marshaller.stringMarshaller(`application/json`)

  /**
    * HTTP entity => `A`
    *
    * @tparam A type to decode
    * @return unmarshaller for `A`
    */
  implicit def unmarshaller[A: Manifest](implicit serialization: Serialization,
                                         formats: Formats): FromEntityUnmarshaller[A] =
    jsonStringUnmarshaller
      .map(s => serialization.read(s))
      .recover { _ => _ =>
      { case MappingException(_, ite: InvocationTargetException) => throw ite.getCause }
      }

  /**
    * `A` => HTTP entity
    *
    * @tparam A type to encode, must be upper bounded by `AnyRef`
    * @return marshaller for any `A` value
    */
  implicit def marshaller[A <: AnyRef](implicit serialization: Serialization,
                                       formats: Formats,
                                       shouldWritePretty: ShouldWritePretty =
                                       ShouldWritePretty.False): ToEntityMarshaller[A] =
    shouldWritePretty match {
      case ShouldWritePretty.False =>
        jsonStringMarshaller.compose(serialization.write[A])
      case ShouldWritePretty.True =>
        jsonStringMarshaller.compose(serialization.writePretty[A])
    }

  implicit val serialization = jackson.Serialization // or native.Serialization
  implicit val formats       = DefaultFormats

}
