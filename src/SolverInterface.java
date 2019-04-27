/**
 * Created by Marcin on 27.04.2019
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface SolverInterface extends Remote {

    Solution solve(ProblemInstance problemInstance) throws RemoteException;
}