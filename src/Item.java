import java.io.Serializable;

/**
 * This class represents a single item in a discrete knapsack problem.
 *
 * Created by Marcin on 25.02.2019
 */
public class Item implements Serializable {

    /**
     * This field contains weight of an item.
     */
    private int weight;

    /**
     * This field contains value of an item.
     */
    private double value;

    /**
     * This field contains a weight-to-value ratio, used in greedy solution approach.
     */
    private double weightValueRatio;

    /**
     * Creates a new Item instance.
     * Weight-to-value ratio is calculated automatically.
     *
     * @param weight weight of a new Item.
     * @param value value of a new Item.
     */
    public Item(int weight, double value) {
        this.weight = weight;
        this.value = value;

        this.weightValueRatio = this.weight / this.value;
    }

    /**
     * This method returns the weight of an Item.
     * @return weight of an Item.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * This method returns the value(price) of an Item.
     * @return value of an Item.
     */
    public double getValue() {
        return value;
    }

    /**
     * This method returns the weight-to-value ratio of an Item.
     * @return weight-to-value ratio.
     */
    public double getWeightValueRatio() {
        return weightValueRatio;
    }

    /**
     * This method returns the information about solution.
     * @return String-formed solution information.
     */
    @Override
    public String toString() {
        return "{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
