package tasks

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

import akka.actor.ActorRef
import akka.actor.ActorSystem

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

@Singleton
class Tasks @Inject() (actorSystem: ActorSystem, @Named("task-actor") taskActor: ActorRef)(
    implicit executionContext: ExecutionContext
) {
  actorSystem.scheduler.scheduleAtFixedRate(
    initialDelay = 0.microseconds,
    interval = 3.seconds,
    receiver = taskActor,
    message = "tick"
  )

  actorSystem.scheduler.scheduleAtFixedRate(
    initialDelay = 0.microseconds,
    interval = 3.seconds
  ) { () => {
    Console.println("scheduler Tasks")
    }
  }
}