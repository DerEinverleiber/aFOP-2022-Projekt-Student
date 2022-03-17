package projekt.food;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class Extras {
    public static Consumer sampleConsumer = null; // unvollständig! die jedes attribut braucht jeweils einen eigenen consumer
    public final static Extra<Pizza.Config> EXTRA_HAM = new ExtraImpl("Extra Ham", 5, sampleConsumer);
    public final static Extra<Pizza.Config> EXTRA_OLIVES = new ExtraImpl("Extra Olives", 5, sampleConsumer);
    public final static Extra<Pasta.Config> EXTRA_THICK = new ExtraImpl("Extra Thick", 4, sampleConsumer);
    public final static Extra<Saucable.Config> SPICY_SAUCE = new ExtraImpl("Spicy Sauce", 3, sampleConsumer);
    public final static Extra<Saucable.Config> EXTRA_SAUCE = new ExtraImpl("Extra Sauce", 4, sampleConsumer);
    public final static Extra<Saucable.Config> NO_SAUCE = new ExtraImpl("No Sauce", 5, sampleConsumer);
    public final static Extra<IceCream.Config> RAINBOW_SPRINKLES = new ExtraImpl("Rainbow Sprinkles", 5, sampleConsumer);
    public final static Extra<IceCream.Config> EXTRA_SCOOP = new ExtraImpl("Extra Scoop", 2, sampleConsumer);

    public final static Map<String, Extra<?>> ALL = new HashMap<String, Extra<?>>();
    //TO DO ALL


}
