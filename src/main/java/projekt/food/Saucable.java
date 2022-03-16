package projekt.food;

import java.util.function.UnaryOperator;

public interface Saucable extends Food {
    /**
     * This method returns the type of sauce
     * @return String regarding the sauce
     */
    String getSauce();

    interface Config extends Food.Config{
        /**
         *
         * @param unaryOperator
         */
        void sauce(UnaryOperator<String> unaryOperator);
        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        UnaryOperator<String> getSauceMutator();

    }
}
