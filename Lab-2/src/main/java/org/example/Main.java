package org.example;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);
        double[][] customValues = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.fillMatrix(customValues);
        matrix.printMatrix();
    }
}