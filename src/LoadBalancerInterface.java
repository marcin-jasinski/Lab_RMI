import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Marcin on 27.04.2019
 */
public interface LoadBalancerInterface extends Remote {

    boolean register(String solverName, SolverInterface solverInterface) throws RemoteException;
    List<String> getRegisteredServers() throws RemoteException;
}
