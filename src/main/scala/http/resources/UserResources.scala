package com.ph.athena.http.resources

import akka.http.scaladsl.model.StatusCodes
import http.MyResources


/**
  * Created by Led on 25/05/2017.
  */
trait UserResources extends MyResources {
  val userRoutes =
    path("users") {
      get {
        print("users -- eee")
        complete(StatusCodes.OK)
      }
    }

}
