package ro.tuc.math;

import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;

import java.math.BigDecimal;

public class PolynomialMultiplicator {
    private final static PolynomialAdder ADDER = new PolynomialAdder();

    public Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2) {
        if (polynomial1 == null || polynomial2 == null) {
            throw new NullPointerException("One or both of the input polynomials is null.");
        }
        Polynomial result = new Polynomial();
        if (result.equals(polynomial1) || result.equals(polynomial2)) {
            return result;
        }
        for (Monomial monomial1 : polynomial1.getPolynomial().values()) {
            Polynomial partialProduct = new Polynomial();
            for (Monomial monomial2 : polynomial2.getPolynomial().values()) {
                multiplyMonomial(monomial1, monomial2, partialProduct);
            }
            result = ADDER.add(result, partialProduct);
        }
        return result;
    }

    private void multiplyMonomial(Monomial monomial1, Monomial monomial2, Polynomial polynomial) {
        BigDecimal resultedCoefficient = monomial1.getCoefficient().multiply(monomial2.getCoefficient());
        if (resultedCoefficient.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }
        int degree = monomial1.getDegree() + monomial2.getDegree();
        polynomial.addNewMonomial(new Monomial(degree, resultedCoefficient));
    }
}