public class Rider {
    private String id;
    private String name;
    private String mobileNumber;
    private double avgRating;
    public Rider(String id, String name, String mobileNumber, double avgRating) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.avgRating = avgRating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public double getAvgRating() {
        return avgRating;
    }
}
