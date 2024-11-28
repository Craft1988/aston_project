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
        System.out.println("2. Записать индекс найденного элемента");
        int type = scanner.nextInt();
        if (type == 1 && WorkingCollection.getCollection().isEmpty()) {
            System.out.println("Коллекции нет");
            type = 3;
        }
        if (type == 2 && (WorkingCollection.getDetectedObject() == -1 || WorkingCollection.getDetectedObject() == 0)) {
            System.out.println("Объект не был найден");
            type = 3;
        }
        switch (type) {
            case 1:
                Writer.writeCollectionToFile(filename, WorkingCollection.getCollection());
                break;
            case 2:
                Writer.writeIndexToFile(filename, WorkingCollection.getDetectedObject());
                break;
            default:
                break;
        }

    }
}
