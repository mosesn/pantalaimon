package com.mosesn.pantalaimon

//import com.twitter.ostrich.admin.PeriodicBackgroundProcess
//import com.twitter.ostrich.stats.Stats
import com.twitter.finagle.ServiceFactory
import com.twitter.util.{Duration, Await, Closable}
import java.net.URL
import org.jboss.netty.handler.codec.http._
import com.twitter.logging.Logger

class Poller(
  factory: ServiceFactory[HttpRequest, HttpResponse],
  name: String,
  period: Duration,
  interruptable: Boolean
) /*extends PeriodicBackgroundProcess(name, period, interruptable)*/ {
  val log = Logger.get(getClass.getName)

  val client = Await.result(factory())
  val request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/robots.txt")

  def periodic() {
    log.trace("made a request")
//    Stats.incr("robots.txt")
    try {
      // TODO MN: there seems to be a bug here
      Await.result(client(request) map { response =>
        println(response.getContent)
      })
    } catch {
      case e: Throwable => log.error(e, "exception found while making robots request")
    }
  }

  def shutdown() {
    try {
      log.warning("shutting down background process")
//      super.shutdown()
      log.warning("shut down background process")
      log.warning("shutting down connections")
      Await.result(Closable.sequence(client, factory).close())
      log.warning("shut down connections")
    }
  }
}
