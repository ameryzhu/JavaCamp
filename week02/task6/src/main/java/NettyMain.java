import io.netty.bootstrap.Bootstrap;

public class NettyMain {
    public static void main(String[] args) {
        NettyServer server = new NettyServer();
        server.start(8801);
    }
}
