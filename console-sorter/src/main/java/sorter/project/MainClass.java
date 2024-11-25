package sorter.project;

import java.util.Scanner;

import sorter.project.controller.SortTheCollectionController;
import sorter.project.entity.WorkingCollection;
import static sorter.project.controller.FillingInCollectionsController.fillingNewOrOld;

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
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    fillingNewOrOld();
                    break;
                case 2:
//                    SortTheCollectionController.sortTheCollection();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    for (Object o : WorkingCollection.addedCollection()) {
                        System.out.println(o.toString());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

    }


}