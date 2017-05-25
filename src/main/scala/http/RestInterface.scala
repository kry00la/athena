package com.ph.athena

import com.ph.athena.http.resources.{UserResources, WordResources}
import akka.http.scaladsl.server.Route
import com.ph.athena.mock.DictionaryMock

/**
  * Created by Led on 23/04/2017.
  */
trait RestInterface extends Resources {


  val routes: Route = (wordRoutes ~ userRoutes)
}


trait Resources extends WordResources with UserResources
