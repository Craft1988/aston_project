package sorter.project.utils;

import java.util.Comparator;
import java.util.List;


public final class InsertionSort<T> implements SortStrategy<T> {

    @Override
    public List<T> sort(List<T> items, Comparator<T> comparator) {
        for (int i = 1; i < items.size(); i++) {
            T key = items.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(items.get(j), key) > 0) {
                items.set(j + 1, items.get(j));
                j = j - 1;
            }
            items.set(j + 1, key);
        }
        return items;
    }
}


//    public static <T> void insertionSort(List<T> unsorted, Comparator<? super T> c) {
//        for (int i = 1; i < unsorted.size(); i++) {
//            for (int j = i; j > 0; j--) {
//                if (c.compare(unsorted.get(j - 1), unsorted.get(j)) > 0) {
//                    T temp = unsorted.get(j - 1);
//                    unsorted.remove(j - 1);
//                    unsorted.add(j, temp);
//                }
//            }
//        }
//    }
//
//    public static <T> int binarySearch(T item, T[] src) {
//        return -1;
//    }

