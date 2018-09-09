package main.java.csv;

import main.java.cli.Args;
import main.java.cli.MyInvalidArgumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    private void createOutputFile(){
        this.file = new File(nameOutputFile);
        try {
            while (true) {
                if (!file.exists()) {
                    file.createNewFile();
                    break;
                } else {
                    System.err.println("Файл : " + nameOutputFile + " существует!");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Перезаписать файл? [yes/no] : ");
                    String choice = scanner.nextLine().toUpperCase();
                    if (choice.equals("YES") || choice.equals("Y")) {
                        break;
                    } else if (choice.equals("NO") || choice.equals("N")) {
                        scanner = new Scanner(System.in);
                        System.out.println("Введите новое имя файла : ");
                        Args args = new Args();
                        String[] newOut = {"-out", scanner.nextLine()};
                        try {
                            args.parse(newOut);
                        }catch (MyInvalidArgumentException e){}
                        file = new File(args.getOut());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateCSVFile() {
        Row row = new Row();
        PrintWriter out = null;
        row.setMaxlen(maxLen);
        row.setNumberOfColumns(numberOfColumn);
        createOutputFile();
        try {
            out = new PrintWriter(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Файл с именем %s не найден!", nameOutputFile));
            e.printStackTrace();
        }
        out.println(row.generateRndColumnsRow());
        for (int i = 0; i < numberOfRows; i++){
            out.println(row.generateRndRow());
        }
        out.close();
    }
}

