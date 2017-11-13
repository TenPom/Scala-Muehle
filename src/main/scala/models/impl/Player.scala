package models.impl

import models.IPlayer

class Player (nameP:String, colorP:Char) extends IPlayer {
  var name : String = nameP
  var color : Char = colorP

  override def getName : String = this.name

  override def getColor : Char = this.color
}
