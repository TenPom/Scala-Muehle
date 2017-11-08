package models.impl

import models.IMills
import scala.io.Source

/**
  * Controls the mills on the gamefield
  * @author Patrick Schmidt
  * @since 06.11.2017
  */
class Mills extends IMills {

  /**
    * Number of Fields on the gamefield
    */
  val NUMBER_VERTEX = 24

  /**
    * matrix of possible mills
    */
  var millsArray : Array[MillsList] = new Array[MillsList](NUMBER_VERTEX)

  for (i <- 0 to millsArray.length) millsArray(i) = new MillsList()

  /**
    * Returns the first possible mill of the vertex
    * @param v vertex
    * @return the list of vertexes who are included in the mill
    */
  override def getMill(v : Int) : List[Int] =  millsArray(v - 1).millList1

  /**
    * Returns the second possible mill of the vertex
    * @param v vertex
    * @return the list of vertexes who are included in the mill
    */
  override def getMill2(v : Int) : List[Int] =  millsArray(v - 1).millList2

  /**
    * Maps the possible mills to the list
    */
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

/**
  * Helperclass for possible mills
  */
class MillsList {
  var millList1 : List[Int] = List()
  var millList2 : List[Int] = List()
}
