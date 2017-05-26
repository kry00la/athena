package com.ph.athena.http

import akka.http.scaladsl.server.Directives

/**
  * Created by Led on 25/05/2017.
  */
trait MyResources extends Directives with Json4sSupport{
  def prefix: String = "athena"
}
