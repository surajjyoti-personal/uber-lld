public class RatingBasedFairCalculation implements FairCalculationStrategy{
    @Override
    public double calculateFair(TripMetadata tripMetadata) {
        if (tripMetadata.getUserRating() > 4) return 25;
        else return 30;
    }
}
