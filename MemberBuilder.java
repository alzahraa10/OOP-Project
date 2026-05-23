// Pattern 7: Builder
// Builds a Member object step by step instead of using a complex constructor.

public class MemberBuilder {
    private String name;
    private String memberId;
    private String membershipType; // "STANDARD", "PREMIUM", "STUDENT"
    private FeeStrategy feeStrategy;

    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public MemberBuilder setMembershipType(String membershipType) {
        this.membershipType = membershipType;
        return this;
    }

    public MemberBuilder setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
        return this;
    }

    public Member build() {
        if (name == null || memberId == null) {
            throw new IllegalStateException("Member must have a name and ID.");
        }
        // Default fee strategy based on membership type if not explicitly set
        if (feeStrategy == null) {
            if ("PREMIUM".equalsIgnoreCase(membershipType)) {
                feeStrategy = new PremiumFeeStrategy();
            } else if ("STUDENT".equalsIgnoreCase(membershipType)) {
                feeStrategy = new StudentFeeStrategy();
            } else {
                feeStrategy = new StandardFeeStrategy();
            }
        }
        return new Member(name, memberId, membershipType, feeStrategy);
    }
}
