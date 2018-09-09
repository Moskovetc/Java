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
            throw new InvalidFileNameException(value);
        }
    }


    public void parse() throws MyInvalidArgumentException {
        String argument;
        int i = 0;
        while (i < args.length) {
            argument = args[i++];
            switch (argument) {
                case "-in": {
                    try {
                        in = tryGetCSVName(args[i++], "^([a-zA-Z0-9_\\.-]+).csv$");
                    } catch (InvalidFileNameException e){
                        System.exit(1);
                    }
                    break;
                }
                case "-out": {
                    try {
                        out = tryGetCSVName(args[i++], "^([a-zA-Z0-9_\\.-]+).csv$");
                    }catch (InvalidFileNameException e){
                        System.err.println("Неверное значение ключа -out! Имя файла по умолчанию : out.csv");
                        out = "out.csv";
                    }
                    break;
                }
                case "-enc": {
                    enc = tryGetEncoding(args[i++]);
                    break;
                }
                case "-col": {
                    col = argument;
                    break;
                }
                case "-exp": {
                    exp = argument;
                }
                default: {
                    throw new MyInvalidArgumentException(argument);
                }
            }
        }
    }

    private String tryGetEncoding(String arg) {
        switch (arg){
            case "UTF8" : {return arg;}
            default: {
                System.err.println(String.format("Введена неверная кодировка -enc : %s ! Кодировка по умолчанию: UTF8", arg));
                return "UTF8";
            }
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
