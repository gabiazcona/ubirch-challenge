package storage


import com.google.inject.AbstractModule
import play.libs.akka.AkkaGuiceSupport


class DatabaseModule extends AbstractModule with AkkaGuiceSupport {
  override def configure(): Unit = {
    bind(classOf[Database])
        .asEagerSingleton()
  }
}
