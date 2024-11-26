package sorter.project.controller;

import sorter.project.entity.WorkingCollection;
import sorter.project.utils.Writer;

import java.util.Scanner;

public class FilesController {
    public static void fileEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла для сохранения:");
        scanner.nextLine();
        String filename = scanner.nextLine();
        Writer.writeToFile(filename,WorkingCollection.getCollection());
    }
}
