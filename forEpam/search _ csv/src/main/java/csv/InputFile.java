package main.java.csv;

import java.io.*;

public class InputFile {
    private String fileName;
    private String enc;
    private BufferedReader fileReader;

    public InputFile(String fileName, String enc) {
        this.fileName = fileName;
        this.enc = enc;
    }

    public void openFile () {
        try {
            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), enc));
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Файл %s не найден!", fileName));
            System.exit(1);
        }catch (UnsupportedEncodingException e) {
            System.err.println(String.format("Неверная кодировка файла %s", enc));
            System.exit(1);
        }
    }

    public String read() {
        try {
            return fileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close(){
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
