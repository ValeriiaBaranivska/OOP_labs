package org.example;

import java.util.Arrays;

public class Immutable extends Matrix implements matrixInterface {
        private final int rows;
        private final int columns;
        private final double[][] data;

        public Immutable() {
            this.rows = 0;
            this.columns = 0;
            this.data = new double[0][0];
        }

        public Immutable(int rows, int columns, double[][] data) {
            this.rows = rows;
            this.columns = columns;
            this.data = data;
        }

    @Override
    public void printMatrix() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    @Override
    public int getNumColumns() {
        return columns;
    }
    @Override
    public int getNumRows() {
        return rows;
    }

    @Override
    public int[] dimension() {
        System.out.printf("Rows: %d \nColumns: %d\n", rows, columns);
        return new int[0];
    }

    @Override
    public double[][] getData() {
        return data;
    }

    @Override
    public double getElement(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        return data[row][column];

    }

    @Override
    public double[] getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows) {
            throw new IllegalArgumentException("Invalid row index");
        }
        return data[rowIndex];
    }

    @Override
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

    @Override
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



    @Override
    public Matrix transposed(Matrix matrix) {
        int row = matrix.getNumRows();
        int column = matrix.getNumColumns();
        Matrix resultMatrix = new Matrix(column, row);
        for (int i = 0; i < row; i++) {
            resultMatrix.setColumn(i, matrix.getRow(i));
        }
        return resultMatrix;
    }

    @Override
    public void fillMatrix() {
        if (data.length == this.rows && data[0].length == this.columns) {
            for (int i = 0; i < this.rows; ++i) {
                for (int j = 0; j < this.columns; ++j) {
                    this.data[i][j] = data[i][j];
                }
            }
        } else {
            throw new IllegalArgumentException("The provided values array doesn't match the matrix dimensions.");
        }
    }
}

    // Constructor for initializing the immutable matrix


