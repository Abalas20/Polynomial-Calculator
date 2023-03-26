package ro.tuc.control_unit;

import ro.tuc.data_models.Monomial;
import ro.tuc.data_models.Polynomial;
import ro.tuc.math.PolynomialAdder;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialBuilder {
    private static final String REGEX_POLYNOMIAL = "([+-]?(\\d(\\.\\d)*)*X\\^[+-]?\\d+|[+-]?(\\d(\\.\\d)*)*X?|[+-]?\\d*X?\\^[+-]?\\d+|[+-]?(\\d(\\.\\d)*)+)";
    private final static PolynomialAdder ADDER = new PolynomialAdder();
    private final Pattern pattern;


    public PolynomialBuilder() {
        pattern = Pattern.compile(REGEX_POLYNOMIAL);
    }

    public Polynomial makePolynomial(String input) {
        Polynomial polynomial = new Polynomial();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group(0).isEmpty()) {
                continue;
            }
            Polynomial monomial = buildMonomial(matcher.group(0));
            polynomial = ADDER.add(polynomial, monomial);
        }
        return polynomial;
    }

    private Polynomial buildMonomial(String monomialString) {
        Polynomial polynomial = new Polynomial();
        BigDecimal coefficient;
        if (monomialString.contains("X^")) {
            String[] parts = monomialString.split("X\\^");
            coefficient = getCoefficientValue(parts[0]);
            int degree = Integer.parseInt(parts[1]);
            polynomial.addNewMonomial(new Monomial(degree, coefficient));
            return polynomial;
        } else if (monomialString.contains("X")) {
            String coeff = monomialString.replace("X", "");
            coefficient = getCoefficientValue(coeff);
            int degree = 1;
            polynomial.addNewMonomial(new Monomial(degree, coefficient));
            return polynomial;
        } else {
            coefficient = getCoefficientValue(monomialString);
            int degree = 0;
            polynomial.addNewMonomial(new Monomial(degree, coefficient));
            return polynomial;
        }
    }

    private BigDecimal getCoefficientValue(String input) {
        BigDecimal result;
        if (input.equals("+") || input.equals("-") || input.equals("^") || input.isEmpty()) {
            result = BigDecimal.ONE;
            if (input.equals("-")) {
                result = new BigDecimal("-1");
            }
        } else {
            result = new BigDecimal(input);
        }
        return result;
    }
}
