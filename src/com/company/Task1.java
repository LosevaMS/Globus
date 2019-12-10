package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        try {
            System.out.print("Enter first number ");
            Scanner in = new Scanner(System.in);
            float number1 = in.nextFloat();
            System.out.print("Enter second number ");
            float number2 = in.nextFloat();
            System.out.print("Enter operation:" + "\n" +
                    "1 - multiplication" + "\n" +      //*
                    "2 - division" + "\n" +            // /
                    "3 - addition" + "\n" +            //+
                    "4 - subtraction" + "\n");       //-
            int operation = in.nextInt();
            switch (operation) {
                case 1:
                    System.out.print(number1 + "*" + number2 + "=" + (number1 * number2));
                    break;
                case 2:
                    if (number2 == 0) {
                        System.out.println("Error");
                        break;
                    }
                    System.out.print(number1 + "/" + number2 + "=" + (number1 / number2));
                    break;
                case 3:
                    System.out.print(number1 + "+" + number2 + "=" + (number1 + number2));
                    break;
                case 4:
                    System.out.print(number1 + "-" + number2 + "=" + (number1 - number2));
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
