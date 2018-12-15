package  view.tui

import controler.IController
import java.awt.{Color, Font, GridLayout}

import scala.swing._
import scala.swing.BorderPanel.Position._
import Observer.IObserver
import models.IPlayer

class Gui(val controller: IController) extends MainFrame with IObserver {

  title = "Muehle Spiel"
  minimumSize = new Dimension(650, 500)
  maximumSize = new Dimension(650, 500)
  controller.registerObserver(this)

  val FONT : String = "SANS_SERIF"
  val HEADERFONTSIZE : Int = 30
  val PLAYERFONTSIZE : Int = 20
  val STONESPLAYERMAX : Int = 9
  val FONTSIZESTONE : Int = 12
  val FONTSIZESTONES : Int = 14

  val PANELSIZEX : Int = 100
  val PANELSIZEY : Int = 500

  val GRIDX : Int = 10

  val titleLabel = new Label {
    text = "MuehleSpiel"
    background = Color.BLACK
    foreground = Color.RED
    opaque = true
    font = new Font(FONT, Font.ITALIC, HEADERFONTSIZE)
  }

  val playerInfo = new Label {
    background = Color.GREEN
    foreground = Color.RED
    opaque = true
    font = new Font(FONT, Font.ITALIC, PLAYERFONTSIZE)
  }

  val player1 = new Label {
    text = "Steine Player 1"
    background = Color.YELLOW
    foreground = Color.BLACK
    font = new Font(FONT, Font.ITALIC, FONTSIZESTONES)
    opaque = true
  }

  val countStonesPlayer1 = new Label {
    text = "" + (STONESPLAYERMAX - controller.getConsumedStonesP1)
    font = new Font(FONT, Font.ITALIC, FONTSIZESTONES)
  }

  val player2 = new Label {
    text = "Steine Player 2"
    background = Color.YELLOW
    foreground = Color.BLACK
    font = new Font(FONT, Font.ITALIC, FONTSIZESTONES)
    opaque = true
  }

  val countStonesPlayer2 = new Label {
    text = "" + (STONESPLAYERMAX - controller.getConsumedStonesP2)
    font = new Font(FONT, Font.ITALIC, FONTSIZESTONES)
  }

  val leftPanel = new Panel {
    player1
    countStonesPlayer1
    background = Color.YELLOW
    preferredSize = new Dimension(100, 500)
    new GridLayout(GRIDX, 1)
    opaque = true
  }

  val rightPanel = new Panel {
    player2
    countStonesPlayer2
    background = Color.YELLOW
    preferredSize = new Dimension(100, 500)
    new GridLayout(GRIDX, 1)
    opaque = true
  }

  val backgroundPic = new ImagePanel(controller)

  contents = new BorderPanel() {
    layout(titleLabel) = North
    layout(backgroundPic) = Center
    layout(leftPanel) = West
    layout(rightPanel) = East
    layout(playerInfo) = South
  }

  def beginSetPlayerInfo : Unit = {
    playerInfo.text = "Willkommen! Player 1 darf beginnen"
  }

  def setPlayerInfo(playername: String, status : String) : Unit = {
    playerInfo.text = playername + " " + status
  }

  /**
    * Observer Update-Function
    *
    * @param player     the current Player
    * @param millsCount the current number of mills
    * @param gameEnded  gamestate (ended or not)
    */
  override def update(player: IPlayer, millsCount: Int, gameEnded: Boolean): Unit = {
    countStonesPlayer1.text = "" + (STONESPLAYERMAX - controller.getConsumedStonesP1)
    countStonesPlayer2.text = "" + (STONESPLAYERMAX - controller.getConsumedStonesP2)

    if (gameEnded)
      setPlayerInfo(player.getName, " hat gewonnen!")
    else if (millsCount > 0) {
      if (millsCount == 1)
        setPlayerInfo(player.getName, " hat eine Muehle, loesche einen Stein!")
      else
        setPlayerInfo(player.getName, " hat zwei Muehlen, loesche zwei Steine!")
    } else
      setPlayerInfo(player.getName, " ist an der Reihe!")
    backgroundPic.paintTokens
  }
}