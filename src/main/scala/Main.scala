package com.ph.athena
import com.ph.athena.http.Route
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
//import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Led on 22/04/2017.
  */
object Main extends App with Route {
  print("************ START UP *************")

  implicit val system = ActorSystem("system")

  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
//  implicit val executionContext = system.dispatcher

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done

}
