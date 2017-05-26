package com.ph.athena.http.resources

import akka.http.scaladsl.model.StatusCodes
import com.ph.athena.mock.DictionaryMock
import com.ph.athena.http.{Json4sSupport, MyResources}
import com.ph.athena.model.{Word, WordType}
/**
  * Created by Led on 22/04/2017.
  */
trait WordResources extends MyResources {
  //lazy val dictonaryService = new DictionaryMock
  val wordRoutes =
    path(prefix / "word") {
        get {
          complete {
            Word("12","Talon",WordType.Verb,List("Tatalon ako sa building"))
            //"OK"
          }
        }
    }

}
