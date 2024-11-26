package sorter.project.controller;

import sorter.project.entity.WorkingCollection;
import sorter.project.service.FillFromConsole;
import sorter.project.service.FillFromFile;
import sorter.project.service.FillFromRandom;

import java.util.Scanner;


public class FillingInCollectionsController {

    public static void fillingNewOrOld() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("1. Заполнить новую коллекцию");
        System.out.println("2. Заполнить существующую коллекцию");
        System.out.println("3. На главную");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if (WorkingCollection.addedCollection() != null) {
                    WorkingCollection.deleteColection();
                }
                filling(choice);
                break;
            case 2:
                filling(choice);
                break;
            case 3:

                break;
            default:
                System.out.println("Неверный выбор!");
        }

    }

    public static void filling(int lastChoice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("1. Заполнить объектами Human");
        System.out.println("2. Заполнить объектами Animal");
        System.out.println("3. Заполнить объектами Barrel");
        System.out.println("4. На главную");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fillingType("Human");
                break;
            case 2:
                fillingType("Animal");
                break;
            case 3:
                fillingType("Barrel");
                break;
            case 4:
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private static void fillingType(String lastChoice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("1. Заполнить из консоли");
        System.out.println("2. Заполнить из файла");
        System.out.println("3. Заполнить случайными значениями");
        System.out.println("4. На главную");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                WorkingCollection.addInCollection(FillFromConsole.fill(lastChoice));
                break;
            case 2:
                System.out.println("Введите количество считываемых строк:");
                int choiceCountFile = scanner.nextInt();
                WorkingCollection.addInCollection(FillFromFile.fill(choiceCountFile, lastChoice));
                break;
            case 3:
                System.out.println("Введите количество генерируемых объектов:");
                int choiceCountRandom = scanner.nextInt();
                WorkingCollection.addInCollection(FillFromRandom.fill(choiceCountRandom, lastChoice));
                break;
            case 4:
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }
}

