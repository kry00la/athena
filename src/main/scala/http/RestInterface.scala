package com.ph.athena

import com.ph.athena.http.resources.WordResources
import akka.http.scaladsl.server.Route
import com.ph.athena.mock.DictionaryMock

/**
  * Created by Led on 23/04/2017.
  */
trait RestInterface extends Resources {
  lazy val dictonaryService = new DictionaryMock

  val routes: Route = wordRoutes
}


trait Resources extends WordResources
