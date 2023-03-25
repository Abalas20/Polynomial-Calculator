package ro.tuc;

import org.junit.Test;
import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.data_models.PolynomialBuilder;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PolynomialBuilderTest {
    private static final PolynomialBuilder polynomialBuilder = new PolynomialBuilder();

    @Test
    public void testPolynomialBuilderValidInput() {
        String test1 = "X^2+10.12X-2X^-1+50X^10-210.12";
        Polynomial polynomial = polynomialBuilder.makePolynomial(test1);
        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(2, BigDecimal.ONE));
        result.addNewMonomial(new Monomial(1, BigDecimal.valueOf(10.12)));
        result.addNewMonomial(new Monomial(-1, BigDecimal.valueOf(-2)));
        result.addNewMonomial(new Monomial(10, BigDecimal.valueOf(50)));
        result.addNewMonomial(new Monomial(0, BigDecimal.valueOf(-210.12)));
        assertEquals(result, polynomial);
    }

    @Test
    public void testPolynomialBuilderValidInput2() {
        String test1 = "X^2+X^2";
        Polynomial polynomial = polynomialBuilder.makePolynomial(test1);
        Polynomial result = new Polynomial();
        result.addNewMonomial(new Monomial(2, new BigDecimal("2")));
        assertEquals(result, polynomial);
    }
}
