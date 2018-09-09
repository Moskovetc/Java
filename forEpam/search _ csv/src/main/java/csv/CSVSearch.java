package main.java.csv;

public class CSVSearch {
    private String in;
    private String out;
    private String enc;
    private String col;
    private String exp;

    public void setIn(String in) {
        this.in = in;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public void setEnc(String enc) {
        this.enc = enc;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void search(){

        InputFile inputFile = new InputFile(in, enc);
        OutputFile outputFile = new OutputFile(out, enc);
        inputFile.openFile();
        outputFile.openFile();
        String line = inputFile.read();
        if (null != line) {
            String[] columns = line.split(";");
            int columnNumber = 0;
            String columnType = null;
            for (int i = 0; i < columns.length; i++) {
                String[] nameAndType = columns[i].split(" ");
                if (nameAndType[0].equals(col)) {
                    columnNumber = i;
                    columnType = nameAndType[1];
                }
            }
            outputFile.write(columns[columnNumber] + ";\n");
            line = inputFile.read();
            while (line != null){
                columns = line.split(";");
                switch (columnType){
                    case "Float" : {
                        try {
                            if (Float.valueOf(exp).equals(Float.valueOf(columns[columnNumber]))){
                                outputFile.write(columns[columnNumber]+ ";\n");
                            }
                        }catch (NumberFormatException e){
                            System.err.println(String.format("Неверный тип выражения %s, тип столбца %s", exp, columnType));
                            System.exit(1);
                        }
                        break;
                    }
                    case "Integer" :{
                        try {
                            if (Integer.valueOf(exp).equals(Integer.valueOf(columns[columnNumber]))){
                                outputFile.write(columns[columnNumber]+ ";\n");
                            }
                        }catch (NumberFormatException e){
                            System.err.println(String.format("Неверный тип выражения %s, тип столбца %s", exp, columnType));
                            System.exit(1);
                        }
                        break;
                    }
                    case "Date" :{
                        try {
                            if (exp.equals(columns[columnNumber])){
                                outputFile.write(columns[columnNumber]+ ";\n");
                            }
                        }catch (NumberFormatException e){
                            System.err.println(String.format("Неверный тип выражения %s, тип столбца %s", exp, columnType));
                            System.exit(1);
                        }
                        break;
                    }
                    case "String" : {
                        if (exp.equals(columns[columnNumber])){
                            outputFile.write(columns[columnNumber]+ ";\n");
                        }
                        break;
                    }
                }
                line = inputFile.read();
            }
        }else {
            System.out.println(String.format("Файл %s пуст!", in));
        }
        inputFile.close();
        outputFile.close();
    }

}
