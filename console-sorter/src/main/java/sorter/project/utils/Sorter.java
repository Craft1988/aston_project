package sorter.project.utils;

import java.util.Arrays;

import sorter.project.entity.SelfComparator;

public final class Sorter {
	private Sorter() {
		throw new UnsupportedOperationException();
	}

	public static <T> void sortAnyCustomClass(SelfComparator<T>... src) {

		for (int i = 0; i < src.length; i++) {
			for (int j = i; j > 0; j--) {
				if (src[j - 1].moreThen((T) src[j])) {
					T temp = (T) src[j - 1];
					src[j - 1] = src[j];
					src[j] = (SelfComparator<T>) temp;
				}
			}
		}
	}

	public static <T> int binarySearch(SelfComparator<T> item, SelfComparator<T>... src) {
		if (src.length < 2)
			return 0;
		int middle = src.length / 2;
		if (src[middle].equals(item)) {
			return middle;
		} else if (item.moreThen((T) src[middle])) {
			return middle + binarySearch(item, Arrays.copyOfRange(src, middle, src.length));
		} else if (src[middle].moreThen((T) item)) {
			return binarySearch(item, Arrays.copyOfRange(src, 0, middle));
		}
		return -1;
	}

}
