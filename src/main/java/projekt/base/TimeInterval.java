package projekt.base;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeInterval {
    private final LocalDateTime start;
    private final LocalDateTime end;

    /**
     * The TimeIntervall constructor initializes the objects variables with the given parameters
     * if start is after there will be an IllegalArgumentException
     * if at least one parameter is null, a NullPointerException is thrown
     * @param start the start LocalDateTime
     * @param end the end LocalDateTime
     */
    public TimeInterval(LocalDateTime start, LocalDateTime end) {
        if(start==null||end==null){
            throw new NullPointerException(start==null?"start":"end");
        }
        if(start.isAfter(end)){
            throw new IllegalArgumentException("Start "+start.toString()+" is after end "+end.toString());
        }
        this.start = start;
        this.end = end;
    }

    /**
     * This method gets the start attribute
     * @return start attribute of type LocalDateTime
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * This method gets the end attribute
     * @return ent attribute of type LocalDateTime
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * This method returns the duration of the start and end attribute
     * @return object of type Duration
     */
    public Duration getDuration() {
        return Duration.between(start,end);
    }


}
