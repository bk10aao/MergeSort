public class Commons {

    public static boolean isSorted(Comparable[] values, int low, int high) {
        for (int i = low + 1; i <= high; i++)
            if (less(values[i], values[i - 1])) return false;
        return true;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void merge(Comparable[] values1, Comparable[] values2, int low, int middle, int high) {
        assert Commons.isSorted(values1, low, middle);
        assert Commons.isSorted(values1, middle + 1, high);
        if (high + 1 - low >= 0) System.arraycopy(values2, low, values1, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        for (int x = low; x <= high; x++) {
            if (i > middle) values2[x] = values1[j++];
            else if (j > high) values2[x] = values1[i++];
            else if (less(values1[j], values1[i])) values2[x] = values1[j++];
            else values2[x] = values1[i++];
        }
    }

    public static void mergeTwo(Comparable[] values1, Comparable[] values2, int low, int middle, int high) {
        assert Commons.isSorted(values1, low, middle);
        assert Commons.isSorted(values1, middle + 1, high);
        if (high + 1 - low >= 0) System.arraycopy(values1, low, values2, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        for (int x = low; x <= high; x++){
            if(i > middle) values1[x] = values2[j++];
            else if (j > high) values1[x] = values2[i++];
            else if (Commons.less(values2[j], values2[i])) values1[x] = values2[j++];
            else values1[x] = values2[i++];
        }
    }
}