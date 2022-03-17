package projekt.food;


import java.awt.*;
import java.util.Comparator;
import java.util.List;

/**
 * A modification that targets configurable values in a {@link Food.Config}.
 *
 * @param <C> The target {@link Food.Config} type
 */
public interface Extra<C extends Food.Config> {

    /**
     * The name of this extra.
     *
     * @return The name of this extra
     */
    String getName();

    /**
     * The priority of the extra, lower is calculated first.
     *
     * @return The priority of this extra
     */
    int getPriority();

    /**
     * Applies the modifications of this extra to the provided {@link C config}.
     *
     * @param config {@link Food.Config} to modify
     */
    void apply(C config);

    static <C> void writeToConfig(C config, List<? extends Extra<? extends Food.Config>> extras){
        Comparator<Extra<? extends Food.Config>> comparator= (Extra<? extends Food.Config> x,Extra<? extends Food.Config> y)-> {
            if(x.getPriority()<y.getPriority()){
                return -1;
            }
            else if(x.getPriority()>y.getPriority()){
                return 1;
            }else {
                return x.getName().compareTo(y.getName());
            }
        };
        extras.sort(comparator);
        //extras.forEach(extra -> extra.apply(config));
    };
}
