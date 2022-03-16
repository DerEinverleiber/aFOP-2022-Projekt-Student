package projekt.base;

public class ManhattanDistanceCalculator implements DistanceCalculator{
    /**
     * This method calculates the distance given by the Manhattan metric
     * @param loc1 first Location
     * @param loc2 second Location
     * @return the distance as double value
     */
    @Override
    public double calculateDistance(Location loc1, Location loc2) {
        return Math.abs(loc1.getX()-loc2.getX())+Math.abs(loc1.getY()-loc2.getY());
    }
}
