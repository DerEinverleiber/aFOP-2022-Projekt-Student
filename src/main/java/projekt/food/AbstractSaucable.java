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

    private static class Config implements Saucable.Config {
        private UnaryOperator<BigDecimal> priceMutator;
        private DoubleUnaryOperator weightMutator;
        private UnaryOperator<String> sauceOperator;

        private Config(UnaryOperator<BigDecimal> priceMutator, DoubleUnaryOperator weightMutator, UnaryOperator<String> sauceOperator) {
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
}
