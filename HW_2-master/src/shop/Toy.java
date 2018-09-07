package shop;

import java.util.Scanner;

public abstract class Toy {
    private float price;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        while (true) {
            System.out.println("Введите цену:");
            Scanner scanner = new Scanner(System.in);
            try {
                this.price = scanner.nextFloat();
                break;
            } catch (Exception e) {
                System.out.println("Введена неправильная цена, " +
                        "введи цену формата double");
            }
        }
    }

}
