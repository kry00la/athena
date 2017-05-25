package com.ph.athena.mock
import com.ph.athena.model.Word
import com.ph.athena.model.WordType
import java.util.UUID
/**
  * Created by Led on 22/04/2017.
  */
class DictionaryMock {
  val uuid = UUID.randomUUID.toString
  val talon = Word(uuid,"Talon",WordType.Verb,List("Tatalon ako sa building"))

  def getWord(id:String) = {
    talon
  }
}
