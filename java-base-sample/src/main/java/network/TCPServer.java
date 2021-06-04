package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //监听9090端口
        ServerSocket serverSocket = new ServerSocket (9090);
        System.out.println ("server is running...");
        // 循环监听接受连接
        for (; ; ) {
            // 阻塞等待连接
            Socket accept = serverSocket.accept ();
            System.out.println ("connect from " + accept.getRemoteSocketAddress ());
            // 为每一个创建新线程处理
            Thread thread = new Handler (accept);
            thread.start ();
        }
    }
}

class Handler extends Thread {

    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                InputStream is = socket.getInputStream ();
                OutputStream os = socket.getOutputStream ()
        ) {
            handler (is, os);
        } catch (IOException e) {

        }finally {
            if (socket != null) {
                try {
                    socket.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            System.out.println ("client socket disconnect");
        }
    }

    private void handler(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
        BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (outputStream));

        // 建立连接成功发送给客户端消息
        writer.write ("hello\n");
        writer.flush ();
        for (;;){
            // 读取客户端发来的消息
            String line = reader.readLine ();
            if (line.equals ("bye")){
                writer.write ("bye\n");
                writer.flush ();
                break;
            }
            writer.write ("ok:" + line + "\n");
            writer.flush ();
        }
    }
}
