import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Try to create the registry, or use the existing one if it's already there
            try {
                LocateRegistry.createRegistry(1099);
                System.out.println("RMI registry created on port 1099.");
            } catch (Exception e) {
                System.out.println("RMI registry already running, using existing one.");
            }
            
            CalculatorImpl obj = new CalculatorImpl();
            
            // Bind the object
            Naming.rebind("rmi://localhost/Calculator", obj);
            
            System.out.println("RMI Server is connected and ready...");

        } catch (Exception e) {
            System.out.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}