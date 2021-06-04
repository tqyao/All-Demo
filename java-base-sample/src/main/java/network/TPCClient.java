package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TPCClient {
    public static void main(String[] args) throws IOException {
        // 连接指定ip端口
        Socket socket = new Socket ("localhost", 9090);
        try (
                InputStream is = socket.getInputStream ();
                OutputStream os = socket.getOutputStream ();
        ) {
            handler (is, os);
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            System.out.println ("disconnect");
            socket.close ();

        }
    }

    private static void handler(InputStream is, OutputStream os) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader (is));
        BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (os));

        Scanner scanner = new Scanner (System.in);
        System.out.println ("[server]" + reader.readLine ());
        for (; ; ) {
            //提示输入
            System.out.println (">>>");
            String line = scanner.nextLine ();
            // 发送给服务端
            writer.write (line);
            writer.newLine ();
            writer.flush ();
            // 接受服务端发送消息
            String response = reader.readLine ();
            System.out.println ("<<<" + response);
            if (response.equals ("bye")) {
                break;
            }
        }
    }
}
