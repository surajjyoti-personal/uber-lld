import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverManager {
    private static DriverManager instance;
    private Map<CabType, Map<String, Driver>> drivers;
    private DriverManager() {
        drivers = new ConcurrentHashMap<>();
    }
    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }
    public void createDriver(String id, String name, String mobileNumber, double avgRating, CabType cabType, String cabNumber) {
        Driver driver = new Driver(id, name, mobileNumber, avgRating, cabType, cabNumber);
        Map<String, Driver> drivers = this.drivers.getOrDefault(cabType, new HashMap<>());
        drivers.put(id, driver);
        this.drivers.put(cabType, drivers);
        System.out.println("Driver created with id: " + id);
    }
    public Driver getDriver(String id, CabType cabType) {
        Map<String, Driver> drivers = this.drivers.get(cabType);
        if (drivers.containsKey(id)) {
            return drivers.get(id);
        }
        System.out.println("Driver not found with id: " + id);
        return null;
    }
}
