package sorter.project.controller;

import sorter.project.entity.WorkingCollection;

import java.util.Scanner;

public class FilesController {
    public static void fileEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла для сохранения:");
        scanner.nextLine();
        String filename = scanner.nextLine();
        WorkingCollection.saveCollectionToFile(filename);
    }
}
