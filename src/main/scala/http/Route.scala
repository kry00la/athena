package com.ph.athena.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes

/**
  * Created by Led on 22/04/2017.
  */
trait Route {

  val route =
    path("auction") {
      put {
        parameter("bid".as[Int], "user") { (bid, user) =>
          // place a bid, fire-and-forget
         // auction ! Bid(user, bid)
          complete((StatusCodes.Accepted, "bid placed"))
        }
      } ~
        get {
          //implicit val timeout: Timeout = 5.seconds
          // query the actor for the current auction state
          //val bids: Future[Bids] = (auction ? GetBids).mapTo[Bids]
          complete(StatusCodes.Accepted)
        }
    }

}
