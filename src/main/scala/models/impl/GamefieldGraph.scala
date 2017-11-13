package models.impl

import java.util.UUID

import models.IGamefieldGraph

/**
  *
  * @author Patrick Schmidt
  * @since 08.11.2017
  */
class GamefieldGraph extends IGamefieldGraph {

  val NUMBER_ZERO = 0
  val NUMBER_VERTEX = 24
  val CHAR_VERTEXES = List('b', 'n', 'w')
  val CHAR_EMPTY = 'n'
  var vertexes : Array[Char] = _
  var adjacencyList : List[List[Int]] = _

  var id : String = _

  def init() : Unit = {
    adjacencyList = List[List[Int]]()
    vertexes = Array[Char](24)

    this.id = UUID.randomUUID().toString
  }

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

  override def getId: String = return this.id

  override def setId(id: String): Unit = this.id = id
}

