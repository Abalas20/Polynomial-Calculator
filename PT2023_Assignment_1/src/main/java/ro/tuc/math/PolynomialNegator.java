package ro.tuc.math;

import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;

public class PolynomialNegator {
    public void negate(Polynomial polynomial) {
        for (Monomial monomial : polynomial.getPolynomial().values()) {
            monomial.setCoefficient(monomial.getCoefficient().negate());
        }
    }
}