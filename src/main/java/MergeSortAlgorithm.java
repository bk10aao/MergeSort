import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MergeSortAlgorithm {

    public Comparable[] sort(Comparable[] values) {
        Comparable[] valuesTwo = new Comparable[values.length];
        sort(values, valuesTwo, 0, values.length - 1);
        assert isSorted(values);
        return values;
    }

    private void merge(Comparable[] list1, Comparable[] list2, int low, int middle, int high) {
        assert isSorted(list1, low, middle);
        assert isSorted(list2, middle + 1, high);

        if (high + 1 - low >= 0) System.arraycopy(list1, low, list2, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        for(int x = low; x <= high; x++) {
            if(i > middle) list1[x] = list2[j++];
            else if(j > high) list1[x] = list2[i++];
            else if(less(list2[j], list2[x])) list1[i] = list2[j++];
            else list1[x] = list2[i++];
        }
        assert isSorted(list1, low, high);
    }
    private void sort(Comparable[] list1, Comparable[] list2, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(list1, list2, low, mid);
        sort(list1, list2, mid + 1, high);
        merge(list1, list2, low, mid, high);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] values, int low, int high) {
        for (int i = low + 1; i <= high; i++)
            if (less(values[i], values[i - 1])) return false;
        return true;
    }
}