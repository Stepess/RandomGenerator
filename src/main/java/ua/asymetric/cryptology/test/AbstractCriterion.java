package ua.asymetric.cryptology.test;

public abstract class AbstractCriterion {

    public abstract void generateRandomSequence();
    public abstract void countStatisticData(byte[] randomSequence);
    public abstract void calculateChiSqr();

    public abstract double calculateThresholdValue(double quantile);

    public abstract double getChiSqr();

    public abstract boolean test(double quantile);
}
