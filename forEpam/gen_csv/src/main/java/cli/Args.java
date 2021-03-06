package main.java.cli;

import java.util.regex.Pattern;

public class Args {
    private int col;
    private int row;
    private int len;
    private String out;

    /**
     * @param value  filename typed by user
     * @param regExp pattern for validation
     * @return String if CSV filename is valid
     * @throws InvalidFileNameException if CSV filename typed by user is invalid
     */
    private String tryGetCSVname(String value, String regExp) throws InvalidFileNameException {
        if (Pattern.matches(regExp, value)) {
            return value;
        } else {
            throw new InvalidFileNameException();
        }

    }

    /**
     * @param args cli arguments
     * @throws MyInvalidArgumentException if argument is not expected
     * Method parsing cli arguments and setting valid values of class fields col, row ,len, out
     */
    public void parse(String[] args) throws MyInvalidArgumentException {
        String argument;
        int i = 0;
        while (i < args.length) {
            argument = args[i++];
            if (Pattern.matches("^-[a-z]+", argument)) {
                switch (argument) {
                    case "-col": {
                        col = Integer.valueOf(args[i++]);
                        break;
                    }
                    case "-row": {
                        row = Integer.valueOf(args[i++]);
                        break;
                    }
                    case "-len": {
                        len = Integer.valueOf(args[i++]);
                        break;
                    }
                    case "-out": {
                        String defaulFileName = "out.csv";
                        String fileName = args[i++];
                        try {
                            out = tryGetCSVname(fileName, "^([a-zA-Z0-9_\\.-]+).csv$");
                        } catch (InvalidFileNameException e) {
                            System.err.println("Неверное имя файла: " + fileName);
                            System.err.println("Имя файла по умолчанию: " + defaulFileName);
                            out = defaulFileName;
                        }
                        break;
                    }
                    default: {
                        System.err.println(String.format("Введен не правильный ключ %s", argument));
                        throw new MyInvalidArgumentException();
                    }
                }
            }
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getLen() {
        return len;
    }

    public String getOut() {
        return out;
    }
}
