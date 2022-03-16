package projekt.food;

import java.util.function.UnaryOperator;

public interface Saucable extends Food {
    /**
     * This method returns the type of sauce
     * @return String regarding the sauce
     */
    String getSauce();

    interface Config extends Food.Config {
        /**
         * sets the UnaryOperator for sauce with the String describing the sauce
         * @param unaryOperator the UnaryOperator
         */
        void sauce(UnaryOperator<String> unaryOperator);
        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        UnaryOperator<String> getSauceMutator();

    }

    interface Variant extends Food.Variant {
        /**
         * Returns the baseSauce
         * @return baseSauce as String
         */
        String getBaseSauce();
    }
}
