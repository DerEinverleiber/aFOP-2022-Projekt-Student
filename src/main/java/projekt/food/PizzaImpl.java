package projekt.food;

import java.math.BigDecimal;
import java.util.List;

public class PizzaImpl extends AbstractSaucable implements Pizza {

    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final double diameter;

    /**
     * This constructor assigns its parameters to the class' attributes
     * @param sauce String sauce
     * @param price BigDecimal price
     * @param weight double weight
     * @param foodVariant Food.Variant<?, ?> food variant
     * @param extras List<? extends Extra<?>> extras
     */
    public PizzaImpl(String sauce, BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, double diameter){
        super(sauce, price, weight);
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.diameter = diameter;
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
     * This method returns the diameter of the pizza
     *
     * @return diameter of type double
     */
    @Override
    public double getDiameter() {
        return diameter;
    }

}
