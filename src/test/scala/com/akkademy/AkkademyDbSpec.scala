package com.akkademy

import org.scalatest.FunSpec
import org.scalatest.Matchers
import org.scalatest.BeforeAndAfterEach
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.messages.SetRequest

class AkkademyDbSpec extends FunSpec with Matchers with BeforeAndAfterEach{
  implicit val system = ActorSystem()
  describe("akkademyDb") {
     describe("given set request")  {
       it("should place key/value pair in map") {
         val actorRef = TestActorRef(new AkkademyDb)
         actorRef ! SetRequest("key","value");
         val akkademyDb = actorRef.underlyingActor
         akkademyDb.map.get("key") should equal(Some("value"))
       }
     }
  }
}