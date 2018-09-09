package main.java.cli;

public class InvalidFileNameException extends Throwable {
    public InvalidFileNameException(String value) {
        System.err.println(String.format("Неверное имя файла %s", value));
    }
}
