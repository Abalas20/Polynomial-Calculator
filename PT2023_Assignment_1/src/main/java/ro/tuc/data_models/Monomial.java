package ro.tuc.data_models;

import java.math.BigDecimal;

public class Monomial {
    private int degree;
    private BigDecimal coefficient;

    public Monomial(int degree, BigDecimal coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        if (degree != monomial.degree) return false;
        return coefficient.equals(monomial.coefficient);
    }

    @Override
    public int hashCode() {
        return 31 * degree + coefficient.hashCode();
    }

    @Override
    public String toString() {
        if (coefficient.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        StringBuilder monomialStringBuilder = new StringBuilder();
        if (coefficient.compareTo(BigDecimal.ZERO) < 0) {
            monomialStringBuilder.append("-");
        } else if (coefficient.compareTo(BigDecimal.ZERO) > 0) {
            monomialStringBuilder.append("+");
        }
        BigDecimal absCoefficient = coefficient.abs().stripTrailingZeros();
        if (absCoefficient.compareTo(BigDecimal.ONE) == 0 && degree != 0) {
            monomialStringBuilder.append("X");
        } else {
            monomialStringBuilder.append(absCoefficient.toPlainString());
            if (degree != 0) {
                monomialStringBuilder.append("X");
            }
        }
        if (degree != 0 && degree != 1) {
            if (degree < 0) {
                monomialStringBuilder.append("^").append("(").append(degree).append(")");
            } else {
                monomialStringBuilder.append("^").append(degree);
            }

        }
        return monomialStringBuilder.toString();
    }

    public String toString(boolean integration) {
        if (coefficient.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        if (integration && degree != 0) {
           return toString();
        }
        StringBuilder monomialStringBuilder = new StringBuilder();
        if (coefficient.compareTo(BigDecimal.ZERO) < 0) {
            monomialStringBuilder.append("-");
        } else if (coefficient.compareTo(BigDecimal.ZERO) > 0) {
            monomialStringBuilder.append("+");
        }
        BigDecimal absCoefficient = coefficient.abs().stripTrailingZeros();
        if (absCoefficient.compareTo(BigDecimal.ONE) == 0) {
            monomialStringBuilder.append("ln(X)");
        } else {
            monomialStringBuilder.append(absCoefficient.toPlainString());
                monomialStringBuilder.append("ln(X)");
        }
        return monomialStringBuilder.toString();
    }

}
