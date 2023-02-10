package controllers

import akka.actor.{ActorRef, ActorSystem}
import javax.inject._
import org.joda.time.DateTime
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.language.postfixOps

import storage.Database

@Singleton
class BackgroundTaskController @Inject()(
    val controllerComponents: ControllerComponents,
    val actorSystem: ActorSystem,
    @Named("background-task-a-actor") backAactor: ActorRef,
    @Named("background-task-b-actor") backBactor: ActorRef,
    @Named("background-task-c-actor") backCactor: ActorRef,
    val database: Database)(implicit ec: ExecutionContext) extends BaseController {

    val backgroundTaskA = actorSystem.scheduler.scheduleAtFixedRate(
        initialDelay = 0.microseconds,
        interval = 6.seconds,
        receiver = backAactor,
        message = "BackgroundTaskA"
    )
    val backgroundTaskB = actorSystem.scheduler.scheduleAtFixedRate(
        initialDelay = 0.microseconds,
        interval = 3.seconds,
        receiver = backBactor,
        message = "BackgroundTaskB"
    )
    val backgroundTaskC = actorSystem.scheduler.scheduleAtFixedRate(
        initialDelay = 0.microseconds,
        interval = 12.seconds,
        receiver = backCactor,
        message = "BackgroundTaskC"
    )

  def runAsync(): Action[AnyContent] = Action {
    Ok
  }
}
