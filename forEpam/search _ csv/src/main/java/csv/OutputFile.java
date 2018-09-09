package main.java.csv;

import java.io.*;

public class OutputFile {
    private String enc;
    private String fileName;
    private BufferedWriter fileWriter;

    public OutputFile(String fileName, String enc) {
        this.enc = enc;
        this.fileName = fileName;
    }

    public void openFile() {
        try {
            fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), enc));
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Файл %s не найден!", fileName));
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            System.err.println(String.format("Неверная кодировка файла %s", enc));
            System.exit(1);
        }
    }

    public void write(String string) {
        try {
            fileWriter.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
