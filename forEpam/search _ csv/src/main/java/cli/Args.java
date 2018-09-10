package main.java.cli;

import java.util.regex.Pattern;

public class Args {
    private String in;
    private String out;
    private String enc;
    private String col;
    private String exp;
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    private String tryGetCSVName(String value, String regExp) throws InvalidFileNameException {
        if (Pattern.matches(regExp, value)) {
            return value;
        } else {
            throw new InvalidFileNameException();
        }
    }

    public void parse() throws MyInvalidArgumentException, InvalidFileNameException {
        String argument;
        int i = 0;
        while (i < args.length) {
            argument = args[i++];
            if (Pattern.matches("^-[a-z]+", argument)) {
                switch (argument) {
                    case "-in": {
                        String fileName = args[i++];
                        try {
                            in = tryGetCSVName(fileName, "^([a-zA-Z0-9_\\.-]+).csv$");
                        } catch (InvalidFileNameException e) {
                            System.err.println(String.format("Неверное имя файла %s", fileName));
                            throw new InvalidFileNameException();
                        }
                        break;
                    }
                    case "-out": {
                        String fileName = args[i++];
                        String defaultFileName = "out.csv";
                        try {
                            out = tryGetCSVName(fileName, "^([a-zA-Z0-9_\\.-]+).csv$");
                        } catch (InvalidFileNameException e) {
                            System.err.println(String.format("Неверное имя файла %s", fileName));
                            System.err.println(String.format("Неверное значение ключа -out! " +
                                    "Имя файла по умолчанию : %s", defaultFileName));
                            out = defaultFileName;
                        }
                        break;
                    }
                    case "-enc": {
                        enc = tryGetEncoding(args[i++]);
                        break;
                    }
                    case "-col": {
                        col = args[i++];
                        break;
                    }
                    case "-exp": {
                        exp = args[i++];
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

    private String tryGetEncoding(String arg) {
        if ("UTF8".equals(arg)) {
            return arg;
        } else {
            System.err.println(String.format("Введена неверная кодировка -enc : %s ! Кодировка по умолчанию: UTF8", arg));
            return "UTF8";
        }
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getEnc() {
        return enc;
    }

    public String getCol() {
        return col;
    }

    public String getExp() {
        return exp;
    }
}
