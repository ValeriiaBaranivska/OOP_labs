package org.example;
import java.util.Arrays;

public class Immutable {
    public final class ImmutableMatrix {
        private final int rows;
        private final int columns;
        private final double[][] data;

        // Constructor for initializing the immutable matrix
        public ImmutableMatrix(double[][] matrixData) {
            this.rows = matrixData.length;
            this.columns = matrixData[0].length;
            this.data = new double[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.data[i][j] = matrixData[i][j];
                }
            }
        }
        public int getNumRows() {
            return rows;
        }
        public int getNumColumns() {
            return columns;
        }
        private double[][] getData() {
            return data;
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
    }

}
