public class Client {
    public static void main(String[] args) {
        UberManager uber = UberManager.getInstance();
        uber.initialize();
        Trip trip = uber.bookTrip("R111", new Location(11,22), new Location(33, 44), CabType.CAR);
        uber.endTrip(trip.getId());
    }
}
