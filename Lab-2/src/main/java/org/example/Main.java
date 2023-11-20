package org.example;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
        public static void main (String[]args){

            System.out.println("Matrix random:");
            Matrix r = Matrix.RandomMatrix(3,4, 0.0,5.0);
            r.printMatrix();

            Matrix matrix1 = new Matrix(3,3);//mutable matrix
            matrix1.fillMatrix( new double[][]{
                    {15.0, 2.0, 3.0},
                    {4.0, 0.0, 6.0},
                    {-7.0, 8.0, 2.0}
            });
            System.out.println("Matrix 1:");
            matrix1.printMatrix();

            Immutable matrix2 = new Immutable(3,2,new double[][]{
                    {0.0, 2.0},
                    {4.0, -5.0},
                    {7.0, 3.0}
            });
            matrix2.fillMatrix();
            System.out.println("Matrix 2:");
            matrix2.printMatrix();

            Matrix copymatrix = new Matrix(matrix2);
            System.out.println("Copy Matrix:");
            copymatrix.printMatrix();

            System.out.println("Hashcode matrix1:"+ matrix1.hashCode());
            System.out.println("Hashcode matrix2:"+ r.hashCode());
            System.out.println("matrix1 and matrix2 equal: " + matrix1.equals(matrix2)); // Should print true

            matrix1 = matrix1.add(matrix1);
            System.out.println("Add matrix:");
            matrix1.printMatrix();

//            System.out.println("Inverse:");
//            Matrix Inmatrix = Matrix.invert(matrix2);
//            Inmatrix.printMatrix();

//            System.out.println("Transposed matrix:");
//            Matrix Tmatrix = Matrix.transposed(matrix1);
//            Tmatrix.printMatrix();

//            System.out.println("Vector matrix:");
//            Matrix VECmatrix = Matrix.VectorMatrix(matrix1,new double[]{3.0,10.0,121.0, -12.0});
//            VECmatrix.printMatrix();

//            System.out.println("Unit matrix:");
//            Matrix unitmatrix = Matrix.UnitMatrix(3,3);
//            unitmatrix.printMatrix();

//            Matrix matrixMult = Matrix.multiply(matrix1, matrix2);
//            System.out.println("Multiply matrix:");
//            matrixMult.printMatrix();

//            Matrix matrixScal = Matrix.scalar(matrix1, -12.0);
//            System.out.println("matrix * scalar:");
//            matrixScal.printMatrix();



//            Matrix copy = new Matrix(matrix1);
//            System.out.println("Matrix b:");
//            copy.printMatrix();

//            System.out.println("Matrix empty:");
//            Matrix empty = new Matrix(); //empty matrix
//            empty.printMatrix();



//            //блок getter
//            double[] column = matrix1.getColumn(2);
//            System.out.println("Column: " + Arrays.toString(column));

//             double[] row = matrix1.getRow(1);
//            System.out.println("Row: " + Arrays.toString(row));

//            double elem = matrix1.getElement(1, 2);
//            System.out.println("Element: " + elem);

//            //блок setter
//            matrix1.setColumn(1, new double[]{1.0, 1.0, 1.0});
//            matrix1.printMatrix();//змінений стовпець

//            matrix1.setRow(2, new double[]{0.0,-2.0,3.4});
//            matrix1.printMatrix();//змінений рядок

//            matrix1.setElement(1,2,-10);
//            matrix1.printMatrix();//змінений елемент


        }
    }
