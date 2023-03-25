package ro.tuc;

import org.junit.Test;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.math.PolynomialOperations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PolynomialOperationIntegrationTest {
    private final PolynomialOperations polynomialOperations = new PolynomialOperations();

    @Test
    public void testIntegrationOperationValidPolynomials() {
        /*
         *  P1 =       x^3 + 2x^2 +  x
         *  R  = 0.25x^4 + 0.66X^3 + 0.5x^2
         * */
        Polynomial polynomial1 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial1.addNewMonomial(new Monomial(2, BigDecimal.valueOf(2)));
        polynomial1.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));

        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(4, BigDecimal.valueOf(0.25)));
        result.addNewMonomial(new Monomial(3, BigDecimal.valueOf(0.67)));
        result.addNewMonomial(new Monomial(2, BigDecimal.valueOf(0.5)));

        assertEquals(result.toString(),polynomialOperations.integration(polynomial1).toString(true));
    }

    @Test
    public void testIntegrationOperationLNX() {
        /*
         *  P1 = -x^(-1)
         *  R  = -ln(x)
         * */
        Polynomial polynomial1 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(-1, BigDecimal.valueOf(-1)));
        assertEquals("-ln(X)",polynomialOperations.integration(polynomial1).toString(true));
    }

}
