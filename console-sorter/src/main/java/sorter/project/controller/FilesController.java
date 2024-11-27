package sorter.project.controller;

import sorter.project.entity.WorkingCollection;
import sorter.project.utils.Writer;

import java.util.Scanner;

public class FilesController {
    public static void fileEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла для сохранения:");
        String filename = scanner.nextLine();
        System.out.println("Выберите действие:");
        System.out.println("1. Записать коллекцию");
        System.out.println("2. Записать индекс найденого элемента");
        int type = scanner.nextInt();
        switch (type){
            case 1:
                Writer.writeCollectionToFile(filename,WorkingCollection.getCollection());
                break;
            case 2:
                Writer.writeIndexToFile(filename,WorkingCollection.getDetectedObject());
                break;
            default:
                break;
        }

    }
}
