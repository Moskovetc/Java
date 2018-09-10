package main.java.csv;

import main.java.cli.Args;
import main.java.cli.MyInvalidArgumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCSV {

    private int numberOfColumn;
    private int numberOfRows;
    private int maxLen;
    private String nameOutputFile;
    private File file;

    public void setNumberOfColumn(int numberOfColumn) {
        this.numberOfColumn = numberOfColumn;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void setMaxLen(int maxLen) {
        this.maxLen = maxLen;
    }

    public void setNameOutputFile(String nameOutputFile) {
        this.nameOutputFile = nameOutputFile;
    }

    private void createOutputFile() throws MyInvalidArgumentException {
        this.file = new File(nameOutputFile);
        String choice = "";
        while (!"YES".equals(choice) && !"Y".equals(choice)) {
            System.err.println("Файл : " + nameOutputFile + " существует!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Перезаписать файл? [yes/no] : ");
            choice = scanner.nextLine().toUpperCase();
            if (choice.equals("NO") || choice.equals("N")) {
                scanner = new Scanner(System.in);
                System.out.println("Введите новое имя файла : ");
                Args args = new Args();
                String[] newOut = {"-out", scanner.nextLine()};
                args.parse(newOut);
                file = new File(args.getOut());
                break;
            }
        }
    }

    public void generateCSVFile() throws MyInvalidArgumentException {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        createOutputFile();
        try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
            out.println(randomDataGenerator.generateRndColumnsRow(numberOfColumn, maxLen));
            for (int i = 0; i < numberOfRows; i++) {
                out.println(randomDataGenerator.generateRndDataRow(numberOfColumn, maxLen));
            }
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Файл с именем %s не найден!", nameOutputFile));
        }
    }
}

