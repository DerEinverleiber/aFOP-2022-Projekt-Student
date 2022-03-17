package projekt.food;
import java.util.function.UnaryOperator;

public interface IceCream extends Food {
    /**
     * This method returns the flavor of the ice cream
     * @return flavor of the ice cream as String
     */
    String getFlavor();
    interface Config extends Food.Config {
        /**
         * sets the UnaryOperator for the flavor with the String describing the flavor
         * @param unaryOperator the UnaryOperator
         */
        void flavor(UnaryOperator<String> unaryOperator);

        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        UnaryOperator<String> getFlavorMutator();
    }

    interface Variant<F extends IceCream,C extends IceCream.Config> extends Food.Variant<F,C> {
        /**
         * This method returns the base flavor
         * @return baseFlavor as String
         */
        String getBaseFlavor();
    }
}
