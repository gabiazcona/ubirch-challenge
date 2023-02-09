package tasks

import akka.actor._
import javax.inject._

object TaskActor {
  case object BackgroundTask
}

class TaskActor @Inject() () extends Actor {
  import TaskActor._


  def receive = {
    case msg: String =>
      Console.println(s"TaskActor: Message ${msg} received ")
    case msg => {
      Console.println("somethingsomething")
      sender() ! "Back task done"
    }
  }
}