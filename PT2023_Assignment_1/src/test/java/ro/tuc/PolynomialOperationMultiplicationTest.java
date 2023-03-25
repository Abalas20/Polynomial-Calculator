package ro.tuc;

import org.junit.Test;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.math.PolynomialOperations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PolynomialOperationMultiplicationTest {
    private final PolynomialOperations polynomialOperations = new PolynomialOperations();

    @Test
    public void testMultiplyOperationValidPolynomials() {
        /*
         *  P1 =        3x^2 -  x + 1
         *  P2 =                x - 2
         *  R  = 3x^3 - 7x^2 + 3x - 2
         * */
        Polynomial polynomial1 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(2, BigDecimal.valueOf(3)));
        polynomial1.addNewMonomial(new Monomial(1, BigDecimal.valueOf(-1)));
        polynomial1.addNewMonomial(new Monomial(0, BigDecimal.valueOf(1)));

        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));
        polynomial2.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-2)));

        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(3, BigDecimal.valueOf(3)));
        result.addNewMonomial(new Monomial(2, BigDecimal.valueOf(-7)));
        result.addNewMonomial(new Monomial(1, BigDecimal.valueOf(3)));
        result.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-2)));

        assertEquals(result, polynomialOperations.multiplication(polynomial1, polynomial2));
    }

    @Test(expected = NullPointerException.class)
    public void testMultiplyFirstPolynomialNull() {
        Polynomial polynomial = new Polynomial();
        polynomial.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomialOperations.multiplication(null, polynomial);
    }

    @Test(expected = NullPointerException.class)
    public void testMultiplySecondPolynomialNull() {
        Polynomial polynomial = new Polynomial();
        polynomial.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomialOperations.multiplication(polynomial, null);
    }

    @Test(expected = NullPointerException.class)
    public void testMultiplyBothPolynomialsNull() {
        polynomialOperations.multiplication(null, null);
    }

    @Test
    public void testMultiplyEmptyPolynomials() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        assertEquals(result, polynomialOperations.multiplication(polynomial1, polynomial2));
    }

    @Test
    public void testMultiplyPolynomialWithEmptyPolynomial() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial2.addNewMonomial(new Monomial(2, BigDecimal.valueOf(2)));
        polynomial2.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));
        Polynomial result = new Polynomial();
        assertEquals(result, polynomialOperations.multiplication(polynomial1, polynomial2));
    }

    @Test
    public void testMultiplyEmptyPolynomialWithPolynomial() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial1.addNewMonomial(new Monomial(2, BigDecimal.valueOf(2)));
        polynomial1.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));
        Polynomial result = new Polynomial();
        assertEquals(result, polynomialOperations.multiplication(polynomial1, polynomial2));
    }
}