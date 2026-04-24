// DESIGN PATTERN 3: STRATEGY
// Strategy Pattern - interchangeable fee 
// Different fee calculation strategies for different member types

public interface FeeStrategy {
    double calculateFee(int daysLate);
    String getStrategyName();
}

class StandardFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(int daysLate) {
        return daysLate * 0.25; // $0.25 per day
    }
    @Override
    public String getStrategyName() { return "Standard ($0.25/day)"; }
}

class PremiumFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(int daysLate) {
        return daysLate * 0.10; // $0.10 per day (discounted for premium members)
    }
    @Override
    public String getStrategyName() { return "Premium ($0.10/day)"; }
}

class StudentFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(int daysLate) {
        // First 3 days free, then $0.15/day
        if (daysLate <= 3) return 0;
        return (daysLate - 3) * 0.15;
    }
    @Override
    public String getStrategyName() { return "Student (3 days grace, $0.15/day after)"; }
}
