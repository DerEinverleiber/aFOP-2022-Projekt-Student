package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class IceCreamImpl implements IceCream {

    protected final BigDecimal price;
    protected final double weight;
    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final String flavor;
    //TODO Zeile unter mir flavor
    final static FoodBuilder<IceCream,Food.Config,Food.Variant<IceCream,Food.Config>> BUILDER= (config, variant, compatibleExtras) -> new IceCreamImpl(variant.getBasePrice(), variant.getBaseWeight(), variant,compatibleExtras, variant.getName());

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

    private static class Config implements IceCream.Config {
        private UnaryOperator<BigDecimal> priceMutator;
        private DoubleUnaryOperator weightMutator;
        private UnaryOperator<String> unaryOperator;
        private Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> unaryOperator) {
            this.priceMutator = priceMutator;
            this.weightMutator = weightMutator;
            this.unaryOperator = unaryOperator;
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
         * sets the UnaryOperator for the flavor with the String describing the flavor
         *
         * @param unaryOperator the UnaryOperator
         */
        @Override
        public void flavor(UnaryOperator<String> unaryOperator) {
            this.unaryOperator = (UnaryOperator<String>) this.unaryOperator.compose(unaryOperator);
        }

        /**
         * returns the chain of all given operators as operator
         *
         * @return the chain of all given operators as operator
         */
        @Override
        public UnaryOperator<String> getFlavorMutator() {
            return unaryOperator;
        }
    }
    static class Variant<F extends IceCream,C extends Config> implements Food.Variant<IceCreamImpl,IceCreamImpl.Config> {
        public Variant(String name,FoodType<IceCreamImpl, Config> foodType,BigDecimal basePrice,double baseWeight){
            this.name = name;
            this.foodType=foodType;
            this.basePrice=basePrice;
            this.baseWeight=baseWeight;
        }
        private final String name;
        private final FoodType<IceCreamImpl, Config> foodType;
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
        public FoodType<IceCreamImpl, Config> getFoodType() {
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
        //TODO da
        /**
         * Creates an empty {@link Config} for this variant.
         *
         * @return An empty {@link Config} for this variant
         */
        @Override
        public Config createEmptyConfig() {
            return new Config(new UnaryOperator<BigDecimal>() {
                @Override
                public BigDecimal apply(BigDecimal bigDecimal) {
                    return bigDecimal.add(getBasePrice());
                }
            }, new DoubleUnaryOperator() {
                @Override
                public double applyAsDouble(double operand) {
                    return baseWeight + operand;
                }
            }, new UnaryOperator<String>() {
                @Override
                public String apply(String s) {
                    return name + " " + s;
                }
            });
        }

        /**
         * Creates a new instance of {@link Food} described by this variant, its base values and modifications defined by the
         * provided list of {@link Extra Extras}.
         *
         * @param extras The list of {@link Extra Extras} to configure the resultant {@link Food}
         * @return An instance of {@link Food} based on the values from this variant and configured by the provided extras
         */
        @Override
        public IceCreamImpl create(List<? extends Extra<? super Config>> extras) {
            return null;
        }
    }
}
