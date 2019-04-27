import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Marcin on 27.04.2019
 */
public class RandomServer {

    public RandomServer() {}

    public static void main(String[] args) {

        try {
            // Instantiating the implementation class
            RandomImpl obj = new RandomImpl();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            SolverInterface stub = (SolverInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();
            LoadBalancerInterface registerStub = (LoadBalancerInterface) registry.lookup("LoadBalancer");
            boolean registered = registerStub.register("RandomSolver", stub);

            System.err.println(registered ? "Random solver registered" : "Registration failed");

        } catch (Exception e) {
            System.err.println("RandomServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
