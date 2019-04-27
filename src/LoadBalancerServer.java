import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Marcin on 27.04.2019
 */
public class LoadBalancerServer {

    public LoadBalancerServer() {}

    public static void main(String[] args) {

        try {
            // Instantiating the implementation class
            LoadBalancerImpl obj = new LoadBalancerImpl();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            LoadBalancerInterface stub = (LoadBalancerInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("LoadBalancer", stub);
            System.err.println("Load Balancer ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
