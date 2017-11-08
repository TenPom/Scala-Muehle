package models.impl

import models.IGamefieldGraph

class GamefieldGraph extends IGamefieldGraph {

  val NUMBER_ZERO = 0
  val NUMBER_VERTEX = 24
  val CHAR_VERTEXES = List('b', 'n', 's')
  val CHAR_EMPTY = 'n'
  var vertexes = Array[Char](24)
  var adjacencyList = List[List[Int]]()

  def createVertexes(): Unit = {

    for(i <- NUMBER_ZERO to NUMBER_VERTEX)
      vertexes(i) = CHAR_EMPTY
  }

  override def setStoneVertex(vertex: Int, color: Char): Boolean = {
    if (vertex >= NUMBER_ZERO && vertex < NUMBER_VERTEX && CHAR_VERTEXES.contains(color)) {
      vertexes(vertex) = color
      return true
    }
    return false
  }

  override def getStoneColorVertex(vertex: Int): Char = {
    if (vertex >= NUMBER_ZERO && vertex < NUMBER_VERTEX)
      return vertexes(vertex)

    return CHAR_EMPTY
  }

  override def getAdjacencyList(v: Int): List[Int] = adjacencyList(v)

  override def getId: String = ???

  override def setId(id: String): Unit = ???
}

