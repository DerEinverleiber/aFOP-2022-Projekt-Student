package projekt.food;
import java.util.function.UnaryOperator;

public interface IceCream extends Food {
    /**
     * This method returns the flavor of the ice cream
     * @return flavor of the ice cream as String
     */
    String getFlavor();
    interface Config extends Food.Config{
        void flavor(UnaryOperator<String> unaryOperator);

        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        UnaryOperator<String> getFlavorMutator();
    }
}
