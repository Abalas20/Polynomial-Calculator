package ro.tuc.math;

import ro.tuc.data_models.DivisionResult;
import ro.tuc.data_models.Polynomial;

public class PolynomialOperations {

    PolynomialAdder adder;
    PolynomialSubtractor subtractor;
    PolynomialNegator negator;
    PolynomialMultiplicator multiplicator;

    PolynomialDerivator derivator;
    PolynomialIntegrator integrator;
    PolynomialDivider divider;

    public PolynomialOperations() {
        adder = new PolynomialAdder();
        subtractor = new PolynomialSubtractor();
        negator = new PolynomialNegator();
        multiplicator = new PolynomialMultiplicator();
        derivator = new PolynomialDerivator();
        integrator = new PolynomialIntegrator();
        divider = new PolynomialDivider();
    }

    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        return adder.add(polynomial1, polynomial2);
    }

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        return subtractor.subtract(polynomial1, polynomial2);
    }

    public Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2) {
        return multiplicator.multiplication(polynomial1, polynomial2);
    }

    public Polynomial derivation(Polynomial polynomial) {
        return derivator.derivation(polynomial);
    }

    public Polynomial integration(Polynomial polynomial) {
        return integrator.integration(polynomial);
    }

    public DivisionResult divide(Polynomial polynomial1, Polynomial polynomial2) {
        return divider.divide(polynomial1, polynomial2);
    }
}