package com.ph.athena.model
import com.ph.athena.model.WordType._
/**
  * Created by Led on 22/04/2017.
  */
case class Word(id: String,word: String,typ: WordType, example: List[String])