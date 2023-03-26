package ro.tuc.math;

import ro.tuc.data_models.DivisionResult;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;

import java.math.BigDecimal;

public class PolynomialDivider {

    private final static PolynomialAdder ADDER = new PolynomialAdder();
    private final static PolynomialSubtractor SUBTRACTOR = new PolynomialSubtractor();
    private final static PolynomialMultiplicator MULTIPLICATOR = new PolynomialMultiplicator();

    public DivisionResult divide(Polynomial polynomial1, Polynomial polynomial2) {
        if (polynomial1.isEmpty() || polynomial2.isEmpty()) {
            throw new IllegalArgumentException("Can't divide empty polynomials");
        }
        if (polynomial2.isZero()) {
            throw new IllegalArgumentException("Can't divide by zero");
        }
        Polynomial quotient = new Polynomial();
        Polynomial remainder = ADDER.add(polynomial1, new Polynomial());
        while (!remainder.isEmpty() && remainder.getHighestDegree() >= polynomial2.getHighestDegree()) {
            Polynomial temp = getTemporaryQuotient(remainder, polynomial2);
            quotient = ADDER.add(quotient, temp);
            remainder = SUBTRACTOR.subtract(remainder, MULTIPLICATOR.multiplication(temp, polynomial2));
        }
        return new DivisionResult(quotient, remainder);
    }

    private Polynomial getTemporaryQuotient(Polynomial polynomial1, Polynomial polynomial2) {
        Monomial monomial1 = polynomial1.getPolynomial().get(polynomial1.getHighestDegree());
        Monomial monomial2 = polynomial2.getPolynomial().get(polynomial2.getHighestDegree());
        int degree = monomial1.getDegree() - monomial2.getDegree();
        @SuppressWarnings("BigDecimalMethodWithoutRoundingCalled") BigDecimal coefficient = monomial1.getCoefficient().divide(monomial2.getCoefficient());
        Polynomial resultPolynomial = new Polynomial();
        resultPolynomial.addNewMonomial(new Monomial(degree, coefficient));
        return resultPolynomial;
    }
}