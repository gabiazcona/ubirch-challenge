package actors

import com.google.inject.AbstractModule
import play.libs.akka.AkkaGuiceSupport


class ActorsModule extends AbstractModule with AkkaGuiceSupport {
  override def configure(): Unit = {
    bindActor(classOf[BackgroundTaskAActor], "background-task-a-actor")
    bindActor(classOf[BackgroundTaskBActor], "background-task-b-actor")
    bindActor(classOf[BackgroundTaskCActor], "background-task-c-actor")
  }
}