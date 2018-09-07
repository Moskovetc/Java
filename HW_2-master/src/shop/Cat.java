package shop;

public class Cat extends Toy {
    private String color;
    private String colorFur;

    public String getColorFur() {
        return colorFur;
    }

    public void setColorFur(String colorFur) {
        this.colorFur = colorFur;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        String summary = "Toy " + getName() + ":\n" +
                "Color : " + getColor() + "\nColorFur : " +
                getColorFur() + "\nPrice: " + getPrice();
        return summary;
    }

}
