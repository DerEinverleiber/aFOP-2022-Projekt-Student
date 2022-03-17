package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class PizzaImpl extends AbstractSaucable implements Pizza {

    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final double diameter;
    final static FoodBuilder<Pizza,Food.Config,Food.Variant<Pizza,Food.Config>> BUILDER= (config, variant, compatibleExtras) -> new PizzaImpl(variant.getName().equals("BBQ")?"BBQ":"Tomato",variant.getBasePrice(), variant.getBaseWeight(), variant,compatibleExtras,30);
    // TODO H2.11 Hardcode entfernen in obiger Zeile


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

    private static class Config extends AbstractSaucable.Config implements Pizza.Config  {
        private DoubleUnaryOperator unaryOperator;

        private Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> sauceOperator, DoubleUnaryOperator unaryOperator) {
          super(priceMutator, weightMutator, sauceOperator);
          this.unaryOperator = unaryOperator;
        }
        /**
         * sets the UnaryOperator for diameter with the double describing the diameter
         *
         * @param unaryOperator the UnaryOperator
         */
        @Override
        public void diameter(DoubleUnaryOperator unaryOperator) {
            this.unaryOperator = this.unaryOperator.compose(unaryOperator);
        }

        /**
         * returns the chain of all given operators as operator
         *
         * @return the chain of all given operators as operator
         */
        @Override
        public DoubleUnaryOperator getDiameterMutator() {
            return unaryOperator;
        }
    }
}
