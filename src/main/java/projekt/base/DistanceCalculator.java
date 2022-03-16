package projekt.base;

@FunctionalInterface
public interface DistanceCalculator {
    /**
     * This method calculates the distance of two given Location objects for a chosen metric
     * @param loc1 first Location
     * @param loc2 second Location
     * @return distance of loc1 and loc2
     */
    double calculateDistance(Location loc1, Location loc2);
}
