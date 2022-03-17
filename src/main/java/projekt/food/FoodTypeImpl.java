package projekt.food;

import java.util.ArrayList;
import java.util.List;

public class FoodTypeImpl<F extends Food,C extends Food.Config> implements FoodType<F,C> {
    /**
     * the FoodTypeImpl constructor initializes the corresponding parameters to the given ones and sets foodVariants to an empty ArrayList
     * @param name String name
     * @param compatibleExtras List of compatible Extras
     */
    public FoodTypeImpl(String name,List<? extends Extra<? super C>> compatibleExtras){
        this.name=name;
        this.compatibleExtras=compatibleExtras;
        foodVariants= new ArrayList<>();
    }
    private final String name;
    private final List<? extends Extra<? super C>> compatibleExtras;
    private final List<Food.Variant<F, C>> foodVariants;
    /**
     * The name of this food type.
     *
     * <p>
     * This may be something similar to {@code "Pizza"}.
     * </p>
     *
     * @return The name of this type
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * The {@link Extra Extras} compatible with this food type.
     *
     * @return The {@link Extra Extras} compatible with this food type
     */
    @Override
    public List<? extends Extra<? super C>> getCompatibleExtras() {
        return compatibleExtras;
    }

    /**
     * Adds a {@link Food.Variant} to this food type.
     *
     * @param variant The {@link Food.Variant} to add to this food type
     */
    @Override
    public void addFoodVariant(Food.Variant<F, C> variant) {

    }

    /**
     * The {@link Food.Variant food variants} that this food type are part of.
     *
     * <p>
     * For example, if this food type is "Pizza", this method might return the variants named:
     * </p>
     * <ul>
     *     <li>"Pizza Margherita"</li>
     *     <li>"Pizza Hawaii"</li>
     *     <li>"Pizza Rucola"</li>
     *     <li>"Pizza BBQ"</li>
     * </ul>
     *
     * @return The {@link Food.Variant food variants} that this food type are part of
     */
    @Override
    public List<? extends Food.Variant<F, C>> getFoodVariants() {
        return foodVariants;
    }
}
