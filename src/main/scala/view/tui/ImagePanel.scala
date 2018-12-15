package view.tui

import java.io.{BufferedReader, InputStream, InputStreamReader}
import javax.imageio.ImageIO

import javax.imageio.ImageIO
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.awt.{Color, Graphics}

import controler.IController

import scala.swing._

class ImagePanel(controller: IController) extends Panel {

  val RESIZEOVAL: Int = 16
  val SIZEEMPTYTOKEN: Int = 8

  val ARRAYSIZE: Int = 25
  val VERTEXS: Int = 24
  var graphic: Graphics = null

  val pic: Image = ImageIO.read(getClass.getResourceAsStream("/spielbtrzz.jpg"))

  var emptyTokens = Array[EmptyToken]()

  val xydiffs = Array.ofDim[Double](VERTEXS, 2)

  var select1: Int = 0

  fillXYdiffs

  def fillXYdiffs : Unit = {
    val stream: InputStream = getClass.getResourceAsStream("/pixeltab.txt")

    val in: BufferedReader = new BufferedReader(new InputStreamReader(stream))

    var line: String = ""

    var i: Int = 0

    while ((line = in.readLine()) != null) {
      var splitLine: Array[String] = line.split(" ")
      xydiffs(i)(0) = splitLine(0).toDouble
      xydiffs(i)(1) = splitLine(1).toDouble
      i + 1
    }
    in.close()
  }

  def paintComponent(g: Graphics): Unit = {
    this.graphic = g
    g.drawImage(pic, 0, 0, preferredSize.width, preferredSize.height, null)
    paintTokens
    fillWithEmptyTokens
  }

  def paintToken (vertex : Int) : Unit = {
    var xdiff : Int = (Math.round(this.preferredSize.width / xydiffs(vertex - 1)(0))).toInt
    var ydiff : Int = (Math.round(this.preferredSize.height / xydiffs(vertex - 1)(1))).toInt
    graphic.setColor(Color.RED)
    graphic.fillOval(preferredSize.width - xdiff, preferredSize.height - ydiff,
      preferredSize.width / RESIZEOVAL, preferredSize.height / RESIZEOVAL)

  }


  def paintTokens : Unit = {
    for (i <- 1 to ARRAYSIZE) {
      var stoneColor : Color = Color.WHITE

      if (controller.getVertexColor(i) == 's') {
        stoneColor = Color.BLACK
      }
      else if (controller.getVertexColor(i) == "w")
      {
          stoneColor = Color.WHITE
      }
      var xdiff : Int = (Math.round(this.preferredSize.width / xydiffs(i - 1)(0))).toInt
      var ydiff : Int = (Math.round(this.preferredSize.height / xydiffs(i - 1)(1))).toInt
      graphic.setColor(stoneColor)
      graphic.fillOval(preferredSize.width - xdiff, preferredSize.height - ydiff,
        preferredSize.width / RESIZEOVAL, preferredSize.height / RESIZEOVAL)

    }
  }

  def setSelected(vertex: Int): Unit = {
    if (controller.getVertexColor(vertex) != 'n')
      {
        if (select1 == 0) {
          select1 = vertex
          paintTokens
          paintToken(vertex)
        } else {
          controller.moveStone(select1, vertex)
          select1 = 0
        }
      }
  }

  def fillWithEmptyTokens : Unit = {
    var sizeX : Int = preferredSize.width / SIZEEMPTYTOKEN
    var sizeY : Int = preferredSize.height / SIZEEMPTYTOKEN
    var xdiff : Int = 0
    var ydiff : Int = 0

    for (i <- 1 to ARRAYSIZE)
      {
        xdiff = (Math.round(preferredSize.width / xydiffs(i - 1)(0))).toInt
        ydiff = (Math.round(preferredSize.height / xydiffs(i - 1)(1))).toInt
        emptyTokens(i) = new EmptyToken(controller, i, preferredSize.width - xdiff, preferredSize.height - ydiff, sizeX, sizeY)

      }
  }

}
