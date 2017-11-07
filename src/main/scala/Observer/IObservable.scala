package Observer

trait IObservable {

  /**
    * Register an Observer
    * @param observer
    */
  def registerObserver (observer: IObserver) : Unit

  /**
    * Deregister an Observer
    * @param observer
    */
  def deregisterObserver (observer: IObserver) : Unit

  /**
    * Update Observers
    */
  def updateObservers : Unit
}
