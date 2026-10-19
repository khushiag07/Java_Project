
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);

            System.out.println("Connected to Server!");

            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );

            String response = input.readLine();
            System.out.println("Server says: " + response);

            output.println("Hello Client!");

            socket.close();

            System.out.println("Connection closed");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
