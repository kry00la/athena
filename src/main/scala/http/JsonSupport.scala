package http

import java.text.SimpleDateFormat
import org.json4s.{native, DefaultFormats, Formats}
//import de.heikoseeberger.akkahttpjson4s.Json4sSupport

/**
  * Created by Led on 23/04/2017.
  */
trait JsonSupport {// extends Json4sSupport {

//    implicit val serialization = native.Serialization

//    implicit def json4sFormats: Formats = customDateFormat ++ JodaTimeSerializers.all ++ CustomSerializers.all

    val customDateFormat = new DefaultFormats {
      override def dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    }
}
