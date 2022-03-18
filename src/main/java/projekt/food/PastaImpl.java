package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class PastaImpl extends AbstractSaucable implements Pasta {

    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final double thickness;
    final static FoodBuilder<Pasta,Food.Config,Food.Variant<Pasta,Food.Config>> BUILDER= (config, variant, compatibleExtras) -> new PastaImpl(null,variant.getBasePrice(),variant.getBaseWeight(),variant,compatibleExtras,variant.getName().equals("Spaghetti")?2:variant.getName().equals("Rigatoni")?10:variant.getName().equals("Ravioli")?40:15);
    //TODO Hardcode entferenen
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

    private static class Config extends AbstractSaucable.Config implements Pasta.Config {
        private DoubleUnaryOperator unaryOperator;

        /**
         * The constructor initializes all parameters
         * @param priceMutator the price mutator
         * @param weightMutator the weight mutator
         * @param sauceOperator the sauce operator
         * @param unaryOperator the unary operator
         */
        private Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> sauceOperator, DoubleUnaryOperator unaryOperator) {
            super(priceMutator, weightMutator, sauceOperator);
            this.unaryOperator = unaryOperator;
        }

        /**
         * sets the UnaryOperator for thickness with the double describing the thickness
         *
         * @param unaryOperator the UnaryOperator
         */
        @Override
        public void thickness(DoubleUnaryOperator unaryOperator) {
            this.unaryOperator = this.unaryOperator.compose(unaryOperator);
        }

        /**
         * returns the chain of all given operators as operator
         *
         * @return the chain of all given operators as operator
         */
        @Override
        public DoubleUnaryOperator getThicknessMutator() {
            return unaryOperator;
        }
    }

    static class Variant<F extends PastaImpl, C extends Config> implements Pasta.Variant<PastaImpl, Config> {
        private final String name;
        private final FoodType<PastaImpl, Config> foodType;
        private final BigDecimal basePrice;
        private final double baseWeight;
        private final double baseThickness;
        private final String baseSauce;

        /**
         * This constructor initializes its parameters to the class' attributes
         * @param name the name
         * @param foodType the foodType
         * @param basePrice the basePrice
         * @param baseWeight the baseWeight
         * @param baseThickness the baseThickness
         * @param baseSauce the baseSauce
         */
        public Variant(String name, FoodType<PastaImpl, Config> foodType, BigDecimal basePrice, double baseWeight, double baseThickness, String baseSauce) {
            this.name = name;
            this.foodType = foodType;
            this.basePrice = basePrice;
            this.baseWeight = baseWeight;
            this.baseThickness = baseThickness;
            this.baseSauce = baseSauce;
        }

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
        public FoodType<PastaImpl, Config> getFoodType() {
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
        public Config createEmptyConfig() {
            return new Config(bigDecimal -> bigDecimal.add(getBasePrice()), operand -> operand + getBaseWeight(), s -> getBaseSauce() + " " + s, operand -> operand + getBaseThickness() );
        }

        /**
         * Creates a new instance of {@link Food} described by this variant, its base values and modifications defined by the
         * provided list of {@link Extra Extras}.
         *
         * @param extras The list of {@link Extra Extras} to configure the resultant {@link Food}
         * @return An instance of {@link Food} based on the values from this variant and configured by the provided extras
         */
        @Override
        public PastaImpl create(List<? extends Extra<? super Config>> extras) {
            return null;
        }

        /**
         * This method returns the base thickness
         *
         * @return baseThickness as double
         */
        @Override
        public double getBaseThickness() {
            return baseThickness;
        }

        /**
         * Returns the baseSauce
         *
         * @return baseSauce as String
         */
        @Override
        public String getBaseSauce() {
            return baseSauce;
        }
    }
}
