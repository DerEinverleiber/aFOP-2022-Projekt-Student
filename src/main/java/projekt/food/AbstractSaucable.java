package projekt.food;

import java.math.BigDecimal;
import java.util.List;

abstract public class AbstractSaucable implements Saucable {

    protected final String sauce;
    protected final BigDecimal price;
    protected final double weight;

    /**
     * This constructor assigns its parameters to the class' attributes
     * @param sauce String sauce
     * @param price BigDecimal price
     * @param weight double weight
     */
    public AbstractSaucable(String sauce, BigDecimal price, double weight){
        this.sauce = sauce;
        this.price = price;
        this.weight = weight;
    }

    /**
     * This method returns the type of sauce
     *
     * @return String regarding the sauce
     */
    @Override
    public String getSauce() {
        return sauce;
    }

    /**
     * The price of this food.
     *
     * @return The price of this food
     */
    @Override
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * The weight of this food.
     *
     * @return The weight of this food
     */
    @Override
    public double getWeight() {
        return weight;
    }
}
