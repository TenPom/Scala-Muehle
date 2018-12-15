package controller.impl

import Observer.{IObservable, IObserver}
import controler.IController
import controller.IGamefieldGraphAdapter
import models.IPlayer
import models.impl.Player

import scala.collection.mutable.ListBuffer

class Controller extends IController with IObservable {

  val MINSTONES : Int = 3
  val ALLSTONES : Int = 18
  val SLEEPTIME : Int = 5500
  val STONESPLAYER : Int = 9

  val observers : ListBuffer[IObserver] = ListBuffer[IObserver]()
  var gamefield : IGamefieldGraphAdapter = _
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
    this.gamefield = new GamefieldAdapter

  }

  def increasePlayerPlacedStones() : Unit = {
    if (current.equals(player1)) consumedStonesPlayer1 += 1 else consumedStonesPlayer2 += 1
  }

  /**
    * Sets a Stone on the Gamefield
    *
    * @param vertex
    * @return returns true if the stone got placed, false if not
    */
  override def setStone(vertex: Int): Boolean = {
    setStone(vertex, getCurrentPlayerColor)
  }

  /**
    * Sets a Stone with a specific color
    *
    * @param vertex
    * @param color color of the stone
    * @return returns true if the stone got placed, false if not
    */
  override def setStone(vertex: Int, color: Char): Boolean = {
    if(gamefield.setStone(vertex, color)) {
      placedStones += 1
      increasePlayerPlacedStones()
      getCountClosedMills(vertex)
      updateObservers(vertex)
      return true
    } else return false
}

  /**
    * Moves a stone from one vertex to an other
    *
    * @param startVertex
    * @param endVertex
    * @return returns true if the stone can be moved
    */
  override def moveStone(startVertex: Int, endVertex: Int): Boolean = {
    if(gamefield.moveStone(startVertex, endVertex, getCurrentPlayerColor)) {
      this.getCountClosedMills(endVertex)
      this.updateObservers(endVertex)
      return true
    }
    return false
  }

  /**
    * moves a Stone, controler saves the param if it is the startvertex. To move, it is requiered to call move 2 times
    * ( moveStone(startNode); moveStone(endNode);
    *
    * @param vertex stone
    * @return boolean state of succes
    **/
  override def moveStone(vertex: Int): Boolean = selected match {
    case 0 =>
      if ( (this.getVertexColor(vertex) == 'n' ) || ( getVertexColor(vertex) != current.getColor )) return false
      selected = vertex
      true
    case `vertex` => false
    case _ =>
      val tmp = moveStone(selected, vertex)
      selected = 0
      tmp
  }

  /**
    * Removes a Stone from the Gamefield
    *
    * @param vertex
    * @return returns true if the stone got removed
    */
  override def removeStone(vertex: Int): Boolean = {
    if(gamefield.getColor(vertex) == current.getColor)
      return false

    if(gamefield.removeStone(vertex)) {
      decreaseStonesPlayer(gamefield.getColor(vertex))
      return true
    }

    return false
  }

  def decreaseStonesPlayer(color : Char) : Unit = {
    color match {
      case 'w' => stonesPlayer2 -= 1
      case 's' => stonesPlayer1 -= 1
    }
  }

  /**
    * Returns the number of Mills outgoing from the vertex
    *
    * @param vertex
    * @return
    */
  override def getCountClosedMills(vertex: Int): Int = {
    this.currentStonesToDelete = gamefield.getNumberOfMills(vertex, getCurrentPlayerColor)
    return currentStonesToDelete
  }

  /**
    * Checks if the ended
    *
    * @return returns true if the game ended
    */
  override def gameEnded: Boolean = {
    if(stonesPlayer1 < MINSTONES) {
      this.playerWon = this.player2.getName
      return true
    } else if(stonesPlayer2 < MINSTONES) {
      this.playerWon = this.player1.getName
      return true
    }

    return false
  }

  /**
    * return the winning player
    *
    * @return winning player
    */
  override def getWinningPlayer: String = this.playerWon

  /**
    * Deletes a stone
    *
    * @param vertex
    * @return returns true if the stone got deleted
    */
  override def deleteStone(vertex: Int): Boolean = {
    if(gamefield.getColor(vertex) == current.getColor) return true

    val temp = gamefield.removeStone(vertex)

    if(temp)
      decreaseStonesPlayer(gamefield.getColor(vertex))

    return temp
  }

  /**
    * Returns the number of stones the player is allowed to delete
    *
    * @return returns the number of stones to delete
    */
  override def getCurrentStonesToDelete: Int = this.currentStonesToDelete

  /**
    * Proof if the game needs to be initialized
    *
    * @return returns true if the game needs to be initialized
    */
  override def requireInitial: Boolean = placedStones != ALLSTONES

  /**
    * Get the playername of the current player
    *
    * @return the playername of the current player
    */
  override def getCurrentPlayerName: String = current.getName

  override def setNextPlayer: Unit = {
    if(current.equals(player1)) current = player2 else current = player1
  }

  /**
    * Get the color of the current player
    *
    * @return the color of the current player as char
    */
  override def getCurrentPlayerColor: Char = current.getColor

  override def millDeleteStone(vertex: Int): Boolean = {
    val result = removeStone(vertex)
    if(result)
      currentStonesToDelete -= 1

    this.updateObservers(vertex)

    return result
  }

  /**
    * Get the color of the vertex
    *
    * @return the vertex color as char
    */
  override def getVertexColor(vertex: Int): Char = gamefield.getColor(vertex)

  /**
    * Get the number of consumed stones from player one
    *
    * @return number of consumed stones
    */
  override def getConsumedStonesP1: Int = consumedStonesPlayer1

  /**
    * Get the number of consumed stones from player two
    *
    * @return number of consumed stones
    */
  override def getConsumedStonesP2: Int = consumedStonesPlayer2


  /**
    * resets the game
    *
    * @return true if successful, false if not
    */
  override def resetGame: Boolean = {
    init
    return gamefield.reset
  }

  /**
    * Register an Observer
    *
    * @param observer
    */
  override def registerObserver(observer: IObserver): Unit = observers += observer

  /**
    * Deregister an Observer
    *
    * @param observer
    */
  override def deregisterObserver(observer: IObserver): Unit = observers -= observer

  /**
    * Update Observers
    */
  override def updateObservers(vertex : Int): Unit = {
    if(currentStonesToDelete == 0)
      setNextPlayer

    observers.foreach(_.update(current, this.currentStonesToDelete, this.gameEnded))

    if(gameEnded) {
      // TODO: Endthread
      println("Game ended")
    }
  }


  override def getGamefieldString: String = {
    val sb = new StringBuilder

    for(i <- 1 to 24) {
      sb.append(this.getVertexColor(i))
    }

    return sb.toString()
  }
}
