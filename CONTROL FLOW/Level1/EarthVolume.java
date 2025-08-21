public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);

        // 1 km = 0.621371 miles => 1 km³ = 0.621371^3 mi³
        double conversionFactor = Math.pow(0.621371, 3);
        double volumeMi3 = volumeKm3 * conversionFactor;

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 +
                " and cubic miles is " + volumeMi3);
    }
}
