package calc;

import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {

    public void run(){
        String choice = "";
        while (!choice.equals("3")) {
            System.out.println("Выберите режим работы калькулятора :\n" + "1. Построчный\n" + "2. Посимвольный\n" + "3. Выход");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    gag();
//                    startMode1();
                    break;
                }
                case "2": {
                    startMode2();
                    break;
                }
                case "3": {
                    break;
                }
            }
        }
    }

    private  void gag(){
        System.out.println("режим временно недоступен :(");
    }

    private void startMode1() {
        LinkedList<String> inputArgs = new LinkedList<>();
        String input;
        String number = "";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        int length = input.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < length; i++){
            if (input.charAt(i) == '+' || input.charAt(i) == '-' ||
                    input.charAt(i) == '*' || input.charAt(i) == '/'){
                stringBuilder = new StringBuilder();
                inputArgs.add(number);
                inputArgs.add(String.valueOf(input.charAt(i)));
                continue;
            }
            number = stringBuilder.append(input.charAt(i)).toString();
        }
        int i = 1;
        String item = inputArgs.get(0);
        double result = checkNumber(item, 0);
        while (i < inputArgs.size()){
            item = inputArgs.get(i);
            switch (item){
                case "+" : {
                    result += checkNumber(inputArgs.get(i+1), 0);
                    break;
                }
                case "-" : {
                    result -= checkNumber(inputArgs.get(i+1), 0);
                    break;
                }
                case "*" : {
                    result += checkNumber(inputArgs.get(i+1), 1);
                    break;
                }
                case "/" : {
                    result -= checkNumber(inputArgs.get(i+1), 1);
                    break;
                }
                default:{
                    break;
                }
            }
            i++;
        }
        System.out.println("\nresult = " + result);
    }

    private double checkNumber(String line, int defaultNumber){
        double number = 0;
        if (defaultNumber == 1){
            number = 1;
        }
            try {
                number = Double.valueOf(line);
            } catch (Exception e) {
                if (!line.toUpperCase().equals("QUIT")) {
                    System.out.println("Введен не правильный тип" + line + "\n");
                }
            }
        return number;
    }

    private void startMode2() {
        String input = "";
        double result;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Используйте QUIT для возврата в главное меню\nВведите первое число: ");
        result = checkNumber(scanner.nextLine(), 0);
        while (!input.toUpperCase().equals("QUIT")) {
            scanner = new Scanner(System.in);
            System.out.print("\nВведите арифметическую операцию : ");
            input = scanner.nextLine();
            switch (input){
                case "+": {
                    System.out.print("\nвведите следующее число : ");
                    result += checkNumber(scanner.nextLine(), 0);
                    break;
                }
                case "-": {
                    System.out.print("\nвведите следующее число : ");
                    result -= checkNumber(scanner.nextLine(), 0);
                    break;
                }
                case "*":{
                    System.out.print("\nвведите следующее число : ");
                    result = result * checkNumber(scanner.nextLine(), 1);
                    break;
                }
                case "/":{
                    if (0 != result){
                        System.out.print("\nвведите следующее число : ");
                        result = result / checkNumber(scanner.nextLine(), 1);
                    } else {
                        System.err.println("делить на ноль нельзя!");
                    }

                    break;
                }
                default:{
                    if (!input.toUpperCase().equals("QUIT")){
                        System.out.println("Введено неверное значение!");
                    }
                    break;
                }
            }
            System.out.println("\nresult = " + result);


        }
    }




}
