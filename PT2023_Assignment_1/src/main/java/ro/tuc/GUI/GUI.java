package ro.tuc.GUI;

import ro.tuc.control_unit.LogicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
    private static final String[] OPERATIONS_NAME = {"Add", "Subtract", "Multiply", "Divide", "Derivative", "Integrate"};
    private  JTextField polynomial1Text = new JTextField();
    private  JTextField polynomial2Text = new JTextField();
    private  JTextField resultText = new JTextField();
    public JRadioButton firstPolynomialOn = new JRadioButton();
    private JRadioButton secondPolynomialOn = new JRadioButton();
    private JButton[] operations = new JButton[6];
    private JButton[] leftHalfButton = new JButton[12];
    private JPanel leftPanel = new JPanel(new GridLayout(4, 3));
    private JButton[] rightHalfButton = new JButton[4];
    private JPanel rightPanel = new JPanel(new GridLayout(4, 1));
    private JButton spaceButton = new JButton(" ");

    public GUI(LogicController controller) {
        setTitle("Polynomial Calculator");
        setLayout(null);
        setSize(1024, 768);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle();
        setTextFieldsAndLabels();
        setOperationButtons();
        setLeftHalfButtons();
        setRightHalfButtons();
        setAllButtons(controller);
        setButtonsShortcuts();
        setVisible(true);
    }

    private void setTitle() {
        JLabel title = new JLabel("Polynomial Calculator");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setBounds(312, 20, 400, 40);
        add(title);
    }

    private void setTextFieldsAndLabels() {
        JLabel polynomial1 = new JLabel("First Polynomial      =");
        JLabel polynomial2 = new JLabel("Second Polynomial =");
        JLabel result = new JLabel("Result =");
        polynomial1.setFont(new Font("Arial", Font.BOLD, 25));
        polynomial1.setBounds(100, 110, 250, 25);

        polynomial1Text.setFont(new Font("Arial", Font.BOLD, 25));
        polynomial1Text.setBounds(360, 95, 560, 50);
        polynomial1Text.setBackground(Color.white);
        polynomial1Text.setEditable(false);

        polynomial2.setFont(new Font("Arial", Font.BOLD, 25));
        polynomial2.setBounds(100, 180, 250, 25);

        result.setFont(new Font("Arial", Font.BOLD, 25));
        result.setBounds(100, 395, 250, 25);

        polynomial2Text.setFont(new Font("Arial", Font.BOLD, 25));
        polynomial2Text.setBounds(360, 165, 560, 50);
        polynomial2Text.setBackground(Color.white);
        polynomial2Text.setEditable(false);

        resultText.setFont(new Font("Arial", Font.BOLD, 30));
        resultText.setBounds(210, 380, 710, 60);
        resultText.setBackground(Color.white);
        resultText.setEditable(false);

        firstPolynomialOn.setBounds(50, 110, 50, 25);
        firstPolynomialOn.setSelected(true);
        add(firstPolynomialOn);

        secondPolynomialOn.setBounds(50, 180, 50, 25);
        add(secondPolynomialOn);

        ButtonGroup polygonButtonGroup = new ButtonGroup();
        polygonButtonGroup.add(firstPolynomialOn);
        polygonButtonGroup.add(secondPolynomialOn);

        add(polynomial1Text);
        add(polynomial2Text);
        add(resultText);
        add(polynomial1);
        add(polynomial2);
        add(result);
    }

    private void setOperationButtons() {
        for (int i = 0; i < 6; i++) {
            operations[i] = new JButton(OPERATIONS_NAME[i]);
            add(operations[i]);
        }
        Dimension buttonSize = new Dimension(50, 50);
        for (JButton button : operations) {
            button.setPreferredSize(buttonSize);
        }
        for (JButton component : operations) {
            component.setBackground(Color.white);
            component.setFont(new Font("Ariel", Font.BOLD, 20));
            component.setForeground(Color.white);
            component.setBackground(new Color(51, 51, 51));
        }
        operations[0].setBounds(100, 250, 260, 50);
        add(operations[0]);

        operations[1].setBounds(100, 310, 260, 50);
        add(operations[1]);

        operations[2].setBounds(380, 250, 260, 50);
        add(operations[2]);

        operations[3].setBounds(380, 310, 260, 50);
        add(operations[3]);

        operations[4].setBounds(660, 250, 260, 50);
        add(operations[4]);

        operations[5].setBounds(660, 310, 260, 50);
        add(operations[5]);
    }

    private void setLeftHalfButtons() {
        for (int i = 0; i < 9; i++) {
            leftHalfButton[i] = new JButton(String.valueOf(i + 1));
            leftPanel.add(leftHalfButton[i]);
        }
        leftHalfButton[9] = new JButton(".");
        leftPanel.add(leftHalfButton[9]);
        leftHalfButton[10] = new JButton(String.valueOf(0));
        leftPanel.add(leftHalfButton[10]);
        leftHalfButton[11] = new JButton("X");
        leftPanel.add(leftHalfButton[11]);
        for (JButton component : leftHalfButton) {
            component.setBackground(Color.white);
            component.setFont(new Font("Ariel", Font.BOLD, 20));
            component.setForeground(Color.white);
            component.setBackground(new Color(93, 93, 93));
        }
        leftPanel.setBounds(100, 450, 645, 275);
        add(leftPanel);
    }

    private void setRightHalfButtons() {
        rightHalfButton[0] = new JButton("⌫");
        rightPanel.add(rightHalfButton[0]);
        rightHalfButton[1] = new JButton("^");
        rightPanel.add(rightHalfButton[1]);
        rightHalfButton[2] = new JButton("-");
        rightPanel.add(rightHalfButton[2]);
        rightHalfButton[3] = new JButton("+");
        rightPanel.add(rightHalfButton[3]);
        for (JButton button : rightHalfButton) {
            button.setBackground(Color.white);
            button.setFont(new Font("Ariel", Font.BOLD, 20));
            button.setForeground(Color.white);
            button.setBackground(new Color(147, 144, 144));
        }
        rightHalfButton[0].setBackground(new Color(255, 41, 41));
        rightPanel.setBounds(745, 450, 175, 275);
        add(rightPanel);
    }

    private void setAllButtons(LogicController controller) {
        for (JButton button : leftHalfButton) {
            button.addActionListener(controller);
        }
        for (JButton button : rightHalfButton) {
            button.addActionListener(controller);
        }
        for (JButton button : operations) {
            button.addActionListener(controller);
        }
        spaceButton.addActionListener(controller);
        add(spaceButton);
    }

    private void setButtonsShortcuts() {
        setButton(KeyEvent.VK_NUMPAD1, leftHalfButton[0]);
        setButton(KeyEvent.VK_NUMPAD2, leftHalfButton[1]);
        setButton(KeyEvent.VK_NUMPAD3, leftHalfButton[2]);
        setButton(KeyEvent.VK_NUMPAD4, leftHalfButton[3]);
        setButton(KeyEvent.VK_NUMPAD5, leftHalfButton[4]);
        setButton(KeyEvent.VK_NUMPAD6, leftHalfButton[5]);
        setButton(KeyEvent.VK_NUMPAD7, leftHalfButton[6]);
        setButton(KeyEvent.VK_NUMPAD8, leftHalfButton[7]);
        setButton(KeyEvent.VK_NUMPAD9, leftHalfButton[8]);
        setButton(KeyEvent.VK_DECIMAL, leftHalfButton[9]);
        setButton(KeyEvent.VK_NUMPAD0, leftHalfButton[10]);
        setButton(KeyEvent.VK_1, leftHalfButton[0]);
        setButton(KeyEvent.VK_2, leftHalfButton[1]);
        setButton(KeyEvent.VK_3, leftHalfButton[2]);
        setButton(KeyEvent.VK_4, leftHalfButton[3]);
        setButton(KeyEvent.VK_5, leftHalfButton[4]);
        setButton(KeyEvent.VK_6, leftHalfButton[5]);
        setButton(KeyEvent.VK_7, leftHalfButton[6]);
        setButton(KeyEvent.VK_8, leftHalfButton[7]);
        setButton(KeyEvent.VK_9, leftHalfButton[8]);
        setButton(KeyEvent.VK_PERIOD, leftHalfButton[9]);
        setButton(KeyEvent.VK_0, leftHalfButton[10]);
        setButton(KeyEvent.VK_X, leftHalfButton[11]);
        setButton(KeyEvent.VK_DOWN, rightHalfButton[0]);
        setButton(KeyEvent.VK_UP, rightHalfButton[1]);
        setButton(KeyEvent.VK_SUBTRACT, rightHalfButton[2]);
        setButton(KeyEvent.VK_ADD, rightHalfButton[3]);
        setButton(KeyEvent.VK_SPACE, spaceButton);
    }

    private void setButton(int virtualKey, JButton button) {
        InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = button.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(virtualKey, 0), "clickMe");
        actionMap.put("clickMe", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.doClick();
            }
        });
    }

    private boolean validate(String text, String existingText) {
        boolean result = true;
        if (text.equals("-") || text.equals("+")) {
            result = !isSigned(text, existingText);
        }
        if (text.equals("^") && existingText.endsWith("^")) {
            return false;
        }
        return result;
    }

    private boolean isSigned(String text, String existingText) {
        return existingText.endsWith("-") || existingText.endsWith("+");
    }

    public void appendText(String text) {
        if (firstPolynomialOn.isSelected()) {
            if (validate(text, polynomial1Text.getText())) {
                polynomial1Text.setText(polynomial1Text.getText() + text);
            }
        } else {
            if (validate(text, polynomial2Text.getText())) {
                polynomial2Text.setText(polynomial2Text.getText() + text);
            }
        }
    }

    public void removeCharacter() {
        if (firstPolynomialOn.isSelected()) {
            String text = polynomial1Text.getText();
            if (text.length() != 0) {
                polynomial1Text.setText(polynomial1Text.getText().substring(0, text.length() - 1));
            }
        } else {
            String text = polynomial2Text.getText();
            if (text.length() != 0) {
                polynomial2Text.setText(polynomial2Text.getText().substring(0, text.length() - 1));
            }
        }
    }

    public void switchPolynomial() {
        if (firstPolynomialOn.isSelected()) {
            firstPolynomialOn.setSelected(false);
            secondPolynomialOn.setSelected(true);
        } else {
            firstPolynomialOn.setSelected(true);
            secondPolynomialOn.setSelected(false);
        }
    }

    public String getPolynomialOne() {
        return polynomial1Text.getText();
    }

    public String getPolynomialTwo() {
        return polynomial2Text.getText();
    }

    public void setResultText(String result) {
        resultText.setText(result);
    }
}
