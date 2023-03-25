package ro.tuc;

import org.junit.Test;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.math.PolynomialIntegrator;
import ro.tuc.math.PolynomialOperations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PolynomialOperationDerivationTest {

    private final PolynomialOperations polynomialOperations = new PolynomialOperations();

    @Test
    public void testDerivationOperationValidPolynomials() {
        /*
         *  P1 = x^3 - 2x^2 + 6x - 5
         *  R  = 3x^2 - 4x + 6
         * */
        Polynomial polynomial = new Polynomial();
        polynomial.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial.addNewMonomial(new Monomial(2, BigDecimal.valueOf(-2)));
        polynomial.addNewMonomial(new Monomial(1, BigDecimal.valueOf(6)));
        polynomial.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-5)));

        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(2, BigDecimal.valueOf(3)));
        result.addNewMonomial(new Monomial(1, BigDecimal.valueOf(-4)));
        result.addNewMonomial(new Monomial(0, BigDecimal.valueOf(6)));

        assertEquals(result, polynomialOperations.derivation(polynomial));
    }
}
