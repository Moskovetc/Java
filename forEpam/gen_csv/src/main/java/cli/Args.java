package main.java.cli;

import java.util.regex.Pattern;

public class Args {
    private int col;
    private int row;
    private int len;
    private String out;

    private String tryGetCSVname(String value, String regExp) {
        String DEFAULT_OUT_FILE_NAME = "out.csv";
        try {
            if (Pattern.matches(regExp, value)) {
                return value;
            } else {
                throw new InvalidFileNameException(value, DEFAULT_OUT_FILE_NAME);
            }
        }catch (InvalidFileNameException e){
            return DEFAULT_OUT_FILE_NAME;
            }
    }

    public void parse(String[] args) throws MyInvalidArgumentException {
        String argument;
        int i = 0;
        while (i < args.length) {
            argument = args[i++];
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
                    out = tryGetCSVname(args[i++], "^([a-zA-Z0-9_\\.-]+).csv$");
                    break;
                }
                default: {
                    throw new MyInvalidArgumentException(argument);
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
