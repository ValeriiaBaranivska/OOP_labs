package org.example;
import java.util.Arrays;
public class Main {
        public static void main (String[]args){
            Matrix matrix1 = new Matrix(3, 3);//mutable matrix
            double[][] a = new double[][]{
                    {1.0, 2.0, 3.0},
                    {4.0, 5.0, 6.0},
                    {7.0, 8.0, 9.0}
            };
            matrix1.fillMatrix(a);
            System.out.println("Matrix 1:");
            matrix1.printMatrix();

//            Matrix copy = new Matrix(matrix1);
//            System.out.println("Matrix b:");
//            copy.printMatrix();
//
//            System.out.println("Matrix empty:");
//            Matrix empty = new Matrix(); //empty matrix
//            empty.printMatrix();
//
//            System.out.println("Matrix random:");
//            Matrix r = new Matrix(3, 3);//random matrix
//            r.RandomMatrix();
//            r.printMatrix();

//            //блок getter
//            double[] column = matrix1.getColumn(2);
//            System.out.println("Column: " + Arrays.toString(column));
//
//             double[] row = matrix1.getRow(1);
//            System.out.println("Row: " + Arrays.toString(row));
//
//            double elem = matrix1.getElement(1, 2);
//            System.out.println("Element: " + elem);

            //блок setter
//            matrix1.setColumn(1, new double[]{1.0, 1.0, 1.0});
//            matrix1.printMatrix();//змінений стовпець
//
//            matrix1.setRow(2, new double[]{0.0,-2.0,3.4});
//            matrix1.printMatrix();//змінений рядок
//
//            matrix1.setElement(1,2,-10);
//            matrix1.printMatrix();//змінений елемент

//            System.out.printf("Rows: %d \nColumns: %d\n", matrix1.getNumRows(), matrix1.getNumColumns());//розмірність матриці

        }
    }
