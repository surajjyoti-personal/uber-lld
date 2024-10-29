import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TripManager {
    private static TripManager instance;
    private Map<String, Trip> trips;
    private TripManager() {
        trips = new ConcurrentHashMap<>();
    }
    public static synchronized TripManager getInstance() {
        if (instance == null) {
            instance = new TripManager();
        }
        return instance;
    }
    public Trip createTrip(String riderId, String driverId, Location startLocation, Location endLocation, double fair, CabType cabType, String cabNumber) {
        String id = generateId();
        Trip trip = new Trip(id, riderId, driverId, startLocation, endLocation, fair, cabType, cabNumber, TripStatus.DRIVER_ON_THE_WAY);
        trips.put(id, trip);
        System.out.println("Trip created: " + id + " with riderId: " + riderId + " and driverId: " + driverId);
        return trip;
    }
    public Trip getTrip(String id) {
        return trips.get(id);
    }

    public void updateTripStatus(String tripId, TripStatus newStatus) {
        Trip trip = trips.get(tripId);
        trip.setStatus(newStatus);
        trips.put(tripId, trip);
    }

    public String generateId() {
        return "TRIP" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
