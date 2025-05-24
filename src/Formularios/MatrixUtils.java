/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author luisc
 */
class MatrixUtils {
    private static final String FILE_NAME = "matrix_data.txt";

    public static void saveMatrixToFile(int[][] matrix) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.write(matrix[i][j] + (j < matrix[i].length - 1 ? "," : ""));
                }
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static int[][] readMatrixFromFile() {
        int[][] matrix = new int[6][6];
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < matrix.length) {
                String[] values = line.split(",");
                for (int col = 0; col < values.length && col < matrix[row].length; col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (IOException e) {
        }
        return matrix;
    }
    
}
