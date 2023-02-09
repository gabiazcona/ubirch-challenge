package tasks

import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport


class TaskModule extends AbstractModule with AkkaGuiceSupport {
  override def configure = {
    bindActor[TaskActor]("task-actor")
  }
}

// import play.api.inject.SimpleModule
// import play.api.inject._

// class TasksModule extends SimpleModule(bind[TaskActor].toSelf.eagerly())
