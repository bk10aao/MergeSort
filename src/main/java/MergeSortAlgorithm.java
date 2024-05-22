@SuppressWarnings("unchecked")
public class MergeSortAlgorithm {

    public static Comparable[] aux;

    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int low = 0;
        int high = a.length - 1;
        sort(aux, a, low, high);
    }

    private void sort(Comparable[] values1, Comparable[] values2, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low)/2;
        sort(values1, values2, low, mid);
        sort(values1,values2, mid+1, high);
        Commons.merge(values1, values2, low, mid, high);
    }
}