public class Driver {
    private String id;
    private String name;
    private String mobileNumber;
    private double avgRating;
    private CabType cabType;
    private String cabNumber;
    public Driver(String id, String name, String mobileNumber, double avgRating, CabType cabType, String cabNumber) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.avgRating = avgRating;
        this.cabType = cabType;
        this.cabNumber = cabNumber;
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

    public CabType getCabType() {
        return cabType;
    }

    public String getCabNumber() {
        return cabNumber;
    }
}
