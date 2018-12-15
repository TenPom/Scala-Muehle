package view.tui

import java.awt.event.{MouseEvent, MouseListener}

import controler.IController

import scala.swing.Label

class EmptyToken(controller: IController, index: Int, xPos: Int, yPos: Int, sizeX: Int, sizeY: Int) extends Label with MouseListener {

  location.x = xPos
  location.y = yPos
  size.width = sizeX
  size.height = sizeY

  def getNumber : Int = index

  override def mouseExited(e: MouseEvent) = ???

  override def mouseReleased(e: MouseEvent) = ???

  override def mouseEntered(e: MouseEvent) = ???

  override def mousePressed(e: MouseEvent) = ???

  override def mouseClicked(e: MouseEvent) = {
    if (controller.getCurrentStonesToDelete > 0)
      controller.millDeleteStone(getNumber)
    else if (controller.requireInitial)
      controller.setStone(getNumber)
    else
      controller.moveStone(getNumber)
  }
}
