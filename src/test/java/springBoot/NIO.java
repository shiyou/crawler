package springBoot;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by hjd on 17-6-11.
 */
public class NIO {


    public void BIOTest() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4700);
            while (true) {
                System.out.print("服务端已经启动");
                //服务端通过accept阻塞,直到有客户端到达
                Socket clientSockect = serverSocket.accept();
                SocketAddress clientAddress = clientSockect.getRemoteSocketAddress();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
