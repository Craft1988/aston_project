package sorter.project.utils;

import java.util.List;


public final class InsertionSort<T> implements SortStrategy {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
