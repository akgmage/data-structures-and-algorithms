/*
 * Dutch National Flag Problem
 *
 * Given an array of 0's, 1's, and 2's, sort the array in linear time, without using extra space.
 *
 * This is known as the Dutch National Flag problem.
 *
 * The idea here is to divide the array into three regions such that the starting region contains all the 0's,
 * the next region contains all the 1's, and the final region contains all the 2's.
 *
 * The algorithm works by maintaining three pointers:
 *
 *   * `low`: The index of the first 0 in the array.
 *   * `mid`: The index of the current element being processed.
 *   * `high`: The index of the last 2 in the array.
 *
 * The algorithm then iterates through the array, and does the following:
 *
 *   * If the current element is a 0, swap it with the element at `low` and increment both `low` and `mid` by 1.
 *   * If the current element is a 1, increment `mid` by 1.
 *   * If the current element is a 2, swap it with the element at `high` and decrement `high` by 1.
 *
 * Once the algorithm has finished iterating, the array will be sorted.
 */

public class DutchNationalFlag {

    public static void sort(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    swap(array, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(array, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 2, 1, 0, 2, 0, 1};

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
}
