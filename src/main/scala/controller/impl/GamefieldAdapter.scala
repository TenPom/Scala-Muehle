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
  override def setStone(vertex: Int, color: Char) = ???

  /**
    * remove a stone from the gamefield
    *
    * @param vertex number of the node
    * @return true if the stone got removed, false if not
    */
override def removeStone(vertex: Int) = ???

  /**
    * Get the color of a specific vertex
    *
    * @param vertex number of the node
    * @return the character of the color in lower case. 'w' = white, 'b' = black, n = no color
    */
  override def getColor(vertex: Int) = ???

  /**
    * Move a stone on the gamefield from one vertex to another
    *
    * @param startVertex number of start veretx
    * @param endVertex   number of end vertex
    * @return true if stone got moved, false if not
    */
  override def moveStone(startVertex: Int, endVertex: Int) = ???

  /**
    *
    * @param vertex
    * @return number of mills (0,1,2)
    */
  override def getNumberOfMills(vertex: Int) = ???

  /**
    * reset the gamefield
    *
    * @return
    */
  override def reset = ???
}
