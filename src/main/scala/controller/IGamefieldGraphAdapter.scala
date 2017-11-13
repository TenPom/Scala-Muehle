package controller

/**
  * //TODO: IGamefieldGraphAdapter
  *
  * @author Patrick Schmidt
  * @since 13.11.2017
  **/
trait IGamefieldGraphAdapter {

  /**
    * place a stone on the gamefield
    * @param vertex number of the node
    * @param color color of the stone
    * @return true if the stone got placed, false if not
    */
  def setStone(vertex : Int, color : Char) : Boolean

  /**
    * remove a stone from the gamefield
    * @param vertex number of the node
    * @return true if the stone got removed, false if not
    */
  def removeStone(vertex : Int) : Boolean

  /**
    * Get the color of a specific vertex
    * @param vertex number of the node
    * @return the character of the color in lower case. 'w' = white, 'b' = black, n = no color
    */
  def getColor(vertex : Int) : Char

  /**
    * Move a stone on the gamefield from one vertex to another
    * @param startVertex number of start veretx
    * @param endVertex number of end vertex
    * @return true if stone got moved, false if not
    */
  def moveStone(startVertex : Int, endVertex : Int) : Boolean

  /**
    *
    * @param vertex
    * @return number of mills (0,1,2)
    */
  def getNumberOfMills(vertex : Int) : Int

  /**
    * reset the gamefield
    * @return
    */
  def reset : Boolean
}
