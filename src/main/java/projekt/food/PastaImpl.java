package projekt.food;

import java.math.BigDecimal;
import java.util.List;

public class PastaImpl extends AbstractSaucable implements Pasta {

    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final double thickness;

    /**
     * This constructor assigns its parameters to the class' attributes
     * @param sauce String sauce
     * @param price BigDecimal price
     * @param weight double weight
     * @param foodVariant Food.Variant<?, ?> food variant
     * @param extras List<? extends Extra<?>> extras
     */
    public PastaImpl(String sauce, BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, double thickness){
        super(sauce, price, weight);
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.thickness = thickness;
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
     * This method returns the thickness of the noodles
     *
     * @return thickness of the noddles as double
     */
    @Override
    public double getThickness() {
        return thickness;
    }
}
