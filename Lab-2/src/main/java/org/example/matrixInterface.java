package org.example;
public interface matrixInterface{
    int getNumColumns();

    void printMatrix();

    int[] dimension();

    int getNumRows();
    double[][] getData();

    // Getter для елементу
    double getElement(int row, int column);

    // Getter для рядка
    double[] getRow(int rowIndex);

    // Getter для стовпця
    double[] getColumn(int columnIndex);

    Matrix multiply(Matrix matrixA, Matrix matrixB);

    Matrix add(Matrix matrixB);

    Matrix transposed(Matrix matrix);

    boolean equals(Object obj);
    int hashCode();

    void fillMatrix(double[][] doubles);
    public void fillMatrix();

}