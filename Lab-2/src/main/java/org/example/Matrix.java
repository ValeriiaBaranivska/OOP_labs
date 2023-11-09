package org.example;
import java.util.Random;
import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] data;
    // конструктор порожньої матриці
    public Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.data = new double[0][0];
    }
    //матриці заданого розміру
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[this.rows][this.columns];
    }
    //конструктор копії матриці
    public Matrix(Matrix otherMatrix) {
        this.rows = otherMatrix.rows;
        this.columns = otherMatrix.columns;
        this.data = new double[this.rows][this.columns];
        // Copy the values from the otherMatrix to the new matrix
        for (int i = 0; i < this.rows; ++i) {
            this.data[i] = Arrays.copyOf(otherMatrix.data[i], this.columns);
        }
    }

    public void fillMatrix(double[][] values) {
        if (values.length == this.rows && values[0].length == this.columns) {
            for(int i = 0; i < this.rows; ++i) {
                for(int j = 0; j < this.columns; ++j) {
                    this.data[i][j] = values[i][j];
                }
            }

        } else {
            throw new IllegalArgumentException("The provided values array doesn't match the matrix dimensions.");
        }
    }
    public void printMatrix() {
        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.columns; ++j) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    public int getNumRows() {
        return rows;
    }
    public int getNumColumns() {
        return columns;
    }

    // Getter для елементу
    public double getElement(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        return data[row][column];
    }
    // Getter для рядка
    public double[] getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows) {
            throw new IllegalArgumentException("Invalid row index");
        }
        return Arrays.copyOf(data[rowIndex], columns);
    }
    // Getter для стовпця
    public double[] getColumn(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= columns) {
            throw new IllegalArgumentException("Invalid column index");
        }
        double[] columnData = new double[rows];
        for (int i = 0; i < rows; i++) {
            columnData[i] = data[i][columnIndex];
        }
        return columnData;
    }
    // Setter для елементу
    public void setElement(int row, int column, double value) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        data[row][column] = value;
    }
    // Setter для рядка
    public void setRow(int rowIndex, double[] values) {
        if (rowIndex < 0 || rowIndex >= rows || values.length != columns) {
            throw new IllegalArgumentException("Invalid row index or values array length");
        }
        System.arraycopy(values, 0, data[rowIndex], 0, columns);
    }
    // Setter для стовпця
    public void setColumn(int columnIndex, double[] values) {
        if (columnIndex < 0 || columnIndex >= columns || values.length != rows) {
            throw new IllegalArgumentException("Invalid column index or values array length");
        }
        for (int i = 0; i < rows; i++) {
            data[i][columnIndex] = values[i];
        }
    }
    public void RandomMatrix() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextDouble(); // Можна використовувати інші методи Random для інших типів даних
            }
        }
    }


}