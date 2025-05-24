/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author luisc
 */
public class FrmMatriz extends JFrame {
    private JTextField[][] textFields;
    private JButton btnSave, btnList;
    private static final int SIZE = 6;
    private int[][] matrix;

    public FrmMatriz() {
        matrix = new int[SIZE][SIZE];
        textFields = new JTextField[SIZE][SIZE];
        setTitle("6x6 Matrix Input");
        setLayout(new GridLayout(SIZE + 1, SIZE));
        initializeForm();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeForm() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                textFields[i][j] = new JTextField(3);
                add(textFields[i][j]);
            }
        }

        btnSave = new JButton("Save Matrix");
        btnList = new JButton("List Matrix");
        add(btnSave);
        add(btnList);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMatrix();
            }
        });

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listMatrix();
            }
        });
    }

    private void saveMatrix() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(textFields[i][j].getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input at (" + i + ", " + j + ")");
                    return;
                }
            }
        }
        MatrixUtils.saveMatrixToFile(matrix);
        JOptionPane.showMessageDialog(this, "Matrix saved successfully!");
    }

    private void listMatrix() {
        StringBuilder sb = new StringBuilder();
        int[][] loadedMatrix = MatrixUtils.readMatrixFromFile();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(loadedMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Matrix Data", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmMatriz());
    }
}

