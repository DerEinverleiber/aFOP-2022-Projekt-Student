package projekt.food;

import java.util.function.DoubleUnaryOperator;

public interface Pasta extends Saucable {
    /**
     * This method returns the thickness of the noodles
     * @return thickness of the noddles as double
     */
    double getThickness();
    interface Config extends Saucable.Config {
        /**
         * sets the UnaryOperator for thickness with the double describing the thickness
         * @param unaryOperator the UnaryOperator
         */
        void thickness(DoubleUnaryOperator unaryOperator);
        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        DoubleUnaryOperator getThicknessMutator();
    }

    interface Variant extends Saucable.Variant {
        /**
         * This method returns the base thickness
         * @return baseThickness as double
         */
        double getBaseThickness();
    }
}
