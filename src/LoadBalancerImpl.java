import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 27.04.2019
 */
public class LoadBalancerImpl implements LoadBalancerInterface {

    @Override
    public boolean register(String solverName, SolverInterface solverInterface) throws RemoteException {

        Registry registry = LocateRegistry.getRegistry();
        try {
            registry.bind(solverName, solverInterface);
            return true;
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> getRegisteredServers() {

        List<String> registeredServices = new ArrayList<>();
        try {
            Registry registry = LocateRegistry.getRegistry();
            final String[] list = registry.list();
            for(String s : list) registeredServices.add(s);

        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return registeredServices;
    }
}
