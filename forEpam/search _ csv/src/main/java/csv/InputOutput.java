package main.java.csv;

import java.io.*;

public class InputOutput {
    private final String in;
    private final String out;
    private final String enc;

    public InputOutput(String in, String out, String enc) {
        this.in = in;
        this.out = out;
        this.enc = enc;
    }

    public BufferedReader openInputFile() throws FileNotFoundException {
        BufferedReader inputFile = null;
        try {
            inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(in), enc));
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Файл %s не найден!", in));
            throw new FileNotFoundException();
        } catch (UnsupportedEncodingException e) {
            System.err.println(String.format("Неверная кодировка файла %s", enc));
            throw new UnsupportedOperationException();
        }
        return inputFile;
    }

    public BufferedWriter openOutputFile() throws FileNotFoundException {
        BufferedWriter outputFile = null;
        try {
            outputFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), enc));
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Файл %s не найден!", out));
            throw new FileNotFoundException();
        } catch (UnsupportedEncodingException e) {
            System.err.println(String.format("Неверная кодировка файла %s", enc));
            throw new UnsupportedOperationException();
        }
        return outputFile;
    }
}
