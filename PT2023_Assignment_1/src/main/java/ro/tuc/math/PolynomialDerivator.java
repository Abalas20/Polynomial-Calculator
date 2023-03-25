package ro.tuc.math;

import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;

import java.math.BigDecimal;

public class PolynomialDerivator {

    public Polynomial derivation(Polynomial polynomial) {
        if (polynomial == null) {
            throw new NullPointerException("The input polynomial is null.");
        }
        Polynomial result = new Polynomial();
        for (Monomial monomial: polynomial.getPolynomial().values()) {
            derivativeMonomial(monomial, result);
        }
        return result;
    }

    private void derivativeMonomial(Monomial monomial, Polynomial polynomial) {
        BigDecimal degree = new BigDecimal(monomial.getDegree());
        if(degree.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }
        monomial.setCoefficient(monomial.getCoefficient().multiply(degree));
        monomial.setDegree(monomial.getDegree() - 1);
        polynomial.addNewMonomial(monomial);
    }
}