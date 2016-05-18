package com.akkademy
import akka.actor.Actor;
import scala.collection.mutable.HashMap
import akka.event.Logging
import com.akkademy.messages.SetRequest

class AkkademyDb extends Actor {
  val map = new HashMap[String,Object]
  val log = Logging(context.system, this)
  
  override def receive = {
    case SetRequest(key, value) => 
      map.put(key, value)
      log.info("Received Set-Request message - key: {} value: {}",key,value)
    case o => log.info("received unknown message: {}",o);
  }
  
}