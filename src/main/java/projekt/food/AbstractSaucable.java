package projekt.food;

abstract public class AbstractSaucable implements Saucable{

    public AbstractSaucable(String sauce){
        this.sauce=sauce;
    }
    protected final String sauce;
}
