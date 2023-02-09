package storage

import javax.inject._


@Singleton
class Database {
  val someData = "datita"

  val dataModelM = new DataModelM(List(User(1, "a", "b")), List("proc"), List("prov"))
}
