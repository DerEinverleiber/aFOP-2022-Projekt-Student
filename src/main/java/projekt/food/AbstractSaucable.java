package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

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

    protected static class Config implements Saucable.Config {
        protected UnaryOperator<BigDecimal> priceMutator;
        protected DoubleUnaryOperator weightMutator;
        protected UnaryOperator<String> sauceOperator;

        /**
         * This constructor assigns its parameters to the class' attributes
         * @param priceMutator UnaryOperator<BigDecimal>
         * @param weightMutator DoubleUnaryOperator
         * @param sauceOperator UnaryOperator<String>
         */
        protected Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> sauceOperator) {
        this.priceMutator = priceMutator;
        this.weightMutator = weightMutator;
        this.sauceOperator = sauceOperator;
        }

        /**
         * Concatenates the result of all previous calls to this method with the provided {@code priceMutator}.
         *
         * <p>
         * The provided {@link UnaryOperator} accepts the result produced by the function provided to the previous call to this
         * method and produces a new price. The new price does not necessarily have to be different from the previous one, and
         * may even be exactly the same value.
         * </p>
         *
         * @param priceMutator A {@link UnaryOperator} which determines a new price based on the previous value
         */
        @Override
        public void price(UnaryOperator<BigDecimal> priceMutator) {
            this.priceMutator = (UnaryOperator<BigDecimal>) this.priceMutator.compose(priceMutator);
        }

        /**
         * The price mutator accepts a base price and produces a configured price.
         *
         * <p>
         * The function returned by this method is the result of concatenating all previous inputs into the
         * {@link #price(UnaryOperator)} method.
         * </p>
         *
         * @return The price mutation function
         */
        @Override
        public UnaryOperator<BigDecimal> getPriceMutator() {
            return priceMutator;
        }

        /**
         * Concatenates the result of all previous calls to this method with the provided {@code weightMutator}.
         *
         * <p>
         * The provided {@link DoubleUnaryOperator} accepts the result produced by the function provided to the previous call to
         * this method and produces a new weight. The new weight does not necessarily have to be different from the previous
         * one, and may even be exactly the same value.
         * </p>
         *
         * @param weightMutator A {@link DoubleUnaryOperator} which determines a new weight based on the previous value
         */
        @Override
        public void weight(DoubleUnaryOperator weightMutator) {
            this.weightMutator = this.weightMutator.compose(weightMutator);
        }

        /**
         * The weight mutator accepts a base weight and produces a configured weight.
         *
         * <p>
         * The function returned by this method is the result of concatenating all previous inputs into the
         * {@link #weight(DoubleUnaryOperator)}  method.
         * </p>
         *
         * @return The weight mutation function
         */
        @Override
        public DoubleUnaryOperator getWeightMutator() {
            return weightMutator;
        }

        /**
         * sets the UnaryOperator for sauce with the String describing the sauce
         *
         * @param unaryOperator the UnaryOperator
         */
        @Override
        public void sauce(UnaryOperator<String> unaryOperator) {
            this.sauceOperator = (UnaryOperator<String>) this.sauceOperator.compose(unaryOperator);
        }

        /**
         * returns the chain of all given operators as operator
         *
         * @return the chain of all given operators as operator
         */
        @Override
        public UnaryOperator<String> getSauceMutator() {
            return sauceOperator;
        }
    }

    public static abstract class Variant<F extends AbstractSaucable, C extends Config> implements Food.Variant<AbstractSaucable,Config>{
        /**
         * The constructor initializes the parameters
         * @param name the name
         * @param foodType the foodType
         * @param basePrice the basePrice
         * @param baseWeight the baseWeight
         */
        public Variant(String name, FoodType<? extends AbstractSaucable, ? extends AbstractSaucable.Config> foodType, BigDecimal basePrice, double baseWeight){
            this.name = name;
            this.foodType=foodType;
            this.basePrice=basePrice;
            this.baseWeight=baseWeight;
        }
        private final String name;
        private final FoodType<? extends AbstractSaucable,? extends AbstractSaucable.Config> foodType;
        private final BigDecimal basePrice;
        private final double baseWeight;
        /**
         * The name of this variant.
         *
         * <p>
         * This may be something similar to {@code "Pizza Margherita"}.
         * </p>
         *
         * @return The name of this variant
         */
        @Override
        public String getName() {
            return name;
        }

        /**
         * The food type in which this variant is grouped.
         *
         * <p>
         * For example, if this variant was named {@code "Pizza Margherita"}, the matching food type would be {@code "Pizza"}.
         * </p>
         *
         * @return The food type of this variant
         */
        @Override
        public FoodType<AbstractSaucable, Config> getFoodType() {
            return foodType;
        }

        /**
         * The base price of this variant.
         *
         * @return The base price of this variant
         */
        @Override
        public BigDecimal getBasePrice() {
            return basePrice;
        }

        /**
         * The base weight of this variant.
         *
         * @return The weight price of this variant
         */
        @Override
        public double getBaseWeight() {
            return baseWeight;
        }

        /**
         * Creates an empty {@link Config} for this variant.
         *
         * @return An empty {@link Config} for this variant
         */
        @Override
        public C createEmptyConfig() {
            return null;
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
        public F create(List<? extends Extra<? super C>> extras) {
            return null;
        }
    }
}
