package ro.tuc.math;

import ro.tuc.data_models.Polynomial;

public class PolynomialSubtractor {
    private final static PolynomialAdder ADDER = new PolynomialAdder();
    private final static PolynomialNegator NEGATOR = new PolynomialNegator();

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        // result = polynomial1 - polynomial2 = (-polynomial2) + polynomial1
        if (polynomial1 == null || polynomial2 == null) {
            throw new NullPointerException("One or both of the input polynomials is null.");
        }
        Polynomial result = new Polynomial();
        ADDER.addAll(result, polynomial2.getPolynomial().values());
        NEGATOR.negate(result);
        ADDER.addAll(result, polynomial1.getPolynomial().values());
        return result;
    }
}
