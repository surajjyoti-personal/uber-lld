import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RiderManager {
    private static RiderManager instance;
    private Map<String, Rider> riders;
    private RiderManager() {
        riders = new ConcurrentHashMap<>();
    }
    public static synchronized RiderManager getInstance() {
        if (instance == null) {
            instance = new RiderManager();
        }
        return instance;
    }
    public void createRider(String id, String name, String mobileNumber, double avgRating) {
        Rider rider = new Rider(id, name, mobileNumber, avgRating);
        riders.put(id, rider);
        System.out.println("Created rider " + id + " with name " + name + "created successfully");
    }
    public Rider getRider(String id) {
        return riders.get(id);
    }
}
