package sorter.project;

import java.util.Scanner;

import sorter.project.controller.*;
import sorter.project.entity.WorkingCollection;

public class MainClass {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнить коллекцию");
            System.out.println("2. Сортировать коллекцию");
            System.out.println("3. Найти элемент");
            System.out.println("4. Записать в файл");
            System.out.println("5. Вывести в консоль");
            /*Строчки четных/нечетных считаются относительно одинаковых объектов*/
            System.out.println("6. Сортировать согласно доп заданию(Объекты без цифровых полей удалятся, вещественные округляются для определения четности)");
            System.out.println("7. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    FillingInCollectionsController.fillingNewOrOld();
                    break;
                case 2:
                    SortTheCollectionController.sortCollection();
                    break;
                case 3:
                    BinarySearchController.binarySearch();
                    break;
                case 4:
                    FilesController.fileEntry();
                    break;
                case 5:
                    for (Object o : WorkingCollection.getCollection()) {
                        System.out.println(o.toString());
                    }
                    break;
                case 6:
                    ExtraSortTheCollectionController.sortCollection();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}