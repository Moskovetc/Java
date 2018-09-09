package main.java;

import main.java.cli.Args;
import main.java.cli.MyInvalidArgumentException;
import main.java.csv.FileCSV;

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
        }catch (MyInvalidArgumentException e){
            System.exit(1);
        } catch (NumberFormatException e){
            System.err.println("Значение ключа -col -row -len должно быть целочисленным и не пустым");
        }
    }
}
