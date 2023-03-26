package ro.tuc.data_models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Polynomial {
    private final Map<Integer, Monomial> polynomial;

    public Polynomial() {
        polynomial = new HashMap<>();
    }

    public Map<Integer, Monomial> getPolynomial() {
        return polynomial;
    }

    public void addNewMonomial(Monomial monomial) {
        polynomial.put(monomial.getDegree(), monomial);
    }

    public void removeMonomial(int degree) {
        polynomial.remove(degree);
    }

    public int getSize() {
        return polynomial.size();
    }

    public boolean isEmpty() {
        return polynomial.isEmpty();
    }

    public int getHighestDegree() {
        TreeMap<Integer,Monomial> sortedMap = new TreeMap<>(polynomial);
        return sortedMap.lastKey();
    }

    public boolean isZero() {
        if (polynomial.size() == 1) {
            return polynomial.get(getHighestDegree()).getDegree() == 0 && polynomial.get(getHighestDegree()).getCoefficient().compareTo(BigDecimal.ZERO) == 0;
        }
        return false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Polynomial that = (Polynomial) object;
        return Objects.equals(polynomial, that.polynomial);
    }

    @Override
    public String toString() {
        if (polynomial.isEmpty()) {
            return "0";
        }
        StringBuilder polynomialStringBuilder = new StringBuilder();
        TreeMap<Integer,Monomial> sortedMap = new TreeMap<>(polynomial);
        boolean firstMonomial = true;
        for (Monomial monomial : sortedMap.descendingMap().values()) {
            if (firstMonomial) {
                polynomialStringBuilder.append(monomial);
                firstMonomial = false;
            } else {
                polynomialStringBuilder.append(" ").append(monomial);
            }
        }
        return polynomialStringBuilder.toString();
    }

    public String toString(boolean integration) {
        if (polynomial.isEmpty()) {
            return "0";
        }
        StringBuilder polynomialStringBuilder = new StringBuilder();
        TreeMap<Integer,Monomial> sortedMap = new TreeMap<>(polynomial);
        boolean firstMonomial = true;
        for (Monomial monomial : sortedMap.descendingMap().values()) {
            if (firstMonomial) {
                polynomialStringBuilder.append(monomial.toString(integration));
                firstMonomial = false;
            } else {
                polynomialStringBuilder.append(" ").append(monomial.toString(integration));
            }
        }
        return polynomialStringBuilder.toString();
    }
}
