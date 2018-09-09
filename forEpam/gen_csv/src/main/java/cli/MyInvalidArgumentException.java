package main.java.cli;

public class MyInvalidArgumentException extends Throwable {
    public MyInvalidArgumentException(String argument) {
        System.err.println(String.format("Введен не правильный ключ %s", argument));
        System.err.println("Необходимо использовать ключи -col -row -len -out");
    }
}
