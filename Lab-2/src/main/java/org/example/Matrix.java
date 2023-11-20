package org.example;

import java.util.Arrays;
import java.util.Random;

public class Matrix implements matrixInterface{
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
    public Matrix(Immutable immutableMatrix) {
        this.rows = immutableMatrix.getNumRows();
        this.columns = immutableMatrix.getNumColumns();
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(immutableMatrix.getData()[i], 0, this.data[i], 0, columns);
        }
    }

    @Override
    public void fillMatrix(double[][] values) {
        if (values.length == this.rows && values[0].length == this.columns) {
            for (int i = 0; i < this.rows; ++i) {
                for (int j = 0; j < this.columns; ++j) {
                    this.data[i][j] = values[i][j];
                }
            }
        } else {
            throw new IllegalArgumentException("The provided values array doesn't match the matrix dimensions.");
        }
    }

    @Override
    public void fillMatrix() {

    }


    @Override
    public void printMatrix() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    @Override
    public int[] dimension() {
        int[] d = {rows, columns};
        System.out.printf("Rows: %d \nColumns: %d\n", rows, columns);
        return d;
    }
    @Override
    public int getNumRows() {
        return rows;
    }
    @Override
    public double[][] getData() {
        return data;
    }
    @Override
    public int getNumColumns() {
        return columns;
    }

    @Override // Getter для елементу
    public double getElement(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        return data[row][column];
    }

    @Override // Getter для рядка
    public double[] getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows) {
            throw new IllegalArgumentException("Invalid row index");
        }
        return data[rowIndex];
    }

    @Override// Getter для стовпця
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
    public static Matrix RandomMatrix(int rows, int columns, double min, double max) {
        Random random = new Random();
        Matrix r = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double randomValue = min + (max - min) * random.nextDouble();
                r.setElement(i, j, randomValue);
            }
        }

        return r;
    }

    @Override //множення матриць
    public Matrix multiply(Matrix matrixA, Matrix matrixB) {
        double[][] matrixAData = matrixA.getData();
        double[][] matrixBData = matrixB.getData();

        int rowsA = matrixA.getNumRows();
        int columnsA = matrixA.getNumColumns();
        int columnsB = matrixB.getNumColumns();

        if (matrixAData[0].length != matrixBData.length) {
            System.err.println("These matrices cannot be multiplied.");
            return null;
        }

        Matrix resultMatrix = new Matrix(rowsA, columnsB);
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    resultMatrix.setElement(i, j, resultMatrix.getElement(i, j) + matrixAData[i][k] * matrixBData[k][j]);
                }
            }
        }
        return resultMatrix;
    }



    //множення на скаляр
    public static Matrix scalar(Matrix matrix, double num) {
        double[][] matrixData = matrix.getData();
        int rows = matrix.getNumRows();
        int columns = matrix.getNumColumns();
        Matrix resultMatrix = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix.setElement(i, j, resultMatrix.getElement(i, j) + matrixData[i][j] * num);
            }
        }
        return resultMatrix;
    }

    @Override
    public Matrix add(Matrix matrixB) {
        double[][] matrixAData = this.getData();
        double[][] matrixBData = matrixB.getData();
        int rowsA = this.getNumRows();
        int columnsA = this.getNumColumns();
        int rowsB = matrixB.getNumRows();
        int columnsB = matrixB.getNumColumns();

        if (rowsB != rowsA || columnsB != columnsA) {
            System.err.println("Matrices must have the same dimensions for addition.");
            return null;
        }

        Matrix resultMatrix = new Matrix(rowsA, columnsA);
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsA; j++) {
                resultMatrix.setElement(i, j, matrixAData[i][j] + matrixBData[i][j]);
            }
        }

        return resultMatrix;
    }
    //одинична матриця
    public static Matrix UnitMatrix(int row,int column) {
        Matrix resultMatrix = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == j) {
                    resultMatrix.setElement(i, j, 1);
                }else{
                resultMatrix.setElement(i, j, 0);}
            }
        }
        return resultMatrix;
    }
    //векторна матриця
    public static Matrix VectorMatrix(Matrix matrix,double[] vec) {
        int lenVec = vec.length;
        Matrix resultMatrix = new Matrix(lenVec, lenVec);
        for (int i = 0; i < lenVec; i++) {
            resultMatrix.setElement(i, i, vec[i]);
        }
        return resultMatrix;
    }

    @Override
    public  Matrix transposed(Matrix matrix) {
        int row = matrix.getNumRows();
        int column = matrix.getNumColumns();
        Matrix resultMatrix = new Matrix(column, row);
        for (int i = 0; i < row; i++) {
            resultMatrix.setColumn(i, matrix.getRow(i));
        }
        return resultMatrix;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Matrix otherMatrix = (Matrix) obj;
        return Arrays.deepEquals(this.data, otherMatrix.data);
    }
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }

    public static Matrix invert(Matrix matrix) {
        int rows = matrix.getNumRows();
        int columns = matrix.getNumColumns();

        // Create an augmented matrix [matrix | I]
        double[][] augmentedMatrix = new double[rows][2 * columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                augmentedMatrix[i][j] = matrix.getData()[i][j];
                augmentedMatrix[i][j + columns] = (i == j) ? 1 : 0;
            }
        }
        // Apply Gauss-Jordan elimination
        for (int i = 0; i < rows; i++) {
            // Make the diagonal element 1
            double pivot = augmentedMatrix[i][i];
            for (int j = 0; j < 2 * columns; j++) {
                augmentedMatrix[i][j] /= pivot;
            }
            // Make other rows 0
            for (int k = 0; k < rows; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * columns; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }
        // Extract the inverse matrix from the augmented matrix
        Matrix inverse = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            System.arraycopy(augmentedMatrix[i], columns, inverse.getData()[i], 0, columns);
        }
        return inverse;
    }
    // Method to find the inverse matrix

}



