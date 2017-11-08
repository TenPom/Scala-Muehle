package controller.impl

import Observer.{IObservable, IObserver}
import controler.IController
import models.IPlayer
import models.impl.Player

class Controller extends IController with IObservable {

  val MINSTONES : Int = 3
  val MAXSTONES : Int = 18
  val SLEEPTIME : Int = 5500
  val STONESPLAYER : Int = 9

  val observers : List[IObserver] = List[IObserver]()
  //var gamefield : IGamefieldGraphAdapter
  var player1, player2, current : IPlayer = _
  var stonesPlayer1, consumedStonesPlayer1 : Int = _
  var stonesPlayer2, consumedStonesPlayer2 : Int = _
  var placedStones: Int = 0
  var playerWon : String = ""
  var currentStonesToDelete : Int = 0
  var selected : Int = 0

  this.init


  /**
    * replaces the Constructor and is called from restartGame
    */
  override def init: Unit = {
    this.player1 = new Player("Player1", 'w')
    this.player2 = new Player("Player2", 'b')
    this.stonesPlayer1 = STONESPLAYER
    this.stonesPlayer2 = STONESPLAYER
    this.current = this.player1
    this.placedStones = 0
    this.playerWon = ""
    this.currentStonesToDelete = 0
    this.selected = 0
    this.consumedStonesPlayer1 = 0
    this.consumedStonesPlayer2 = 0

  }

  /**
    * Sets a Stone on the Gamefield
    *
    * @param vertex
    * @return returns true if the stone got placed, false if not
    */
  override def setStone(vertex: Int): Boolean = ???

  /**
    * Sets a Stone with a specific color
    *
    * @param vertex
    * @param color color of the stone
    * @return returns true if the stone got placed, false if not
    */
override def setStone(vertex: Int, color: Char): Boolean = ???

  /**
    * Moves a stone from one vertex to an other
    *
    * @param startVertex
    * @param endVertex
    * @return returns true if the stone can be moved
    */
  override def moveStone(startVertex: Int, endVertex: Int): Boolean = ???

  /**
    * Removes a Stone from the Gamefield
    *
    * @param vertex
    * @return returns true if the stone got removed
    */
  override def removeStone(vertex: Int): Boolean = ???

  /**
    * Returns the number of Mills outgoing from the vertex
    *
    * @param vertex
    * @return
    */
  override def getCountClosedMills(vertex: Int): Int = ???

  /**
    * Checks if the ended
    *
    * @return returns true if the game ended
    */
  override def gameEnded: Boolean = ???

  /**
    * return the winning player
    *
    * @return winning player
    */
  override def getWinningPlayer: String = ???

  /**
    * Deletes a stone
    *
    * @param vertex
    * @return returns true if the stone got deleted
    */
  override def deleteStone(vertex: Int): Boolean = ???

  /**
    * Returns the number of stones the player is allowed to delete
    *
    * @return returns the number of stones to delete
    */
  override def getCurrentStonesToDelete: Int = ???

  /**
    * Proof if the game needs to be initialized
    *
    * @return returns true if the game needs to be initialized
    */
  override def requireInitial: Boolean = ???

  /**
    * Get the playername of the current player
    *
    * @return the playername of the current player
    */
  override def getCurrentPlayerName: String = ???

  /**
    * Get the color of the current player
    *
    * @return the color of the current player as char
    */
  override def getCurrentPlayerColor: Char = ???

  /**
    * Changing the current player to the next one
    */
  override def selectNextPlayer: Unit = ???

  /**
    * Get the color of the vertex
    *
    * @return the vertex color as char
    */
  override def getVertexColor(vertex: Int): Char = ???

  /**
    * Get the number of consumed stones from player one
    *
    * @return number of consumed stones
    */
  override def getConsumedStonesP1: Int = ???

  /**
    * Get the number of consumed stones from player two
    *
    * @return number of consumed stones
    */
  override def getConsumedStonesP2: Int = ???


  /**
    * resets the game
    *
    * @return true if successful, false if not
    */
  override def resetGame: Boolean = ???

  /**
    * Register an Observer
    *
    * @param observer
    */
  override def registerObserver(observer: IObserver): Unit = ???

  /**
    * Deregister an Observer
    *
    * @param observer
    */
  override def deregisterObserver(observer: IObserver): Unit = ???

  /**
    * Update Observers
    */
  override def updateObservers: Unit = ???

  override def getGamefieldString: String = ???
}
