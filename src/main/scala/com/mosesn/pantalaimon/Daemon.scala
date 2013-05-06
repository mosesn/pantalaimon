package com.mosesn.pantalaimon

import com.twitter.ostrich.admin.{ServiceTracker, AdminServiceFactory, RuntimeEnvironment, Service}
import com.twitter.logging.Logger

object Daemon {
  val log = Logger.get(getClass.getName)

  def main(args: Array[String]) {
    val port = 9900
    try {
      val env = RuntimeEnvironment(this, args)
      startAdmin(port, env)
      startProcess(env)
    } catch {
      case e: Throwable => {
        errorShutdown(e)
      }
    }
  }

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
    ServiceTracker.register(process)
  }

  def errorShutdown(error: Throwable) {
    log.error(error, "there was an error starting up")
    log.warning("shutting down all services")
    ServiceTracker.shutdown()
    log.warning("shut down all services")
    System.exit(1)
  }
}
