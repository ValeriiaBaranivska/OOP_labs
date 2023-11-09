package org.example;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] data;

    public Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.data = new double[0][0];
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[this.rows][this.columns];
    }

    public Matrix(double[][] matrixData) {
        this.rows = matrixData.length;
        this.columns = matrixData[0].length;
        this.data = new double[this.rows][this.columns];

        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.columns; ++j) {
                this.data[i][j] = matrixData[i][j];
            }
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

    }
}