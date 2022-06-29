import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
public class Server {

    public static void main(String[] args) throws SQLException {
        ServerSocket server = null;
        try {
            System.out.println(".......server......");
            System.out.println("Waiting for connection....");
            // creating the socket with port 909
            server = new ServerSocket(909);
            while (true) {
                Socket c = server.accept();
                System.out.println("client accepted ... ");
                ClientHandler ch = new ClientHandler(c);
                // use the multi threading techniques
                Thread th = new Thread(ch);
                th.start();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                server.close();
            } catch (IOException e) {
            }
        }
    }
}
