package models.impl

import models.IGamefieldGraph

class GamefieldGraph extends IGamefieldGraph {

  val NUMBER_VERTEX = 24
  val CHAR_VERTEXES = List('b', 'n', 's')
  var vertexes = Array[Char](24)
  var adjacencyList = List(List(Int))

  override def setStoneVertex(vertex: Int, color: Char): Boolean = {
    if (vertex >= 0 && vertex < 24 && CHAR_VERTEXES.contains(color)) {
      vertexes(vertex) = color
      return true
    }
    return false
  }



  override def getStoneColorVertex(vertex: Int): Char = ???

  override def getAdjacencyList(v: Int): List[Int] = ??? //adjacencyList(v)

  override def getId: String = ???

  override def setId(id: String): Unit = ???
}
