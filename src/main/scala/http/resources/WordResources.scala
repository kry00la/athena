package com.ph.athena.http.resources

import akka.http.scaladsl.model.StatusCodes
import http.MyResources

/**
  * Created by Led on 22/04/2017.
  */
trait WordResources extends MyResources {

  val wordRoutes =
    path("word") {
        get {
          print("eeee")
          complete(StatusCodes.OK)
        }
    }

}
