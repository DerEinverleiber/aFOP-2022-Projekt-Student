package projekt.food;

import java.math.BigDecimal;
import java.util.List;

public class PizzaImpl extends AbstractSaucable{
    public PizzaImpl(String sauce){
        super(sauce);
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
}
