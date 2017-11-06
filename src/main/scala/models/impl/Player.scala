package models.impl

import models.IPlayer

class Player (nameP:String, colorP:Char) extends IPlayer {
  var name : String = nameP
  var color : Char = colorP

  override def getName = name

  override def getColor = color
}
