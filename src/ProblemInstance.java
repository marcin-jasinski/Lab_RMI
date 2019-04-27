import java.io.Serializable;
import java.util.List;

/**
 * This class represents a problem instance in a discrete knapsack problem.
 *
 * Created by Marcin on 25.02.2019
 */
public class ProblemInstance implements Serializable {

    /**
     * This field contains the maximum knapsack capacity in a problem instance.
     */
    private int capacity;

    /**
     * This field contains a {@link List} of an {@link Item} Objects.
     */
    private List<Item> itemList;

    /**
     * Creates a new problem instance.
     * @param capacity maximum knapsack capacity.
     * @param itemList list of Items for the problem instance.
     */
    public ProblemInstance(int capacity, List<Item> itemList) {
        this.capacity = capacity;
        this.itemList = itemList;
    }

    /**
     * This method returns the maximum knapsack capacity.
     * @return maximum knapsack capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method returns the list of items in a problem instance.
     * @return list of {@link Item}s.
     */
    public List<Item> getItemList() {
        return itemList;
    }
}
