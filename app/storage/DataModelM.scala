package storage

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import javax.inject.Inject

class DataModelM (users: List[User], processess: List[String], provider: List[String]) {

    def getUsersTable(): List[User] = ???

    def getUserLock(userId: String) = {
        // lock user with id user id
        Console.println(s"locking -> $userId")
    }

    def userUnlock(userId: String)  = {
        Console.println(s"unlocking -> $userId")
    }

    def getProcessLock(processId: Long)  = {
        // lock user with id process id
        Console.println(s"locking -> $processId")
    }

    def getProviderLock(providerId: Long)  = {
        // lock user with id user.id
        Console.println(s"locking -> $providerId")
    }
}

case class User(id: Long, name: String, email: String)
