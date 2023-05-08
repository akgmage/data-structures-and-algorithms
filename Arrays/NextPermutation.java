package InterviewProblems;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] arr) {
        // O(N) time | O(1) space

        // 1. First Find the idx where arr[idx] < arr[idx+1]

        // 2. Initialize idx with -1, so if we don`t
        // num where arr[idx] < arr[idx+1]
        // simply reverse the whole array

        int idx = -1;
        int n = arr.length;

        for (int i = n - 2; i > -1; i--) {
            if (arr[i] < arr[i+1]) {
                idx = i;
                break;
            }
        }

        // check if idx = -1
        if (idx == -1) {
            reverse(0, n - 1, arr);
            return arr;
        }

        // find the smallest num among remaining nums where arr[idx] > num

        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                swap(i, idx, arr);
                break;
            }
        }

        // reverse remaining nums starting from idx + 1
        reverse(idx + 1, n - 1, arr);
        return arr;
    }

    public static void reverse(int i, int j, int[] arr) {
        while (i < j) {
            swap(i, j, arr);
            i++;
            j--;
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
