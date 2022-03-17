package projekt.food;
import java.util.List;
@FunctionalInterface
public interface FoodBuilder<F extends Food,C extends Food.Config,V extends Food.Variant<F,C>> {
    /**
     * Method to build a dish with Extras
     * @param config the Food Config
     * @param variant the Food Variant
     * @param compatibleExtras the compatible Extras
     * @return the built food
     */
    F build(C config,V variant,List<? extends Extra<? super C>> compatibleExtras);
}
