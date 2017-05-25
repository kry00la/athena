package com.ph.athena
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.ph.athena.http.resources.WordResources
//import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Led on 22/04/2017.
  */
object Main extends App with RestInterface {
  println("************ START UP *************")

  implicit val system = ActorSystem("system")

  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
//  implicit val executionContext = system.dispatcher


  Http().bindAndHandle(handler = routes, interface = "localhost", port = 8080) map { binding =>
    println(s"REST interface bound to ${binding.localAddress}") } recover { case ex =>
    println(s"REST interface could not bind to localhst:8080", ex.getMessage)
  }

}
