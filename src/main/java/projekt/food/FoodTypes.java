package projekt.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class FoodTypes {
    /**
     * denies constructing objects
     */
    private FoodTypes(){
        ALL.put("Pizza",PIZZA);
        ALL.put("Pasta",PASTA);
        ALL.put("IceCream",ICE_CREAM);
    }
    private final static Extra[] extrasPizza = {Extras.EXTRA_HAM,Extras.EXTRA_OLIVES,Extras.SPICY_SAUCE,Extras.EXTRA_SAUCE,Extras.NO_SAUCE};
    public static final FoodType PIZZA = new FoodTypeImpl("Pizza", Arrays.stream(extrasPizza).collect(Collectors.toList()));
    private final static Extra[] extrasPasta = {Extras.EXTRA_THICK,Extras.SPICY_SAUCE,Extras.EXTRA_SAUCE,Extras.NO_SAUCE};
    public static final FoodType PASTA = new FoodTypeImpl("Pasta",Arrays.stream(extrasPasta).collect(Collectors.toList()));
    private static final Extra[] extrasIceCream = {Extras.RAINBOW_SPRINKLES,Extras.EXTRA_SCOOP,Extras.JUMBO_SCHREINER_SIZED,Extras.EXTRA_SALT,Extras.EXTRA_SPOON,Extras.EXTRA_CARBONATED,Extras.EXTRA_EXPIRED};
    public static final FoodType ICE_CREAM = new FoodTypeImpl("Ice Cream", Arrays.stream(extrasIceCream).collect(Collectors.toList()));
    //public static final Map @DerEinverleiber H2.10
    //TODO s.o.
    public static final Map<String,FoodType> ALL = new HashMap<>();

    static {
        ALL.put("Pizza",PIZZA);
        ALL.put("Pasta",PASTA);
        ALL.put("IceCream",ICE_CREAM);
    }

}
