public class MergeSortBottomUp {

    public static void sort(Comparable[] values) {
        int n = values.length;
        Comparable[] aux = new Comparable[n];
        for (int size = 1; size < n; size = 2 * size)
            for (int low = 0; low < n - size; low += 2 * size)
                Commons.mergeTwo(values, aux, low, low + size - 1, Math.min(low + size + size - 1, n - 1));
    }
}
