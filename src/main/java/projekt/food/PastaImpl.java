package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class PastaImpl extends AbstractSaucable implements Pasta {

    protected final Food.Variant<?, ?> foodVariant;
    protected final List<? extends Extra<?>> extras;
    protected final double thickness;
    final static FoodBuilder<Pasta,Food.Config,Food.Variant<Pasta,Food.Config>> BUILDER= (config, variant, compatibleExtras) -> new PastaImpl(null,variant.getBasePrice(),variant.getBaseWeight(),variant,compatibleExtras,2);

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
}
