public class NearestDistanceBasedStrategy implements AssignDriverStrategy{
    @Override
    public Driver assignDriver(TripMetadata tripMetadata) {
        DriverManager driverManager = DriverManager.getInstance();
        return driverManager.getDriver("D111", CabType.CAR);
    }
}
