package main.java;

import main.java.cli.Args;
import main.java.cli.MyInvalidArgumentException;
import main.java.csv.FileCSV;

/**
 * Main method get args : -len int -out String -col int -row int
 * example: -len 10 -out out.csv -col 5 -row 5
 */
public class Main {
    public static void main(String[] args) {
        Args arguments = new Args();
        try {
            arguments.parse(args);
            FileCSV fileCSV = new FileCSV();
            fileCSV.setNumberOfColumn(arguments.getCol());
            fileCSV.setNumberOfRows(arguments.getRow());
            fileCSV.setMaxLen(arguments.getLen());
            fileCSV.setNameOutputFile(arguments.getOut());
            fileCSV.generateCSVFile();
        } catch (MyInvalidArgumentException e) {
            System.err.println("Необходимо использовать ключи -col -row -len -out");
        } catch (NumberFormatException e) {
            System.err.println("Значение ключа -col -row -len должно быть целочисленным и не пустым");
        } catch (Exception e) {
            System.err.println("Программа завершилась с неизвестной ошибкой");
        }
    }
}
