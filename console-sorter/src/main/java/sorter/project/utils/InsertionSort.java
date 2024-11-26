package sorter.project.utils;

import java.util.Comparator;
import java.util.List;


public final class InsertionSort<T> implements SortStrategy<T> {

    @Override
    public void sort(List<T> items, Comparator<T> comparator) {
        for (int i = 1; i < items.size(); i++) {
            T key = items.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(items.get(j), key) > 0) {
                items.set(j + 1, items.get(j));
                j = j - 1;
            }
            items.set(j + 1, key);
        }
    }
}




