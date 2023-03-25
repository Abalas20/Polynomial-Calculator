package ro.tuc;

import org.junit.Test;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.math.PolynomialOperations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PolynomialOperationAddTest {
    private final PolynomialOperations polynomialOperations = new PolynomialOperations();

    @Test
    public void testAddOperationValidPolynomials() {
        /*
         *  P1 =       x^3 + 2x^2 +  x
         *  P2 = x^5 - x^3 +  x^2 + 2x
         *  R  = x^5       + 3x^2 + 3x
         * */
        Polynomial polynomial1 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial1.addNewMonomial(new Monomial(2, BigDecimal.valueOf(2)));
        polynomial1.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));

        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(5, BigDecimal.valueOf(1)));
        polynomial2.addNewMonomial(new Monomial(3, BigDecimal.valueOf(-1)));
        polynomial2.addNewMonomial(new Monomial(2, BigDecimal.valueOf(1)));
        polynomial2.addNewMonomial(new Monomial(1, BigDecimal.valueOf(2)));

        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(5, BigDecimal.valueOf(1)));
        result.addNewMonomial(new Monomial(2, BigDecimal.valueOf(3)));
        result.addNewMonomial(new Monomial(1, BigDecimal.valueOf(3)));

        assertEquals(result, polynomialOperations.add(polynomial1, polynomial2));
    }

    @Test(expected = NullPointerException.class)
    public void testAddFirstPolynomialNull() {
        Polynomial polynomial = new Polynomial();
        polynomial.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomialOperations.add(null, polynomial);
    }

    @Test(expected = NullPointerException.class)
    public void testAddSecondPolynomialNull() {
        Polynomial polynomial = new Polynomial();
        polynomial.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomialOperations.add(polynomial, null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddBothPolynomialsNull() {
        polynomialOperations.add(null, null);
    }

    @Test
    public void testAddEmptyPolynomials() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        assertEquals(result, polynomialOperations.add(polynomial1, polynomial2));
    }

    @Test
    public void testAddPolynomialWithEmptyPolynomial() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial2.addNewMonomial(new Monomial(2, BigDecimal.valueOf(2)));
        polynomial2.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));
        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        result.addNewMonomial(new Monomial(2, BigDecimal.valueOf(2)));
        result.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));
        assertEquals(result, polynomialOperations.add(polynomial1, polynomial2));
    }
}