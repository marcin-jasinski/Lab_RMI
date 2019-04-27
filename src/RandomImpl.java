import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Marcin on 27.04.2019
 */
public class RandomImpl implements SolverInterface {

    @Override
    public Solution solve(ProblemInstance problemInstance) throws RemoteException {

        Solution bestSolution = new Solution();
        List<Item> itemList = problemInstance.getItemList();

        for(int i = 0; i < 100; i++) {

            Solution currentSolution = new Solution();
            List<Integer> alreadyChosenItems = new ArrayList<>();
            int randomItemIndex;

            while (currentSolution.getSolutionWeight() <= problemInstance.getCapacity()) {

                do {
                    randomItemIndex = ThreadLocalRandom.current().nextInt(0, itemList.size());

                } while (alreadyChosenItems.contains(randomItemIndex));

                if (currentSolution.getSolutionWeight() + itemList.get(randomItemIndex).getWeight() > problemInstance.getCapacity()){
                    break;
                }

                alreadyChosenItems.add(randomItemIndex);
                currentSolution.addItemToSolution(itemList.get(randomItemIndex));
            }

            if (currentSolution.getSolutionValue() != 0) {
                if (currentSolution.getSolutionWeight() <= problemInstance.getCapacity() && //
                        currentSolution.getSolutionValue() > bestSolution.getSolutionValue()) {

                    bestSolution = currentSolution;
                }
            }
        }

        return bestSolution;
    }
}
