/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/5 14:34 <br>
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //客户端创建DatagramSocket实例时并不需要指定端口，而是由操作系统自动指定一个当前未使用的端口。
        DatagramSocket ds = new DatagramSocket();
        // 设置超时时间
        ds.setSoTimeout(1000);
        // 连接服务端IP端口,实际上是没有建立连接的，只是向实例传输了服务器的IP和端口
        ds.connect(InetAddress.getByName("localhost"), 6666);
        byte[] sendDate = "hello! I am client".getBytes();
        DatagramPacket packet = new DatagramPacket(sendDate, sendDate.length);
        // 发送UDP数据包
        ds.send(packet);
        //断开连接，实际上没有连接，只是清楚了实例记录的IP和端口
        ds.disconnect();
    }
}
