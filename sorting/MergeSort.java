package Sorting.mergeSort;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        mergeSortHelper(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSortHelper(int[] array, int startIdx, int endIdx) {
        // O(NLogN) time | O(N) space
        if (startIdx == endIdx) return;
        int midIdx = (int) Math.floor(startIdx + (endIdx - startIdx) / 2);
        mergeSortHelper(array, startIdx, midIdx);
        mergeSortHelper(array, midIdx + 1, endIdx);
        doMerge(array, startIdx, midIdx, midIdx + 1, endIdx);
    }
    public static void doMerge(int[] array, int leftStartIdx, int leftEndIdx, int rightStartIdx, int rightEndIdx) {
        int leftArrLen = leftEndIdx - leftStartIdx + 1;
        int rightArrLen = rightEndIdx - rightStartIdx + 1;

        int[] leftSubArray = new int[leftArrLen];
        int[] rightSubArray = new int[rightArrLen];

        System.arraycopy(array, leftStartIdx, leftSubArray, 0, leftArrLen);

        System.arraycopy(array, rightStartIdx, rightSubArray, 0, rightArrLen);

        int i = 0;
        int j = 0;
        int k = leftStartIdx;
        int count = 0;

        while (i < leftArrLen && j < rightArrLen) {
            if (leftSubArray[i] < rightSubArray[j]) {
                array[k++] = leftSubArray[i++];
            } else {

                array[k++] = rightSubArray[j++];
            }
        }

        while (i < leftArrLen) {
            array[k++] = leftSubArray[i++];
        }

        while (j < rightArrLen) {
            array[k++] = rightSubArray[j++];
        }
    }
}
