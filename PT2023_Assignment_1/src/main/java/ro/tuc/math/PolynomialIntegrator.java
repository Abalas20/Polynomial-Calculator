package ro.tuc.math;

import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PolynomialIntegrator {
    public Polynomial integration(Polynomial polynomial) {
        if (polynomial == null) {
            throw new NullPointerException("The input polynomial is null.");
        }
        for (Monomial monomial : polynomial.getPolynomial().values()) {
            integrateMonomial(monomial);
        }
        return polynomial;
    }

    private void integrateMonomial(Monomial monomial) {
        if (monomial.getDegree() == -1) {
            monomial.setDegree(0);
        } else {
            BigDecimal degree = new BigDecimal(monomial.getDegree()).add(BigDecimal.ONE);
            monomial.setCoefficient(monomial.getCoefficient().divide(degree, 2, RoundingMode.HALF_DOWN));
            monomial.setDegree(monomial.getDegree() + 1);
        }
    }
}
