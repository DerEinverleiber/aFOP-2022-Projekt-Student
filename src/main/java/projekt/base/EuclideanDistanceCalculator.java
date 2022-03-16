package projekt.base;

class EuclideanDistanceCalculator implements DistanceCalculator {
    /**
     * This implementation returns the distance of loc1 and loc2 using the euclidean norm
     * @param loc1 first Location
     * @param loc2 second Location
     * @return distance of loc1 and loc2 in euclidean norm
     */
    @Override
    public double calculateDistance(Location loc1, Location loc2) {
        return Math.sqrt( Math.pow((loc1.getX() - loc2.getX()), 2) + Math.pow((loc1.getY() - loc2.getY()), 2));
    }
}
