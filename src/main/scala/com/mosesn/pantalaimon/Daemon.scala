package com.mosesn.pantalaimon

import com.twitter.logging.Logger
import com.twitter.server.TwitterServer

object Daemon extends TwitterServer {
  def main() {
//    val port = 9900
//    try {
//      val env = RuntimeEnvironment(this, args)
//      startAdmin(port, env)
//      startProcess(env)
//    } catch {
//      case e: Throwable => {
//        errorShutdown(e)
//      }
//    }
  }
/*
  def startAdmin(port: Int, env: RuntimeEnvironment) {
    log.warning("starting admin service")
    val admin = AdminServiceFactory(port)(env)
    log.warning("started admin service")
  }

  def startProcess(env: RuntimeEnvironment) {
    val process = env.loadConfig[Service]
    log.warning("starting process")
    process.start()
    log.warning("started process")
    onExit {
      process.shutdown()
    }
  }

  def errorShutdown(error: Throwable) {
    log.error(error, "there was an error starting up")
    log.warning("shutting down all services")
    log.warning("shut down all services")
    System.exit(1)
  }
 */
}
