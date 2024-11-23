package sorter.project;

import java.util.Arrays;
import java.util.Scanner;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
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
                    Animal[] animals = {new Animal("Herbivore", true), new Animal("Pet", true), new Animal("Wild", false),
                            new Animal("Predator", true), new Animal("Any", true)};
                    Barrel[] barrels = {new Barrel(5.0f, "Wine", "Wooden"), new Barrel(2.0f, "Oil", "Plastic"),
                            new Barrel(1.5f, "Beer", "Metall")};
                    Sorter.sortAnyCustomClass(animals);
                    System.out.println(Arrays.toString(animals));
                    Sorter.sortAnyCustomClass(barrels);
                    System.out.println(Arrays.toString(barrels));
                    Animal an = animals[4];
                    System.out.println(Sorter.binarySearch(an, animals));
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
