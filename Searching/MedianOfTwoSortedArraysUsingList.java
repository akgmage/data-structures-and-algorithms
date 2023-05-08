package Searching;

import java.util.ArrayList;

public class MedianOfTwoSortedArraysUsingList {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        double ans  = solve(a, b);
        System.out.println(ans);
    }
    public static double solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        int len1 = a.size();
        int len2 = b.size();

        //--  EDGE CASES
        if (len1 == 0 && len2 == 0) { // both lengths are zero
            return 0.0;
        }

        if (len1 == 0 && len2 == 1) { // array1 length is 0 ans array2 length is 1
            return b.get(0) * 1.0;
        }
        if (len1 == 1 && len2 == 0) { // array2 length is 0 ans array1 length is 1
            return a.get(0) * 1.0;
        }

        int min;
        int max;
        if (len1 == 0) { // array1 length is zero
            min = b.get(0);
            max = b.get(len2 - 1);
        } else if (len2 == 0) { // array2 length is zero
            min = a.get(0);
            max = a.get(len1 - 1);
        } else {
            max = Math.max(a.get(len1 - 1), b.get(len2 - 1));
            min = Math.min(a.get(0), b.get(0));
        }

        // -- Actual Logic
        int len = len1 + len2;
        int k = (len1 + len2) / 2;
        if (len % 2 == 0) {
            double ans1 = applyBinarySearch(a, b, k, min, max);
            double ans2 = applyBinarySearch(a, b, k - 1, min, max);
            return (ans1 + ans2) / 2.0;
        } else {
            return applyBinarySearch(a, b, k, min, max);
        }
    }
    public static double applyBinarySearch(ArrayList<Integer> a, ArrayList <Integer> b, int target, int left, int right) {
        int len1 = a.size();
        int len2 = b.size();

        int k = (len1 + len2) / 2;
        int ans= 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count1 = getCountOfSmallerElements(a, mid);
            int count2 = getCountOfSmallerElements(b, mid);
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
    public static int getCountOfSmallerElements(ArrayList<Integer> a, int k) {
        // apply binary search
        int count = 0;

        int left = 0;
        int right = a.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int currentNum = a.get(mid);

            if (currentNum <= k) {
                if (currentNum == k) {
                    count = mid;
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
