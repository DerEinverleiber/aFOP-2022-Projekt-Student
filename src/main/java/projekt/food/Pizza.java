package projekt.food;

import java.util.function.DoubleUnaryOperator;

public interface Pizza extends Saucable {
    /**
     * This method returns the diameter of the pizza
     * @return diameter of type double
     */
    double getDiameter();
    interface Config extends Saucable.Config {
        /**
         * sets the UnaryOperator for diameter with the double describing the diameter
         * @param unaryOperator the UnaryOperator
         */
        void diameter(DoubleUnaryOperator unaryOperator);
        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        DoubleUnaryOperator getDiameterMutator();
    }
    interface Variant<F extends Pizza,C extends Pizza.Config> extends Saucable.Variant<F,C> {
        /**
         * This method returns the base diameter
         * @return baseDiameter as double
         */
        double getBaseDiameter();
    }
}
