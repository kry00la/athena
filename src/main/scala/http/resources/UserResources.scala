package com.ph.athena.http.resources

import akka.http.scaladsl.model.StatusCodes
import com.ph.athena.http.MyResources


/**
  * Created by Led on 25/05/2017.
  */
trait UserResources extends MyResources {

  val userRoutes =
    path( prefix / "users") {
      get {
        print("users -- eee")
        complete(StatusCodes.OK)
      }
    }

}

