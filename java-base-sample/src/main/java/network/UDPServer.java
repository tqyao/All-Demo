package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // 监听6666端口
        DatagramSocket ds = new DatagramSocket(6666);
        System.out.println("udp server running...");
        for (; ; ) {
            // 数据缓冲区
            byte[] by = new byte[1024];
            DatagramPacket packet = new DatagramPacket(by, by.length);
            // 收取一个UDP数据包
            ds.receive(packet);
            System.out.println("connect ip/port => " + packet.getSocketAddress() + "/" + packet.getPort());
            // 收取到的数据存储在buffer中，由packet.getOffset(), packet.getLength()指定起始位置和长度
            String receiveStr = new String(packet.getData(),
                    packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);

            System.out.println(receiveStr);
            // 发送数据到客户端
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            ds.send(packet);
        }
    }
}
