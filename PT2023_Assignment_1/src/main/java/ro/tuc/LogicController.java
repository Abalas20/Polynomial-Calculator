package ro.tuc;

import ro.tuc.GUI.GUI;
import ro.tuc.data_models.DivisionResult;
import ro.tuc.data_models.Polynomial;
import ro.tuc.data_models.PolynomialBuilder;
import ro.tuc.math.PolynomialOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LogicController implements ActionListener, KeyListener {
    private final GUI gui;
    private PolynomialOperations operations;
    private PolynomialBuilder polynomialBuilder;

    public LogicController() {
        gui = new GUI(this);
        operations = new PolynomialOperations();
        polynomialBuilder = new PolynomialBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "+" -> gui.appendText("+");
            case "-" -> gui.appendText("-");
            case "^" -> gui.appendText("^");
            case "X" -> gui.appendText("X");
            case "1" -> gui.appendText("1");
            case "2" -> gui.appendText("2");
            case "3" -> gui.appendText("3");
            case "4" -> gui.appendText("4");
            case "5" -> gui.appendText("5");
            case "6" -> gui.appendText("6");
            case "7" -> gui.appendText("7");
            case "8" -> gui.appendText("8");
            case "9" -> gui.appendText("9");
            case "0" -> gui.appendText("0");
            case "." -> gui.appendText(".");
            case "⌫" -> gui.removeCharacter();
            case " " -> gui.switchPolynomial();
            case "Add" -> addPolynomials();
            case "Subtract" -> subtractPolynomials();
            case "Multiply" -> multiplyPolynomials();
            case "Divide" -> dividePolynomials();
            case "Derivative" -> derivativePolynomials();
            case "Integrate" -> integratePolynomials();
        }
    }

    private void addPolynomials() {
        Polynomial polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialOne());
        Polynomial polynomial2 = polynomialBuilder.makePolynomial(gui.getPolynomialTwo());
        gui.setResultText(operations.add(polynomial1, polynomial2).toString());
    }

    private void subtractPolynomials() {
        Polynomial polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialOne());
        Polynomial polynomial2 = polynomialBuilder.makePolynomial(gui.getPolynomialTwo());
        gui.setResultText(operations.subtract(polynomial1, polynomial2).toString());
    }

    private void multiplyPolynomials() {
        Polynomial polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialOne());
        Polynomial polynomial2 = polynomialBuilder.makePolynomial(gui.getPolynomialTwo());
        gui.setResultText(operations.multiplication(polynomial1, polynomial2).toString());
    }

    private void dividePolynomials() {
        Polynomial polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialOne());
        Polynomial polynomial2 = polynomialBuilder.makePolynomial(gui.getPolynomialTwo());
        gui.setResultText(operations.divide(polynomial1, polynomial2).toString());
    }

    private void derivativePolynomials() {
        Polynomial polynomial1;
        if (gui.firstPolynomialOn.isSelected()) {
            polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialOne());
        } else {
            polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialTwo());
        }
        gui.setResultText(operations.derivation(polynomial1).toString());
    }

    private void integratePolynomials() {
        Polynomial polynomial1;
        if (gui.firstPolynomialOn.isSelected()) {
            polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialOne());
        } else {
            polynomial1 = polynomialBuilder.makePolynomial(gui.getPolynomialTwo());
        }
        gui.setResultText(operations.integration(polynomial1).toString(true) + " + C");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
