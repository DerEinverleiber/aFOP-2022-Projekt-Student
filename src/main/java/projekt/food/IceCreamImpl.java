package projekt.food;

import java.math.BigDecimal;
import java.util.List;

public class IceCreamImpl implements IceCream {

    protected final BigDecimal price;
    protected final double weight;
    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final String flavor;

    /**
     * This constructor assigns its parameters to the class' attributes
     * @param price BigDecimal price
     * @param weight double weight
     * @param foodVariant Food.Variant<?, ?> foodVariant
     * @param extras List<? extends Extra<?>> extras
     * @param flavor String flavor
     */
    public IceCreamImpl(BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, String flavor) {
        this.price = price;
        this.weight = weight;
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.flavor = flavor;
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

    /**
     * The food variant.
     *
     * @return The food variant
     */
    @Override
    public Food.Variant<?, ?> getFoodVariant() {
        return foodVariant;
    }

    /**
     * The extras that this food was configured with.
     *
     * @return The extras that this food was configured with
     */
    @Override
    public List<? extends Extra<?>> getExtras() {
        return extras;
    }

    /**
     * This method returns the flavor of the ice cream
     *
     * @return flavor of the ice cream as String
     */
    @Override
    public String getFlavor() {
        return flavor;
    }
}
