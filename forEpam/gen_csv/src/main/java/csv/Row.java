package main.java.csv;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class Row {
    private LinkedList <Column> columns;
    private int numberOfColumns;
    private int maxLen;

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public void setMaxlen(int maxlen) {
        this.maxLen = maxlen;
    }

    private String generateRndString(int maxLen){
        char[] symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        int len = random.nextInt(maxLen)+1;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < len){
            int rndNum = random.nextInt(symbols.length);
            stringBuilder.append(symbols[rndNum]);
            i++;
        }
        return stringBuilder.toString();
    }

    private String generateRndDate(){
        Random random = new Random();
        Date date = new Date(random.nextLong());
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    private int generateRndInteger(){
        Random random = new Random();
        return random.nextInt();
    }

    private float generateRndFloat() {
        Random random = new Random();
        return random.nextFloat();
    }

    private Column generateRndColumn(int maxLen){
        String[] types = {"String", "Date", "Integer", "Float"};
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0: {
                return new Column(generateRndString(maxLen), types[0]);
            }
            case 1 : {
                return new Column(generateRndString(maxLen), types[1]);
            }
            case 2 : {
                return new Column(generateRndString(maxLen), types[2]);
            }
            case 3 : {
                return new Column(generateRndString(maxLen), types[3]);
            }
        }
        return null;
    }

    private void generateRndColumnsLinkedList(int numberOfColumn, int maxLen){
        int i = 0;
        LinkedList<Column> columns = new LinkedList<>();
        while (i < numberOfColumn){
            columns.add(generateRndColumn(maxLen));
            i++;
        }
        this.columns = columns;

    }

    public String generateRndColumnsRow(){
        generateRndColumnsLinkedList(numberOfColumns, maxLen);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfColumns; i++) {
            stringBuilder.append(columns.get(i).toString()).append(";");
        }
        return stringBuilder.toString();
    }

    public String generateRndRow() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfColumns; i++){
            Column column = columns.get(i);
            switch (column.getTypeName()){
                case "String" : {stringBuilder.append(generateRndString(maxLen));break;}
                case "Date" : {stringBuilder.append(generateRndDate());break;}
                case "Integer" : {stringBuilder.append(generateRndInteger());break;}
                case "Float" : {stringBuilder.append(generateRndFloat());break;}
            }
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }
}
