package shop;

import java.util.Scanner;

public class Car extends Toy {
    private String modelName;
    private int numberOfWheels;

    public String getModelName() {
        return modelName;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setNumberOfWheels() {
        while (true) {
            System.out.println("Введите количество колес:");
            Scanner scanner = new Scanner(System.in);
            try {
                this.numberOfWheels = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Введен неправильный формат");
            }
        }
    }

    @Override
    public String toString() {
        return "Toy " + getName() + ":\n" +
                "Model : " + getModelName() + "\nNumber of Wheels : " +
                getNumberOfWheels() + "\nPrice: " + getPrice();
    }
}
