//package sorter.project.controller;
//
//import sorter.project.entity.WorkingCollection;
//import sorter.project.utils.InsertionSort;
//import sorter.project.utils.QuickSort;
//import sorter.project.utils.SortStrategy;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//
//public class SortTheCollectionController {
//
//    public static void sortTheCollection() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Выберите действие:");
//        System.out.println("1. Быстрая сортировка");
//        System.out.println("2. Сортировка вставками");
//        System.out.println("3. На главную");
//        int choice = scanner.nextInt();
//
//        List items = WorkingCollection.addedCollection();
//        SortStrategy<WorkingCollection> sortStrategy;
//
//        switch (choice) {
//            case 1:
//                sortStrategy = new QuickSort<>();
//                sortStrategy.sort(items, Comparator.comparingInt(WorkingCollection::getValue));
//                System.out.println("Отсортированный список с использованием быстрой сортировки:");
//                break;
//            case 2:
//                sortStrategy = new InsertionSort<>();
//                sortStrategy.sort(items, Comparator.comparingInt(WorkingCollection::getValue));
//                System.out.println("Отсортированный список с использованием сортировки вставками:");
//                break;
//            case 3:
//                return;
//            default:
//                System.out.println("Неверный выбор!");
//                return;
//        }
//
//        for (Object item : items) {
//            System.out.println(item.getName() + ": " + item.getValue());
//        }
//    }
//}
