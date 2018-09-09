package main.java.cli;

public class InvalidFileNameException extends Throwable {

    public InvalidFileNameException(String fileName, String defaulFileName) {

        System.err.println("Неверное имя файла: " + fileName);
        System.err.println("Имя файла по умолчанию: " + defaulFileName);
    }
}
