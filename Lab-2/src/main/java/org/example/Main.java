package org.example;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

            Matrix matrix2 = new Matrix(3, 3);//mutable matrix
            double[][] b = new double[][]{
                    {-1.0, 2.0, 10.0},
                    {4.0, -5.0, 6.4},
                    {7.2, -8.0, 9.0}
            };
            matrix2.fillMatrix(b);
            System.out.println("Matrix 2:");
            matrix2.printMatrix();

    /*  BIG QUESTION      // Calling equals implicitly (e.g., in a collection)
            Set<Matrix> matrixSet = new HashSet<>();
            matrixSet.add(matrix1);
            matrixSet.add(matrix2);

            // Calling equals explicitly
            boolean areEqual = matrix1.equals(matrix2);
            System.out.println("Are matrix1 and matrix2 equal? " + areEqual); // Should print true

            // Calling hashCode explicitly
            int hashCode1 = matrix1.hashCode();
            int hashCode2 = matrix2.hashCode();
            System.out.println("Hash code of matrix1: " + hashCode1);
            System.out.println("Hash code of matrix2: " + hashCode2);

            // Hash codes should be the same for equal objects
*/

//            System.out.println("Transposed matrix:");
//            Matrix Tmatrix = Matrix.transposed(matrix1);
//            Tmatrix.printMatrix();
//
//            System.out.println("Vector matrix:");
//            Matrix VECmatrix = Matrix.VectorMatrix(matrix1,new double[]{3.0,10.0,121.0, -12.0});
//            VECmatrix.printMatrix();
//
//            System.out.println("Unit matrix:");
//            Matrix unitmatrix = Matrix.UnitMatrix(3,3);
//            unitmatrix.printMatrix();
//
//            Matrix matrixMult = Matrix.multiply(matrix1, matrix2);
//            if (matrixMult == null) {
//                return;
//            }
//            System.out.println("Multiply matrix:");
//            matrixMult.printMatrix();
//
//            Matrix matrixScal = Matrix.scalar(matrix1, -12.0);
//            System.out.println("matrix * scalar:");
//            matrixScal.printMatrix();
//
//            Matrix matrixAdd = Matrix.add(matrix1, matrix2);
//            if (matrixAdd == null) {
//                return;
//            }
//            System.out.println("Add matrix:");
//            matrixAdd.printMatrix();
//
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
//
//            //блок getter
//            double[] column = matrix1.getColumn(2);
//            System.out.println("Column: " + Arrays.toString(column));
//
//             double[] row = matrix1.getRow(1);
//            System.out.println("Row: " + Arrays.toString(row));
//
//            double elem = matrix1.getElement(1, 2);
//            System.out.println("Element: " + elem);
//
//            //блок setter
//            matrix1.setColumn(1, new double[]{1.0, 1.0, 1.0});
//            matrix1.printMatrix();//змінений стовпець
//
//            matrix1.setRow(2, new double[]{0.0,-2.0,3.4});
//            matrix1.printMatrix();//змінений рядок
//
//            matrix1.setElement(1,2,-10);
//            matrix1.printMatrix();//змінений елемент
//
//            System.out.printf("Rows: %d \nColumns: %d\n", matrix1.getNumRows(), matrix1.getNumColumns());//розмірність матриці

        }
    }
