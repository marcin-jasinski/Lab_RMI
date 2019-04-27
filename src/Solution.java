import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a solution returned by a knapsack solving algorithm.
 *
 * Created by Marcin on 25.02.2019
 */
public class Solution implements Serializable {

    /**
     * This field contains a summarized value of all items in a solution.
     */
    private int solutionValue;

    /**
     * This field contains a summarized weight of all items in a solution.
     */
    private int solutionWeight;

    /**
     * This field contains a {@link List} of {@link Item}s currently being in the solution.
     */
    private List<Item> itemList;

    /**
     * Creates a new solution Instance.
     * Default constructor.
     */
    public Solution(){

        this.solutionWeight = 0;
        this.solutionValue = 0;
        this.itemList = new ArrayList<>();
    }

    /**
     * This method returns the value of solutionWeight field.
     * @return summarized value of all items in solution.
     */
    public int getSolutionWeight() {
        return solutionWeight;
    }

    /**
     * This method returns the value of solutionValue field.
     * @return summarized value af all items in solution.
     */
    public int getSolutionValue() {
        return solutionValue;
    }

    /**
     * This method returns the list of {@link Item}s.
     * @return list of {@Item}s.
     */
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     * This method adds a new {@link Item} to the solution.
     * @param item item to be added to the solution.
     */
    public void addItemToSolution(Item item){
        this.itemList.add(item);
        this.solutionValue += item.getValue();
        this.solutionWeight += item.getWeight();
    }

    /**
     * This method returns an information about the solution.
     * @return String-formed solution information.
     */
    @Override
    public String toString() {
        return "Solution{" +
                "solutionValue=" + solutionValue +
                ", solutionWeight=" + solutionWeight +
                ", itemList=" + itemList +
                '}';
    }
}
