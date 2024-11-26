//package sorter.project.controller;
//
//import sorter.project.entity.WorkingCollection;
//import sorter.project.utils.InsertionSort;
//import sorter.project.utils.QuickSort;
//import sorter.project.utils.SortStrategy;
//import sorter.project.entity.Human;
//import sorter.project.entity.Animal;
//import sorter.project.entity.Barrel;
//
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class SortTheCollectionController {
//    public static void sortTheCollection() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Выберите действие:");
//        System.out.println("1. Быстрая сортировка");
//        System.out.println("2. Сортировка вставками");
//        System.out.println("3. На главную");
//        int choice = scanner.nextInt();
//
//        System.out.println("Выберите тип объектов для сортировки:");
//        System.out.println("1. Human");
//        System.out.println("2. Animal");
//        System.out.println("3. Barrel");
//        int typeChoice = scanner.nextInt();
//
//        Comparator<Object> comparator;
//        switch (typeChoice) {
//            case 1:
//                comparator = Comparator.comparingInt(o -> ((Human) o).getAge());
//                break;
//            case 2:
//                comparator = Comparator.comparing(o -> ((Animal) o).getType());
//                break;
//            case 3:
//                comparator = Comparator.comparingDouble(o -> ((Barrel) o).getVolume());
//                break;
//            default:
//                System.out.println("Неверный выбор!");
//                return;
//        }
//
//        SortStrategy<Object> sortStrategy;
//        switch (choice) {
//            case 1:
//                sortStrategy = new QuickSort<>();
//                break;
//            case 2:
//                sortStrategy = new InsertionSort<>();
//                break;
//            case 3:
//                return;
//            default:
//                System.out.println("Неверный выбор!");
//                return;
//        }
//
//        WorkingCollection.sortAndPrint(sortStrategy, comparator);
//    }
//}
//
package sorter.project.controller;

import sorter.project.entity.WorkingCollection;
import sorter.project.utils.InsertionSort;
import sorter.project.utils.QuickSort;
import sorter.project.utils.SortStrategy;
import sorter.project.entity.Human;
import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import java.util.Comparator;
import java.util.Scanner;

public class SortTheCollectionController {
    public static void sortAndSearchCollection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("1. Быстрая сортировка");
        System.out.println("2. Сортировка вставками");
        System.out.println("3. Бинарный поиск");
        System.out.println("4. На главную");
        int choice = scanner.nextInt();

        if (choice == 3) {
            System.out.println("Выберите тип объектов для бинарного поиска:");
            System.out.println("1. Human");
            System.out.println("2. Animal");
            System.out.println("3. Barrel");
            int typeChoice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            System.out.println("Введите значение для поиска:");
            String searchValue = scanner.nextLine();
            performBinarySearch(typeChoice, searchValue);
            return;
        }

        System.out.println("Выберите тип объектов для сортировки:");
        System.out.println("1. Human");
        System.out.println("2. Animal");
        System.out.println("3. Barrel");
        int typeChoice = scanner.nextInt();

        Comparator<Object> comparator;
        switch (typeChoice) {
            case 1:
                comparator = Comparator.comparingInt(o -> ((Human) o).getAge());
                break;
            case 2:
                comparator = Comparator.comparing(o -> ((Animal) o).getType());
                break;
            case 3:
                comparator = Comparator.comparingDouble(o -> ((Barrel) o).getVolume());
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        SortStrategy<Object> sortStrategy;
        switch (choice) {
            case 1:
                sortStrategy = new QuickSort<>();
                break;
            case 2:
                sortStrategy = new InsertionSort<>();
                break;
            case 4:
                return;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        WorkingCollection.sortAndPrint(sortStrategy, comparator);
    }

    private static void performBinarySearch(int typeChoice, String searchValue) {
        Comparator<Object> comparator;
        Object target = null;
        switch (typeChoice) {
            case 1:
                int age = Integer.parseInt(searchValue);
                target = new Human.HumanBuilder();
                comparator = Comparator.comparingInt(o -> ((Human) o).getAge());
                break;
            case 2:
                target = new Animal.AnimalBuilder().setType(searchValue).build();
                comparator = Comparator.comparing(o -> ((Animal) o).getType());
                break;
            case 3:
                double volume = Double.parseDouble(searchValue);
                target = new Barrel.BarrelBuilder();
                comparator = Comparator.comparingDouble(o -> ((Barrel) o).getVolume());
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        int index = WorkingCollection.binarySearch(target, comparator);
        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}
