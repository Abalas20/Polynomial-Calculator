package ro.tuc.math;

import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;

import java.math.BigDecimal;
import java.util.Collection;

public class PolynomialAdder {

    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        // result = polynomial1 + polynomial2
        if (polynomial1 == null || polynomial2 == null) {
            throw new NullPointerException("One or both of the input polynomials is null.");
        }
        Polynomial result = new Polynomial();
        addAll(result, polynomial1.getPolynomial().values());
        addAll(result, polynomial2.getPolynomial().values());
        return result;
    }

    protected void addAll(Polynomial polynomial, Collection<Monomial> monomials) {
        for (Monomial monomial : monomials) {
            addMonomial(polynomial, monomial);
        }
    }

    private void addMonomial(Polynomial polynomial, Monomial monomial) {
        if (monomial.getCoefficient().compareTo(BigDecimal.ZERO) == 0) {
            return; // Ignore monomials with 0 coefficient
        }
        Monomial newMonomial = polynomial.getPolynomial().get(monomial.getDegree());
        if (newMonomial != null) { // If we find a monomial with the same degree we add theirs coefficients
            newMonomial.setCoefficient(newMonomial.getCoefficient().add(monomial.getCoefficient()));
            if (newMonomial.getCoefficient().compareTo(BigDecimal.ZERO) == 0) {
                polynomial.removeMonomial(newMonomial.getDegree());
            } else {
                monomial.setCoefficient(newMonomial.getCoefficient());
            }
        } else { // Since we didn't find another monomial with this degree we can just simply add this one to the polynomial
            polynomial.addNewMonomial(monomial);
        }
    }
}
