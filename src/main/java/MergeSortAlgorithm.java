import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class MergeSortAlgorithm {



    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = random.nextInt(1_000_000);
        System.out.printf("Start:\n%s\n", Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if(inputLength < 2)
            return;

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        System.arraycopy(inputArray, 0, leftHalf, 0, midIndex);
        System.arraycopy(inputArray, midIndex, rightHalf, 0, inputLength - midIndex);
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize) {
            if(leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

}
