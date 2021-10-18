package Job4j.it.InputOutput;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TempServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket clientside = serverSocket.accept();
            OutputStreamWriter writer = new OutputStreamWriter(clientside.getOutputStream());
            writer.write("<h2>Hello</h2>");
            writer.flush();
            writer.close();

            clientside.close();
        }
    }

}
