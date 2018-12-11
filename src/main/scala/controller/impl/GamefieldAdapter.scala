package controller.impl

import controller.IGamefieldGraphAdapter
import models.IGamefieldGraph
import models.impl.GamefieldGraph

/**
  * //TODO: GamefieldAdapter
  *
  * @author Patrick Schmidt
  * @since 13.11.2017
  **/
class GamefieldAdapter extends IGamefieldGraphAdapter{

  val MAX_VERTEX : Int = 24

  var gamefield : IGamefieldGraph = new GamefieldGraph()

  /**
    * place a stone on the gamefield
    *
    * @param vertex number of the node
    * @param color  color of the stone
    * @return true if the stone got placed, false if not
    */
  override def setStone(vertex: Int, color: Char) = gamefield.setStoneVertex(vertex, color)

  /**
    * remove a stone from the gamefield
    *
    * @param vertex number of the node
    * @return true if the stone got removed, false if not
    */
override def removeStone(vertex: Int) = setStone(vertex, 'n')

  /**
    * Get the color of a specific vertex
    *
    * @param vertex number of the node
    * @return the character of the color in lower case. 'w' = white, 'b' = black, n = no color
    */
  override def getColor(vertex: Int) = gamefield.getStoneColorVertex(vertex)

  /**
    * Move a stone on the gamefield from one vertex to another
    *
    * @param startVertex number of start veretx
    * @param endVertex   number of end vertex
    * @return true if stone got moved, false if not
    */
  override def moveStone(startVertex: Int, endVertex: Int, color: Char) : Boolean =
    gamefield.setStoneVertex(startVertex, 'n') && gamefield.setStoneVertex(endVertex, color)


  /**
    *
    * @param vertex
    * @return number of mills (0,1,2)
    */
  override def getNumberOfMills(vertex: Int, color: Char) = ???

  /**
    * reset the gamefield
    *
    * @return
    */
  override def reset : Boolean = {
    gamefield.init
    return true
  }
}
