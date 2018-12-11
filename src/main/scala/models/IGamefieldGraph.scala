package models

trait IGamefieldGraph {

  def init() : Unit
  def setStoneVertex (vertex : Int, color : Char) : Boolean
  def getStoneColorVertex (vertex : Int ) : Char
  def getAdjacencyList (v : Int) : List[Int]
  def getId : String
  def setId (id : String) : Unit
}