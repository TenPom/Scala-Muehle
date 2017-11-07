package controler

trait IController {

  def setStone(vertex : Int) : Boolean
  def setStone (vertex : Int, color : Char) : Boolean
  def moveStone (startVertex : Int, endVertex : Int) : Boolean
  def removeStone (vertex : Int) : Boolean
  def getCountClosedMills (vertex : Int) : Int
  def gameEnded : Boolean
  def getWinningPlayer : String
  def millDeleteStone (vertex : Int) : Boolean
  def getCurrentStonesToDelete : Int
  def requireInitial : Boolean
  def getCurrentPlayerName : String
  def getCurrentPlayerColor : Char
  def selectNextPlayer : Unit
  def getVertexColor : Char
  def getConsumedStonesP1 : Int
  def getConsumedStonesP2 : Int
  def getGamefieldString : String
  def resetGame : Boolean
}
