package ro.tuc;

import org.junit.Test;
import ro.tuc.data_models.DivisionResult;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.math.PolynomialOperations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PolynomialDividerTest {
    private final PolynomialOperations polynomialOperations = new PolynomialOperations();

    @Test
    public void testDivideOperationValidPolynomials() {
        /*
         *  P1 = x^3 - 2x^2 + 6x - 5
         *  P2 =        x^2      - 1
         *  Quotient =         x - 2
         *  Reminder =        7x - 7
         * */
        Polynomial polynomial1 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(3, BigDecimal.valueOf(1)));
        polynomial1.addNewMonomial(new Monomial(2, BigDecimal.valueOf(-2)));
        polynomial1.addNewMonomial(new Monomial(1, BigDecimal.valueOf(6)));
        polynomial1.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-5)));

        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(2, BigDecimal.valueOf(1)));
        polynomial2.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-1)));

        Polynomial quotient = new Polynomial();
        quotient.addNewMonomial(new Monomial(1, BigDecimal.valueOf(1)));
        quotient.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-2)));

        Polynomial reminder = new Polynomial();
        reminder.addNewMonomial(new Monomial(1, BigDecimal.valueOf(7)));
        reminder.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-7)));

        DivisionResult result = polynomialOperations.divide(polynomial1, polynomial2);

        assertEquals(quotient, result.getQuotient());
        assertEquals(reminder, result.getRemainder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDividerEmptyPolynomials() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomialOperations.divide(polynomial1, polynomial2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDividerEmptyDividend() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(0, BigDecimal.valueOf(10)));
        polynomialOperations.divide(polynomial1, polynomial2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDividerEmptyDivisor() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial1.addNewMonomial(new Monomial(0, BigDecimal.valueOf(10)));
        polynomialOperations.divide(polynomial1, polynomial2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial2.addNewMonomial(new Monomial(0, BigDecimal.ZERO));
        polynomial1.addNewMonomial(new Monomial(0, BigDecimal.valueOf(10)));
        polynomialOperations.divide(polynomial1, polynomial2);
    }
}