package Searching;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {-41, -4, 15, 17, 28, 30, 40};
        int[] array2 = {-41, -40, -35, -30, -8, 6, 6, 15, 24};
        double ans = solve(array1, array2);
        System.out.println(ans);
    }
    public static double solve(int[] array1, int[] array2) {

        // O(Log(Max-Min)*LogN+LogM) time | O(1) space where
        //  N and M are length of array1 and array2.

        // 1. find min from array1 and array2;
        int len1 = array1.length;
        int len2 = array2.length;

        //--  EDGE CASES
        if (len1 == 0 && len2 == 0) { // both lengths are zero
            return 0;
        }

        if (len1 == 0 && len2 == 1) { // array1 length is 0 ans array2 length is 1
            return array2[0]*1.0;
        }

        if (len1 == 1 && len2 == 0) { // array2 length is 0 ans array1 length is 1
            return array1[0]*1.0;
        }

        int min;
        int max;
        if (len1 == 0) { // array1 length is zero
            min = array2[0];
            max = array2[len2 - 1];
        } else if (len2 == 0) { // array2 length is zero
            min = array1[0];
            max = array1[len1 - 1];
        } else {
            max = Math.max(array1[len1 - 1], array2[len2 - 1]);
            min = Math.min(array1[0], array2[0]);
        }

        // -- Actual Logic
        int len = len1 + len2;
        int k = (len1 + len2) / 2;
        if (len % 2 == 0) {
            double ans1 = applyBinarySearch(array1, array2, k, min, max);
            double ans2 = applyBinarySearch(array1, array2, k+1, min, max);
            return (ans1 + ans2)/2.0;
        } else {
            return applyBinarySearch(array1, array2, k, min, max);
        }
    }

    public static double applyBinarySearch(int[] array1, int[] array2, int target, int left, int right) {
        int len1 = array1.length;
        int len2 = array2.length;

        int k = (len1 + len2) / 2;
        int ans= 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count1 = getCountOfSmallerElements(array1, mid);
            int count2 = getCountOfSmallerElements(array2, mid);
            int count = count1 + count2;

            if (count <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans*1.0;

    }
    public static int getCountOfSmallerElements(int[] array, int k) {
        // apply binary search
        int count = 0;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int currentNum = array[mid];

            if (currentNum <= k) {
                if (currentNum == k) {
                    count = mid; // [1, 2, 3, 4 , 4, 5, 6, 6]
                    right = mid - 1;
                } else {
                    count = mid + 1;
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
