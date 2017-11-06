package models.impl

import models.IGamefieldGraph

class GamefieldGraph extends IGamefieldGraph {

  val NUMBER_VERTEX = 24
  var vertexes = List[Char]
  var adjacencyList = Seq[List[Int]]

  override def setStoneVertex(vertex: Int, color: Char): Boolean = ???

  override def getStoneColorVertex(vertex: Int): Char = ???

  override def getAdjacencyList(v: Int): List[Int] = ??? //adjacencyList(v)

  override def getId: String = ???

  override def setId(id: String): Unit = ???
}
