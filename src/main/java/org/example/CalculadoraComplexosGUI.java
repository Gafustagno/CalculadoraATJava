package org.example;

import javax.swing.*;
import java.awt.*;

public class CalculadoraComplexosGUI extends JFrame {
    private JTextField real1Field, imag1Field, real2Field, imag2Field;
    private JLabel resultadoLabel;

    public CalculadoraComplexosGUI() {
        setTitle("Calculadora AT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Número 1:"), gbc);
        gbc.gridx = 1;
        real1Field = new JTextField(5);
        add(real1Field, gbc);

        gbc.gridx = 2;
        add(new JLabel("Imaginário 1:"), gbc);
        gbc.gridx = 3;
        imag1Field = new JTextField(5);
        add(imag1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Número 2:"), gbc);
        gbc.gridx = 1;
        real2Field = new JTextField(5);
        add(real2Field, gbc);

        gbc.gridx = 2;
        add(new JLabel("Imaginário 2:"), gbc);
        gbc.gridx = 3;
        imag2Field = new JTextField(5);
        add(imag2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JButton calcularSoma = new JButton("Soma");
        calcularSoma.addActionListener(e -> somar());
        add(calcularSoma, gbc);

        gbc.gridx = 1;
        JButton calcularSub = new JButton("Subtração");
        calcularSub.addActionListener(e -> subtrair());
        add(calcularSub, gbc);

        gbc.gridx = 2;
        JButton calcularMod = new JButton("Módulo");
        calcularMod.addActionListener(e -> modulo());
        add(calcularMod, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        resultadoLabel = new JLabel("Resultado:");
        add(resultadoLabel, gbc);

        setVisible(true);
    }

    private void somar() {
        try {
            double real1 = Double.parseDouble(real1Field.getText());
            double imag1 = Double.parseDouble(imag1Field.getText());
            double real2 = Double.parseDouble(real2Field.getText());
            double imag2 = Double.parseDouble(imag2Field.getText());

            NumeroComplexo numero1 = new NumeroComplexo(real1, imag1);
            NumeroComplexo numero2 = new NumeroComplexo(real2, imag2);
            numero1.adicionar(numero2);

            resultadoLabel.setText("Resultado: " + numero1);
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Entrada inválida!");
        }
    }

    private void subtrair(){
        try{
            double real1 = Double.parseDouble(real1Field.getText());
            double imag1 = Double.parseDouble(imag1Field.getText());
            double real2 = Double.parseDouble(real2Field.getText());
            double imag2 = Double.parseDouble(imag2Field.getText());

            NumeroComplexo numero1 = new NumeroComplexo(real1, imag1);
            NumeroComplexo numero2 = new NumeroComplexo(real2, imag2);
            numero1.subtrair(numero2);

            resultadoLabel.setText("Resultado: " + numero1);
        } catch(NumberFormatException ex){
            resultadoLabel.setText("Entrada inválida!");
        }
    }

    private void modulo(){
        try {
            double real = Double.parseDouble(real1Field.getText());
            double imag = Double.parseDouble(imag1Field.getText());

            NumeroComplexo numero = new NumeroComplexo(real, imag);
            double modulo = numero.modulo();

            resultadoLabel.setText("Módulo: " + modulo);
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Entrada inválida!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraComplexosGUI();
            }
        });
    }
}
