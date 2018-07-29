package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        if(fromInteger < 0)
        {
            throw new IllegalArgumentException("Number should not be negative");
        }
        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if(setSize < 0 || subsetSize < 0)
        {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        if(subsetSize > setSize)
        {
            throw new IllegalArgumentException("Subset Size can't be greater than set size");
        }
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
