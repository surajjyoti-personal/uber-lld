public class StrategyManager {
    private static StrategyManager instance;
    private StrategyManager() {}
    public static synchronized StrategyManager getInstance() {
        if(instance == null) {
            instance = new StrategyManager();
        }
        return instance;
    }
    public FairCalculationStrategy getFairCalculationStrategy(TripMetadata tripMetadata) {
        return new RatingBasedFairCalculation();
    }
    public AssignDriverStrategy getAssignDriverStrategy(TripMetadata tripMetadata) {
        return new NearestDistanceBasedStrategy();
    }
}
