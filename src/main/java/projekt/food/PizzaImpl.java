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

    private static class Config extends AbstractSaucable.Config implements Pizza.Config {
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

    static class Variant<F extends PizzaImpl,C extends Config> extends AbstractSaucable.Variant<PizzaImpl,Config>{
        /**
         * The constructor initializes the parameters
         * @param name the name
         * @param foodType the foodType
         * @param basePrice the basePrice
         * @param baseWeight the baseWeight
         */
        public Variant(String name, FoodType<PizzaImpl, PizzaImpl.Config> foodType, BigDecimal basePrice, double baseWeight){
            super(name,foodType,basePrice,baseWeight);
        }
        /**
         * Creates a new instance of {@link Food} described by this variant, its base values and modifications defined by the
         * provided list of {@link Extra Extras}.
         *
         * <p>
         * The provided extras are applied to an instance of {@link Config}. After this config has
         * been fully "configured" by the extras, the base values from this variant are supplied to the config's mutators to
         * calculate the food's concrete values. Providing an empty list will create a food with the base values for this
         * variant.
         * </p>
         *
         * @param extras The list of {@link Extra Extras} to configure the resultant {@link Food}
         * @return An instance of {@link Food} based on the values from this variant and configured by the provided extras
         */
        @Override
        public AbstractSaucable create(List<? extends Extra<? super AbstractSaucable.Config>> extras) {
            return null;
        }
    }
}
