package Observer

import models.IPlayer

trait IObserver {

  /**
    * Observer Update-Function
    * @param player the current Player
    * @param millsCount the current number of mills
    * @param gameEnded gamestate (ended or not)
    */
  def update (player : IPlayer, millsCount : Int, gameEnded : Boolean)
}
