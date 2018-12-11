package view.tui

import Observer.IObserver
import models.IPlayer

class tui extends IObserver{
  /**
    * Observer Update-Function
    *
    * @param player     the current Player
    * @param millsCount the current number of mills
    * @param gameEnded  gamestate (ended or not)
    */
  override def update(player: IPlayer, millsCount: Int, gameEnded: Boolean): Unit = ???
}
