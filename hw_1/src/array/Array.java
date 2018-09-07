package array;

import java.util.ArrayList;
import java.util.Random;

public class Array {

    public static double[][] startCreateArray(){
        double[][] array = createArray(20,20);
        return array;
    }

    private static double[][] createArray(int row, int column){
        double[][] array = new double[row][column];
        Random random = new Random();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                array[i][j] = Math.round((random.nextDouble()*90)*100d) / 100d;
            }
        }
        return array;
    }

    public static void printArray(double array[][]){
        int row = array.length;
        int column = array[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.format("%7.2f",array[i][j]);
            }
            System.out.println();
        }
    }

    public static double sumElemets(double array[][]){
        int row = array.length;
        int column = array[0].length;
        double sum = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static ArrayList minSumInRowList(double array[][]){
        int row = array.length;
        int column = array[0].length;
        double sum = 0;
        ArrayList minSumRowAv = new ArrayList();
        minSumRowAv.add(0, 0);
        minSumRowAv.add(1, Double.MAX_VALUE);
        minSumRowAv.add(2, (double)0);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                sum += array[i][j];
            }
            if ((double)minSumRowAv.get(1) > sum){
                minSumRowAv.set(1, sum);
                minSumRowAv.set(0, i+1);
                minSumRowAv.set(2, sum/column);
                sum = 0;
            }
        }
        return minSumRowAv;
    }
}
