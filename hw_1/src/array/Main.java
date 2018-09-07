package array;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        StringBuilder s = new StringBuilder();
        double array[][] = Array.startCreateArray();
//        double array[][] = Array.createArray(20,20);
        Array.printArray(array);
        System.out.println(s.append("Сумма элементов массива =")
                .append(Array.sumElemets(array)).toString());
        s = new StringBuilder();
        ArrayList minSumRowAvg = Array.minSumInRowList(array);
        System.out.println(s.append("Минимальная сумма чисел = ").append(minSumRowAvg.get(1))
                .append(", в строке ").append(minSumRowAvg.get(0))
                .append("\nСреднее значение = ").append(minSumRowAvg.get(2)).toString());
    }

}
