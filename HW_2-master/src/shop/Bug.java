package shop;

import java.util.Scanner;

public class Bug extends Toy {
    private boolean nasty;
    private int numberOfLegs;

    public boolean isNasty() {
        return nasty;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNasty() {
        System.out.println("Жук мерзкий? [yes/no]");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("YES") ||
                    choice.equals("Y")) {
                this.nasty = true;
                break;
            }
            if (choice.equals("NO") ||
                    choice.equals("N")) {
                this.nasty = false;
                break;
            } else {
                System.out.println("YES or NO ?");
            }
        }
    }

    public void setNumberOfLegs() {
        while (true) {
            System.out.println("Введите количество ног у жука:");
            Scanner scanner = new Scanner(System.in);
            try {
                this.numberOfLegs = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Введен неправильный формат");
            }
        }
    }

    @Override
    public String toString() {
        return "Toy " + getName() + ":\n" +
                "Nasty : " + isNasty() + "\nNumber of Legs : " +
                getNumberOfLegs() + "\nPrice: " + getPrice();
    }
}
