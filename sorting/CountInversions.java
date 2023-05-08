package Sorting.mergeSort;

public class CountInversions {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        long ans = countInversionsHelper(array, 0, array.length - 1);
        System.out.println(ans);
    }
    public static long countInversionsHelper(int[] array, int startIdx, int endIdx) {
        long mod=1000000007;
        if (startIdx == endIdx) return 0L;
        int midIdx = (int) Math.floor((int) (startIdx + (endIdx - startIdx) / 2) ) ;

        long leftInversions = countInversionsHelper(array, startIdx, midIdx) % mod;
        long rightInversions = countInversionsHelper(array, midIdx + 1, endIdx) % mod;
        long mergedInversions = doMergeAndCountInversions(array, startIdx, midIdx, midIdx+1, endIdx) % mod;
        return (leftInversions + rightInversions + mergedInversions) % mod;
    }
    public static long doMergeAndCountInversions (int[] array, int leftStartIdx, int leftEndIdx, int rightStartIdx, int rightEndIdx) {
        long inversionsCount = 0;
        int leftArrLength = leftEndIdx - leftStartIdx + 1;
        int rightArrLength = rightEndIdx - rightStartIdx + 1;

        int[] leftArr = new int[leftArrLength];
        int[] rightArr = new int[rightArrLength];

        System.arraycopy(array, leftStartIdx, leftArr, 0, leftArrLength);
        System.arraycopy(array, rightStartIdx, rightArr, 0, rightArrLength);

        int i = 0;
        int j = 0;
        int k = leftStartIdx;
        while (i < leftArrLength && j < rightArrLength) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            }else {
                // count inversions
                inversionsCount += leftArrLength - i;
                // continue merge-algorithm
                array[k++] = rightArr[j++];
            }
        }

        while (i < leftArrLength) {
            array[k++] = leftArr[i++];
        }

        while (j < rightArrLength) {
            array[k++] = rightArr[j++];
        }

        return inversionsCount;
    }
}
