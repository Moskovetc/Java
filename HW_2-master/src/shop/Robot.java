package shop;

import java.util.Scanner;

public class Robot extends Toy {
    private String weapon;
    private boolean movable;

    public String getWeapon() {
        return weapon;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setMovable() {
        System.out.println("Игрушка подвижная? [yes/no]");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("YES") ||
                     choice.equals("Y")) {
                this.movable = true;
                break;
            }
            if (choice.equals("NO") ||
                    choice.equals("N")) {
                this.movable = false;
                break;
            } else {
                System.out.println("YES or NO ?");
            }
        }
    }

    @Override
    public String toString() {
        return "Toy " + getName() + ":\n" +
                "Weapon : " + getWeapon() + "\nisMovable : " +
                isMovable() + "\nPrice: " + getPrice();
    }
}
