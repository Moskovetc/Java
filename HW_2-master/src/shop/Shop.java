package shop;

import java.util.LinkedList;
import java.util.Scanner;

public class Shop {
    private LinkedList <Toy> toys = new LinkedList<>();

    public void putToy(){
        Scanner scanner = new Scanner(System.in);
        String quit = "";
        while (quit != "QUIT" ){
            System.out.println("Используйте quit для окончания добавления игрушек\n" +
                    "Выберите какую игрушку добавить\n" +
                    "(Cat, Dog, Robot, Bug, Car):");
            String choice = scanner.nextLine();
            switch (choice.toUpperCase()){
                case "CAT":
                    Cat cat = new Cat();
                    System.out.println("Введите название игрушки:");
                    cat.setName(scanner.nextLine());
                    System.out.println("Введите цвет игрушки:");
                    cat.setColor(scanner.nextLine());
                    System.out.println("Введите цвет шерсти игрушки:");
                    cat.setColorFur(scanner.nextLine());
                    cat.setPrice();
                    this.toys.add(cat);
                    break;
                case "DOG":
                    Dog dog = new Dog();
                    System.out.println("Введите название игрушки:");
                    dog.setName(scanner.nextLine());
                    System.out.println("Введите материал игрушки:");
                    dog.setMaterial(scanner.nextLine());
                    dog.setSpeech();
                    dog.setPrice();
                    this.toys.add(dog);
                    break;
                case "ROBOT":
                    Robot robot = new Robot();
                    System.out.println("Введите название игрушки:");
                    robot.setName(scanner.nextLine());
                    System.out.println("Введите оружие для игрушки:");
                    robot.setWeapon(scanner.nextLine());
                    robot.setMovable();
                    robot.setPrice();
                    this.toys.add(robot);
                    break;
                case "BUG":
                    Bug bug = new Bug();
                    System.out.println("Введите название игрушки:");
                    bug.setName(scanner.nextLine());
                    bug.setNasty();
                    bug.setNumberOfLegs();
                    bug.setPrice();
                    this.toys.add(bug);
                    break;
                case "CAR":
                    Car car = new Car();
                    System.out.println("Введите название игрушки:");
                    car.setName(scanner.nextLine());
                    System.out.println("Модель игрушки?");
                    car.setModelName(scanner.nextLine());
                    car.setNumberOfWheels();
                    car.setPrice();
                    this.toys.add(car);
                    break;
                case "QUIT":
                    quit = "QUIT";
                    break;
                default:
                    continue;
            }
        }
    }

    public void showToys() {
        int i = 1;
        for (Toy toy: this.toys){
            System.out.println("Игрушка №" + i + " :");
            System.out.println(toy.toString() + "\n");
            i++;
        }

    }
}
