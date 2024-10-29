public class TripMetadata {
    private double userRating;
    private Location startLocation;
    private Location endLocation;
    private CabType cabType;
    private String weather;
    private double fair;
    public TripMetadata(double userRating, Location startLocation, Location endLocation, CabType cabType, String weather) {
        this.userRating = userRating;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cabType = cabType;
        this.weather = weather;
    }

    public double getUserRating() {
        return userRating;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public CabType getCabType() {
        return cabType;
    }

    public String getWeather() {
        return weather;
    }
    public void setFair(double fair) {
        this.fair = fair;
    }
}
