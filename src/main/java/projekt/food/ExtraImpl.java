package projekt.food;

import projekt.food.Food.Config;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class ExtraImpl<C extends Food.Config> implements Extra<C>{
    /**
     * the ExtraImpl constructor initializes all object constants
     * @param name String representing the name
     * @param priority int representing the priority
     * @param configMutator Consumer accepting a configuration
     */
    public ExtraImpl(String name,int priority,Consumer<C> configMutator){
        this.name=name;
        this.configMutator=configMutator;
        this.priority=priority;
    }

    private final String name;
    private final int priority;
    private final Consumer<C> configMutator;



    /**
     * The name of this extra.
     *
     * @return The name of this extra
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * The priority of the extra, lower is calculated first.
     *
     * @return The priority of this extra
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * Applies the modifications of this extra to the provided {@link C config}.
     *
     * @param config {@link Food.Config} to modify
     */
    @Override
    public void apply(Food.Config config) {
        configMutator.accept((C) config);
    }
}
