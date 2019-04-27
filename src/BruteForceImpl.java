import java.rmi.RemoteException;

/**
 * Created by Marcin on 27.04.2019
 */
// Implementing the remote interface
public class BruteForceImpl implements SolverInterface {

    // Implementing the interface method
    @Override
    public Solution solve(ProblemInstance problemInstance) throws RemoteException {

        Solution bestSolution = new Solution();
        int itemsNumber = problemInstance.getItemList().size();

        for(int i = 0; i < 2 << itemsNumber; i++){

            Solution currentSolution = new Solution();
            for(int j = 0; j < itemsNumber; j++){

                if((i & 2 << j) != 0){
                    currentSolution.addItemToSolution(problemInstance.getItemList().get(j));
                }
            }

            if(currentSolution.getSolutionValue() != 0) {
                if (currentSolution.getSolutionWeight() <= problemInstance.getCapacity() && //
                        currentSolution.getSolutionValue() > bestSolution.getSolutionValue()) {

                    bestSolution = currentSolution;
                }
            }
        }

        return bestSolution;
    }
}