package com.ph.athena.dao
import java.util.UUID

import com.ph.athena.model._
import com.ph.athena.mock.DictionaryMock
import com.ph.athena.model.WordType

/**
  * Created by Led on 22/04/2017.
  */
class WordDao {
  def getWordbyId(id: String): Word = {
    DictionaryMock.talon
  }
}
