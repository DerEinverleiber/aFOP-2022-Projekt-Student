package projekt.food;

import java.util.function.DoubleUnaryOperator;

public interface Pasta extends Saucable {
    /**
     * This method returns the thickness of the noodles
     * @return thickness of the noddles as double
     */
    double getThickness();
    interface Config extends Saucable.Config{
        void thickness(DoubleUnaryOperator unaryOperator);
        /**
         * returns the chain of all given operators as operator
         * @return the chain of all given operators as operator
         */
        DoubleUnaryOperator getThicknessMutator();
    }
}
