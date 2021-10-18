package Job4j.it.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if(str.split(" ")[1].equals("/?msg=Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                            break;
                        } else if(str.split(" ")[1].equals("/?msg=Exit")) {
                           server.close();
                           break;
                       } else {
                            out.write("What?".getBytes());
                            break;
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
