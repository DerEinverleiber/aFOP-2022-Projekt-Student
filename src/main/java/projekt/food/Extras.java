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
    public final static Extra<IceCream.Config> JUMBO_SCHREINER_SIZED = new ExtraImpl("Jumbo Schreiner Sized", 1, sampleConsumer);
    public final static Extra<IceCream.Config> EXTRA_SALT = new ExtraImpl("Extra Salt", 5, sampleConsumer);
    public final static Extra<IceCream.Config> EXTRA_SPOON = new ExtraImpl("Extra Spoon", 5, sampleConsumer);
    public final static Extra<IceCream.Config> EXTRA_CARBONATED = new ExtraImpl("Extra Carbonated", 3, sampleConsumer);
    public final static Extra<IceCream.Config> EXTRA_EXPIRED = new ExtraImpl("Extra Expired", 2, sampleConsumer);


    private Extras() {
        ALL.put("Extra Ham", EXTRA_HAM);
        ALL.put("Extra Olives", EXTRA_OLIVES);
        ALL.put("Extra Thick", EXTRA_THICK);
        ALL.put("Spicy Sauce", SPICY_SAUCE);
        ALL.put("Extra Sauce", EXTRA_SAUCE);
        ALL.put("No Sauce", NO_SAUCE);
        ALL.put("Rainbow Sprinkles", RAINBOW_SPRINKLES);
        ALL.put("Extra Scoop", EXTRA_SCOOP);
        ALL.put("Jumbo Schreiner Sized", JUMBO_SCHREINER_SIZED);
        ALL.put("Extra Salt", EXTRA_SALT);
        ALL.put("Extra Spoon", EXTRA_SPOON);
        ALL.put("Extra Carbonated", EXTRA_CARBONATED);
        ALL.put("Extra expired", EXTRA_EXPIRED);
    }

}
