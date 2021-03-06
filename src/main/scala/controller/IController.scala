package controler

trait IController {

  /**
    * replaces the Constructor and is called from restartGame
    */
  def init : Unit

  /**
    * Sets a Stone on the Gamefield
    * @param vertex
    * @return returns true if the stone got placed, false if not
    */
  def setStone(vertex : Int) : Boolean

  /**
    * Sets a Stone with a specific color
    * @param vertex
    * @param color color of the stone
    * @return returns true if the stone got placed, false if not
    */
  def setStone (vertex : Int, color : Char) : Boolean

  /**
    * Moves a stone from one vertex to an other
    * @param startVertex
    * @param endVertex
    * @return returns true if the stone can be moved
    */
  def moveStone (startVertex : Int, endVertex : Int) : Boolean

  /**
    * moves a Stone, controler saves the param if it is the startvertex. To move, it is requiered to call move 2 times
    * ( moveStone(startNode); moveStone(endNode);
    *
    * @param vertex stone
    * @return boolean state of succes
    **/
  def moveStone(vertex : Int) : Boolean

  /**
    * Removes a Stone from the Gamefield
    * @param vertex
    * @return returns true if the stone got removed
    */
  def removeStone (vertex : Int) : Boolean

  /**
    * Returns the number of Mills outgoing from the vertex
    * @param vertex
    * @return
    */
  def getCountClosedMills (vertex : Int) : Int

  /**
    * Checks if the ended
    * @return returns true if the game ended
    */
  def gameEnded : Boolean

  /**
    * return the winning player
    * @return winning player
    */
  def getWinningPlayer : String

  /**
    * Deletes a stone
    * @param vertex
    * @return returns true if the stone got deleted
    */
  def deleteStone (vertex : Int) : Boolean

  /**
    * Returns the number of stones the player is allowed to delete
    * @return returns the number of stones to delete
    */
  def getCurrentStonesToDelete : Int

  /**
    * Proof if the game needs to be initialized
    * @return returns true if the game needs to be initialized
    */
  def requireInitial : Boolean

  /**
    * Get the playername of the current player
    * @return the playername of the current player
    */
  def getCurrentPlayerName : String

  /**
    * Get the color of the current player
    * @return the color of the current player as char
    */
  def getCurrentPlayerColor : Char

  /**
    * Get the color of the vertex
    * @return the vertex color as char
    */
  def getVertexColor (vertex : Int) : Char

  /**
    * Get the number of consumed stones from player one
    * @return number of consumed stones
    */
  def getConsumedStonesP1 : Int

  /**
    * Get the number of consumed stones from player two
    * @return number of consumed stones
    */
  def getConsumedStonesP2 : Int

  /**
    * resets the game
    * @return true if successful, false if not
    */
  def resetGame : Boolean

  def getGamefieldString : String

  def setNextPlayer : Unit

  def millDeleteStone (vertex : Int) : Boolean
}
