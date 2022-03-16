package projekt.base;

public class Location {
    private final int x;
    private final int y;

    /**
     * This constructor initializes both object constants x and y
     * @param x int variable to be assigned to this.x
     * @param y int variable to be assigned to this.y
     */
    public Location(int x,int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Method to get the y coordinate
     * @return y coordinate
     */
    int getY() {
        return y;
    }

    /**
     * Method to get the x coordinate
     * @return x coordinate
     */
    int getX() {
        return x;
    }

    /**
     * Method to add two Locations by adding their coordinates
     * @param location the 2nd location for summation
     * @return the sum of the two locations
     */
    Location add(Location location){
        return new Location(location.getX()+this.getX(), location.getY()+this.getY() );
    }

    /**
     * Method to subtracting two Locations by subtracting their coordinates
     * @param location the 2nd location for subtraction (the subtrahend)
     * @return the difference of the two locations
     */
    Location subtract(Location location) {
        return new Location(getX() - location.getX(), getY() - location.getY());
    }


}
