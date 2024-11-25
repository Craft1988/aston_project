//package sorter.project.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class WorkingCollection<T> {
//    private static List<T> list = new ArrayList<>();
//
//    private WorkingCollection() {
//        throw new UnsupportedOperationException();
//    }
//
//    public static <T> void addInCollection(List<T> addedList) {
//        list.addAll(addedList);
//        System.out.println("Данные добавлены");
//    }
//
//    public static void deleteCollection() {
//        list.clear();
//    }
//
//    public static <T> List<T> getCollection() {
//        return new ArrayList<>(list);
//    }
//}


package sorter.project.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkingCollection {
    private static List list = new ArrayList<>();

    private WorkingCollection() {
        throw new UnsupportedOperationException();
    }

    public static void addInCollection(List addedList) {
        for (int i = 0; i < addedList.size(); i++) {
            list.add(addedList.get(i));
        }
        System.out.println("Данные добавлены");
    }

    public static void deleteColection() {
        list.clear();
    }

    public static List addedCollection() {
        return list;
    }
}
