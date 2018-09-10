package main.java;

import main.java.cli.Args;
import main.java.cli.InvalidFileNameException;
import main.java.cli.MyInvalidArgumentException;
import main.java.csv.CSVSearch;
import main.java.csv.FileEmptyException;
import main.java.csv.InputOutput;

import java.io.IOException;

/**
 * Main method get args : -in -out -enc -col -exp
 * example: -in in.csv -out out.csv -enc UTF8 -col ujIY7wMB -exp 1913985098
 */
public class Main {
    public static void main(String[] args) {
        Args arguments = new Args(args);
        try {
            arguments.parse();
            InputOutput io = new InputOutput(arguments.getIn(), arguments.getOut(),
                    arguments.getEnc());
            CSVSearch csvSearch = new CSVSearch(io, arguments.getCol(), arguments.getExp());
            csvSearch.search();
        } catch (MyInvalidArgumentException e) {
            System.err.println("Необходимо использовать ключи -in -out -enc -col -exp");
        } catch (InvalidFileNameException e) {
            System.err.println("Программа будет закрыта!");
        } catch (IOException e) {
            System.err.println("Файл открыт в другой программе");
        } catch (FileEmptyException e) {
            System.out.println(String.format("Файл %s пуст!", arguments.getIn()));
        } catch (Exception e) {
            System.err.println("Программа завершилась с неизвестной ошибкой");
        }
    }


}

