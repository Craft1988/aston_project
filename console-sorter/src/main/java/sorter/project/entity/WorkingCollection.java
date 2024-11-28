package sorter.project.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkingCollection {
    private static final List<Object> list = new ArrayList<>();
    private static boolean isSorted = false;

    private static int detectedObject;

    private WorkingCollection() {
        throw new UnsupportedOperationException();
    }

    public static boolean isSorted() {
        return isSorted;
    }
    public static void setIsSorted(boolean isSorted) {
        WorkingCollection.isSorted = isSorted;
    }
    public static void setDetectedObject(int detectedObject) {
        WorkingCollection.detectedObject = detectedObject;

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

    public static int getDetectedObject() {
        return detectedObject;
    }
}
