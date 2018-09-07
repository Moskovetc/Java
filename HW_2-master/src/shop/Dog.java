package shop;

import java.util.Scanner;

public class Dog extends Toy {
    private String material;
    private boolean speech;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isSpeech() {
        return speech;
    }

    public void setSpeech() {
        System.out.println("Игрушка разговаривает? [yes/no]");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("YES") ||
                    choice.equals("Y")) {
                speech = true;
                break;
            }
            if (choice.equals("NO") ||
                    choice.equals("N")) {
                speech = false;
                break;
            } else {
                System.out.println("YES or NO ?");
            }
        }
    }

    @Override
    public String toString() {
        return "Toy " + getName() + ":\n" +
                "Material : " + getMaterial() + "\nisSpeech : " +
                isSpeech() + "\nPrice: " + getPrice();
    }
}
