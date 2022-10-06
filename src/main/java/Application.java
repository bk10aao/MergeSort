import java.util.Arrays;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = random.nextInt(1_000_000);
        System.out.printf("Start: %s\n", Arrays.toString(numbers));
        MergeSortAlgorithm.mergeSort(numbers);
        System.out.printf("End:   %s\n", Arrays.toString(numbers));
    }
}
