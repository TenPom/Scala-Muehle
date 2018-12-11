package view.tui

import Observer.IObserver
import controler.IController
import models.IPlayer

class tui(val controller: IController) extends IObserver {


  /**
    * Observer Update-Function
    *
    * @param player     the current Player
    * @param millsCount the current number of mills
    * @param gameEnded  gamestate (ended or not)
    */
  override def update(player: IPlayer, millsCount: Int, gameEnded: Boolean): Unit = {
    var log : String = ""

    if (gameEnded)
      log = player.getName() + " hat gewonnen!";
    else if (millsCount > 0) {
      if (millsCount == 1)
        log = player.getName() + " hat eine Muehle, entferne einen Stein!"
      else if (millsCount == 2)
        log = player.getName() + " hat zwei Muehle, entferne zwei Steine!"
    }
    else
      log = player.getName() + " ist an der Reihe"

    clear()
  }


  def display() : String = {
    var log : String = ""

    log = "\n%1-----------%2-----------%3\t\t" + "1-----------2-----------3\n" +
          "|           |           |\t\t"             + "|           |           |\n"  +
          "|   %4-------%5-------%6   |\t\t"          + "|   4-------5-------6   |\n"  +
          "|   |       |       |   |\t\t"             + "|   |       |       |   |\n"  +
          "|   |   %7---%8---%9   |   |\t\t"          + "|   |   7---8---9   |   |\n"  +
          "|   |   |       |   |   |\t\t"             + "|   |   |       |   |   |\n"  +
          "%10---%11---%12       %13---%14---%15\t\t" + "10--11--12      13--14--15\n" +
          "|   |   |       |   |   |\t\t"             + "|   |   |       |   |   |\n"  +
          "|   |   %16---%17---%18   |   |\t\t"       + "|   |   16--17--18  |   |\n"  +
          "|   |       |       |   |\t\t"             + "|   |       |       |   |\n"  +
          "|   %19-------%20-------%21   |\t\t"       + "|   19------20------21  |\n"  +
          "|           |           |\t\t"             + "|           |           |\n"  +
          "%22-----------%23-----------%24\t\t"       + "22----------23----------24\n";

    val keyList = (1 to 24).toList

    val tupleList = keyList.map( key => ( key, controller.getVertexColor((key))))

    for ((index, value) <- tupleList)
      log.replace("%" + index, value + "")

    log
  }

  def clear() : Unit = {
    val log : String = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"

    println(log)
  }
}
