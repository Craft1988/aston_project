package sorter.project.entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import sorter.project.utils.SortStrategy;

public class WorkingCollection {
    private static List<Object> list = new ArrayList<>();

    private WorkingCollection() {
        throw new UnsupportedOperationException();
    }

    public static <T> boolean addInCollection(List<T> addedList) {
        list.addAll(addedList);
        System.out.println("Данные добавлены");
        return false;
    }

    public static void deleteCollection() {
        list.clear();
    }

    public static List<Object> getCollection() {
        return new ArrayList<>(list);
    }

    public static void saveCollectionToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Object item : list) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Коллекция успешно сохранена в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении коллекции в файл: " + e.getMessage());
        }
    }

    public static void sortAndPrint(SortStrategy<Object> sortStrategy, Comparator<Object> comparator) {
        sortStrategy.sort(list, comparator);
        for (Object item : list) {
            System.out.println(item.toString());
        }
    }

    public static int binarySearch(Object target, Comparator<Object> comparator) {
        List<Object> sortedList = new ArrayList<>(list);
        sortedList.sort(comparator);

        int left = 0, right = sortedList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = comparator.compare(sortedList.get(mid), target);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}


//package sorter.project.entity;
//
//import sorter.project.utils.SortStrategy;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class WorkingCollection<T> {
//    private static List<Object> list = new ArrayList<>();
//
//    private WorkingCollection() {
//        throw new UnsupportedOperationException();
//    }
//
//    public static <T> boolean addInCollection(List<T> addedList) {
//        list.addAll(addedList);
//        System.out.println("Данные добавлены");
//        return false;
//    }
//
//    public static void deleteCollection() {
//        list.clear();
//    }
//
//    public static <T> List<T> getCollection() {
//        return (List<T>) new ArrayList<>(list);
//    }
//
//    public static void saveCollectionToFile(String filename) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (Object item : list) {
//                writer.write(item.toString());
//                writer.newLine();
//            }
//            System.out.println("Коллекция успешно сохранена в файл: " + filename);
//        } catch (IOException e) {
//            System.err.println("Ошибка при сохранении коллекции в файл: " + e.getMessage());
//        }
//    }
//
//    public static void sortAndPrint(SortStrategy<Object> sortStrategy, Comparator<Object> comparator) {
//        sortStrategy.sort(list, comparator);
//        for (Object item : list) {
//            System.out.println(item.toString());
//        }
//    }
//}

////package sorter.project.entity;
////
////import java.util.ArrayList;
////import java.util.List;
////
////public class WorkingCollection<T> {
////    private static List<T> list = new ArrayList<>();
////
////    private WorkingCollection() {
////        throw new UnsupportedOperationException();
////    }
////
////    public static <T> void addInCollection(List<T> addedList) {
////        list.addAll(addedList);
////        System.out.println("Данные добавлены");
////    }
////
////    public static void deleteCollection() {
////        list.clear();
////    }
////
////    public static <T> List<T> getCollection() {
////        return new ArrayList<>(list);
////    }
////}
//
//
//package sorter.project.entity;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WorkingCollection {
//    private static List list = new ArrayList<>();
//
//    private WorkingCollection() {
//        throw new UnsupportedOperationException();
//    }
//
//    public static void addInCollection(List addedList) {
//        for (int i = 0; i < addedList.size(); i++) {
//            list.add(addedList.get(i));
//        }
//        System.out.println("Данные добавлены");
//    }
//
//    public static void deleteColection() {
//        list.clear();
//    }
//
//    public static List addedCollection() {
//        return list;
//    }
//
//    public static void saveCollectionToFile(String filename) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (Object item : list) {
//                writer.write(item.toString());
//                writer.newLine();
//            }
//            System.out.println("Коллекция успешно сохранена в файл: " + filename);
//        } catch (IOException e) {
//            System.err.println("Ошибка при сохранении коллекции в файл: " + e.getMessage());
//        }
//
//
//    }
//}