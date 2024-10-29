public class UberManager {
    private static UberManager instance;
    private RiderManager riderManager;
    private DriverManager driverManager;
    private TripManager tripManager;
    private StrategyManager strategyManager;
    private UberManager() {
        riderManager = RiderManager.getInstance();
        driverManager = DriverManager.getInstance();
        tripManager = TripManager.getInstance();
        strategyManager = StrategyManager.getInstance();
    }
    public static synchronized UberManager getInstance() {
        if (instance == null) {
            instance = new UberManager();
        }
        return instance;
    }
    public void initialize() {
        riderManager.createRider("R111", "Aditya", "124568", 4.6);
        riderManager.createRider("R222", "Suraj", "1245475", 4.5);
        riderManager.createRider("R333", "Paul", "6447282", 4.2);

        driverManager.createDriver("D111", "Ajit", "378879", 4.7, CabType.CAR, "KR2456");
        driverManager.createDriver("D222", "Ramesh", "4658584", 4.8, CabType.CAR, "KR23356");
        driverManager.createDriver("D333", "Suresh", "3647594", 4.7, CabType.BIKE, "HDJ334");
    }
    public Trip bookTrip(String userId, Location startLocation, Location endLocation, CabType cabType) {
        Rider rider = riderManager.getRider(userId);
        TripMetadata metadata = new TripMetadata(rider.getAvgRating(),startLocation, endLocation, cabType, "Sunny");
        FairCalculationStrategy fairCalculationStrategy = strategyManager.getFairCalculationStrategy(metadata);
        double fair = fairCalculationStrategy.calculateFair(metadata);
        metadata.setFair(fair);
        AssignDriverStrategy assignDriverStrategy = strategyManager.getAssignDriverStrategy(metadata);
        Driver driver = assignDriverStrategy.assignDriver(metadata);
        Trip trip = tripManager.createTrip(userId, driver.getId(), startLocation, endLocation, fair, cabType, driver.getCabNumber());
        printTrip(trip);
        return trip;
    }
    private void printTrip(Trip trip) {
        System.out.println("TripId: " + trip.getId());
        System.out.println("RiderId: " + trip.getRiderId());
        System.out.println("DriverId: " + trip.getDriverId());
        System.out.println("StartLocation: " + trip.getStartLocation());
        System.out.println("EndLocation: " + trip.getEndLocation());
        System.out.println("Fair: " + trip.getFair());
        System.out.println("CabNumber: " + trip.getCabNumber());
        System.out.println("CabType: " + trip.getCabType());
        System.out.println("Status: " + trip.getStatus());
    }
    public void endTrip(String tripId) {
        tripManager.updateTripStatus(tripId, TripStatus.COMPLETED);
        System.out.println("TripId: " + tripId + " has ended");
        System.out.println();
        printTrip(tripManager.getTrip(tripId));
    }
}
