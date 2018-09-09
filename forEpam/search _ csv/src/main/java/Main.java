package main.java;

import main.java.cli.Args;
import main.java.cli.MyInvalidArgumentException;
import main.java.csv.CSVSearch;

public class Main {
    public static void main(String[] args) {
        CSVSearch csvSearch = new CSVSearch();
        Args arguments = new Args(args);
        try {
            arguments.parse();
            csvSearch.setIn(arguments.getIn());
            csvSearch.setOut(arguments.getOut());
            csvSearch.setEnc(arguments.getEnc());
            csvSearch.setCol(arguments.getCol());
            csvSearch.setExp(arguments.getExp());
            csvSearch.search();
        } catch (MyInvalidArgumentException e) {
            System.exit(1);
        }
    }


}

