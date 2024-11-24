package sorter.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.utils.Sorter;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнить массив");
            System.out.println("2. Сортировать массив");
            System.out.println("3. Найти элемент");
            System.out.println("4. Записать в файл");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(23);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }


    }
}
