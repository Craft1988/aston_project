package sorter.project.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkingCollection {
    private static List<Object> list = new ArrayList<>();

    public static void setIsSorted(boolean isSorted) {
        WorkingCollection.isSorted = isSorted;
    }

    public static boolean isSorted() {
        return isSorted;
    }

    private static boolean isSorted = false;

    public static int getDetectedObject() {
        return detectedObject;
    }

    public static void setDetectedObject(int detectedObject) {
        WorkingCollection.detectedObject = detectedObject;

    }

    private static int detectedObject;

    private WorkingCollection() {
        throw new UnsupportedOperationException();
    }

    public static <T> void addInCollection(List<T> addedList) {
        list.addAll(addedList);
        System.out.println("Данные добавлены");
    }

    public static void deleteCollection() {
        list.clear();
    }

    public static List<Object> getCollection() {
        return new ArrayList<>(list);
    }
}
