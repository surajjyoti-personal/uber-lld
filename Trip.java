public class Trip {
    private String id;
    private String riderId;
    private String driverId;
    private Location startLocation;
    private Location endLocation;
    private double fair;
    private CabType cabType;
    private String cabNumber;
    private TripStatus status;

    public Trip(String id, String riderId, String driverId, Location startLocation, Location endLocation, double fair, CabType cabType, String cabNumber, TripStatus status) {
        this.id = id;
        this.riderId = riderId;
        this.driverId = driverId;
        this.startLocation = startLocation;
        this.fair = fair;
        this.endLocation = endLocation;
        this.cabType = cabType;
        this.cabNumber = cabNumber;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public double getFair() {
        return fair;
    }

    public CabType getCabType() {
        return cabType;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }
}
