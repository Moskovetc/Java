package main.java.csv;

public class Column {
    private String columnName;
    private String typeName;

    public Column(String columnName, String typeName) {
        this.columnName = columnName;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return columnName + " " + typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
