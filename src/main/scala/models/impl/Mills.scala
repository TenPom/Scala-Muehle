package models.impl

import models.IMills
import scala.io.Source

class Mills extends IMills {

  val NUMBER_VERTEX = 24
  var millsArray : Array[MillsList] = new Array[MillsList](NUMBER_VERTEX)

  for (i <- 0 to millsArray.length) millsArray(i) = new MillsList()

  override def getMill(v : Int) : List[Int] =  millsArray(v - 1).millList1

  override def getMill2(v : Int) : List[Int] =  millsArray(v - 1).millList2

  def fillMillsArray : Unit = {
    for (line <- Source.fromFile("/Util/mills.txt").getLines()) {
      val node = line.split(" ")(0).toInt
      val neighbour = line.split(" ")(1).toInt
      if (line.contains("mill1"))
        millsArray(node).millList1.::(neighbour)
      if(line.contains("mills2"))
        millsArray(node).millList2.::(neighbour)
    }
  }


}

class MillsList {
  var millList1 : List[Int] = List()
  var millList2 : List[Int] = List()
}
