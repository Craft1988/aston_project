package sorter.project.utils;

import java.util.Comparator;
import java.util.List;

public interface SortStrategy<T> {

    List<T> sort(List<T> items, Comparator<T> comparator);

}