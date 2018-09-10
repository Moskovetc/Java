package main.java.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CSVSearch {
    private final InputOutput io;
    private final String col;
    private final String exp;

    public CSVSearch(InputOutput io, String col, String exp) {
        this.io = io;
        this.col = col;
        this.exp = exp;
    }

    /**
     * Search column
     *
     * @param columns
     * @return object of Class Column with fields column number and column type
     */
    private Column searchColumn(String[] columns) {
        Column column = new Column();
        int columnNumber = 0;
        String columnType = null;
        for (int i = 0; i < columns.length; i++) {
            String[] nameAndType = columns[i].split(" ");
            if (nameAndType[0].equals(col)) {
                columnNumber = i;
                columnType = nameAndType[1];
            }
        }
        column.setColumnNumber(columnNumber);
        column.setColumnType(columnType);
        return column;
    }

    /**
     * Search data in column by expression with type validation
     *
     * @param inputFile  read file
     * @param outputFile write file
     * @throws NumberFormatException if type invalid
     * @throws IOException           if file busy
     * @throws FileEmptyException    if file empty
     */
    private void searchValue(BufferedReader inputFile, BufferedWriter outputFile) throws NumberFormatException, IOException, FileEmptyException {
        String line = inputFile.readLine();
        if (null != line) {
            String[] columns = line.split(";");
            Column column = searchColumn(columns);
            outputFile.write(columns[column.getColumnNumber()] + ";\n");
            line = inputFile.readLine();
            try {
                while (line != null) {
                    columns = line.split(";");
                    switch (column.getColumnType()) {
                        case "Float": {
                            if (Float.valueOf(exp).equals(Float.valueOf(columns[column.getColumnNumber()]))) {
                                outputFile.write(columns[column.getColumnNumber()] + ";\n");
                            }
                            break;
                        }
                        case "Integer": {
                            if (Integer.valueOf(exp).equals(Integer.valueOf(columns[column.getColumnNumber()]))) {
                                outputFile.write(columns[column.getColumnNumber()] + ";\n");
                            }
                            break;
                        }
                        case "Date": {
                            if (exp.equals(columns[column.getColumnNumber()])) {
                                outputFile.write(columns[column.getColumnNumber()] + ";\n");
                            }
                            break;
                        }
                        case "String": {
                            if (exp.equals(columns[column.getColumnNumber()])) {
                                outputFile.write(columns[column.getColumnNumber()] + ";\n");
                            }
                            break;
                        }
                    }
                    line = inputFile.readLine();
                }
            } catch (NumberFormatException e) {
                System.err.println(String.format("Неверный тип выражения %s, тип столбца %s", exp, column.getColumnType()));
                throw new NumberFormatException();
            }
        } else {
            throw new FileEmptyException();
        }
    }

    public void search() throws NumberFormatException, IOException, FileEmptyException {
        try (BufferedReader inputFile = io.openInputFile(); BufferedWriter outputFile = io.openOutputFile()) {
            searchValue(inputFile, outputFile);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }

    }

}
