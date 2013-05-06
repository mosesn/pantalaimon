import com.twitter.util.Config
import com.twitter.finagle.{Http, Group}
import com.mosesn.pantalaimon.Poller
import com.twitter.util.TimeConversions.intToTimeableNumber
import java.net.{InetSocketAddress, SocketAddress}

new Config[Poller] {
  override def apply(): Poller = {
    val client = Http.newClient(Group(new InetSocketAddress("http://www.google.com", 80).asInstanceOf[SocketAddress]))
    new Poller(client, "pantalaimon", 5.seconds, true)
  }
}
