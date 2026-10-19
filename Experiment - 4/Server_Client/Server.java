
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);

            System.out.println("Server Started....");
            System.out.println("Waiting for Client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client is connected");

            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );

            output.println("Hello server");

            String response = input.readLine();

            System.out.println("Server says: " + response);

            socket.close();
            serverSocket.close();

            System.out.println("Connection closed");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
