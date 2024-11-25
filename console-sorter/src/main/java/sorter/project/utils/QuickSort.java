package sorter.project.utils;

import java.util.Comparator;
import java.util.List;

public final class QuickSort<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> items, Comparator<T> comparator) {
        quickSort(items, 0, items.size() - 1, comparator);
    }

    private void quickSort(List<T> items, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(items, low, high, comparator);
            quickSort(items, low, pi - 1, comparator);
            quickSort(items, pi + 1, high, comparator);
        }
    }

    private int partition(List<T> items, int low, int high, Comparator<T> comparator) {
        T pivot = items.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(items.get(j), pivot) <= 0) {
                i++;
                T temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
            }
        }
        T temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        return i + 1;
    }
}

