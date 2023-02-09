package actors

import akka.actor.Actor

import storage.Database
import javax.inject.Inject
import scala.concurrent.ExecutionContext
import storage.User
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.Future

class BackgroundTaskAActor @Inject()(database: Database) extends Actor {

  override def receive: Receive = {
    case msg: String => {
        Console.println(s"BackgroundTaskActor: Message ${msg} received and database: ${database.someData}")
        process(List(msg))
    }
  }
  
  def process(users: List[String]): Unit = {
    Console.println("backgroundtaskA process")
    users.map{userId => 
      database.dataModelM.getUserLock(userId)
      processUser(userId)
      database.dataModelM.userUnlock(userId)
    }
  }

  def processUser(user: String) = {
    Console.println("processing user...")
  }
}

class BackgroundTaskBActor @Inject()(database: Database) extends Actor {
  override def receive: Receive = {
    case msg: String => {
        Console.println(s"BackgroundTaskBActor: Message ${msg} received and database: ${database.someData}")
        msg match {
            case "BackgroundTaskB" => process(List(msg))
        }
    }
  }

  def process(users: List[String]) = 
    Console.println("backgroundtaskB process")

}
class BackgroundTaskCActor @Inject()(database: Database) extends Actor {
  override def receive: Receive = {
    case msg: String => {
        Console.println(s"BackgroundTaskCActor: Message ${msg} received and database: ${database.someData}")
        msg match {
            case "BackgroundTaskC" => process(List(msg))
        }
    }
  }

  def process(users: List[String]) = 
    Console.println("backgroundtaskC process")

}
