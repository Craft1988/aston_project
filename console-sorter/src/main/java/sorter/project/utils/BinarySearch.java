package sorter.project.utils;

import java.util.Comparator;
import java.util.List;

public final class BinarySearch<T> {
    public int search(List<T> items, Object target, Comparator<T> comparator) {
        int left = 0, right = items.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = comparator.compare(items.get(mid), (T) target);
            if (cmp == 0) return mid + 1;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}