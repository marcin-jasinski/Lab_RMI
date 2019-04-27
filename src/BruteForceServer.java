import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Marcin on 27.04.2019
 */
public class BruteForceServer extends BruteForceImpl {

    public BruteForceServer() {}

    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            BruteForceImpl obj = new BruteForceImpl();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            SolverInterface stub = (SolverInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();
            LoadBalancerInterface registerStub = (LoadBalancerInterface) registry.lookup("LoadBalancer");
            boolean registered = registerStub.register("BruteForceSolver", stub);

            System.err.println(registered ? "Brute force solver registered" : "Registration failed");

        } catch (Exception e) {
            System.err.println("BruteForceServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}