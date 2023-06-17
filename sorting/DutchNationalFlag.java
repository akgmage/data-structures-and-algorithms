package sorting;

/*
 *Explanation:
The code above solves the Dutch National Flag problem. It takes an array of integers and a pivot element as input, and sorts the array in the Dutch National Flag order. The Dutch National Flag problem involves partitioning the array into three sections based on the pivot element.

The dutchNationalFlagSort method uses three pointers: low, mid, and high. The low pointer represents the boundary for elements less than the pivot, the mid pointer represents the boundary for elements equal to the pivot, and the high pointer represents the boundary for elements greater than the pivot.

The method uses a while loop that continues until the mid pointer surpasses the high pointer. Inside the loop, it compares the element at the mid index with the pivot. If the element is less than the pivot, it swaps it with the element at the low index and increments both low and mid. If the element is greater than the pivot, it swaps it with the element at the high index and decrements high. If the element is equal to the pivot, it increments mid.

The swap method is a helper function that swaps two elements in the array.

In the main method, an example array and pivot value are provided. The dutchNationalFlagSort method is called with these values, and the sorted array is printed.

Time Complexity: The time complexity of the Dutch National Flag algorithm is O(n), where n is the length of the input array.

Space Complexity: The space complexity is O(1) as the algorithm sorts the array in-place without using any additional data structures. 
**/
import java.util.Arrays;

public class DutchNationalFlag {

    /**
     * Sorts an array of integers in the Dutch National Flag order.
     * The Dutch National Flag problem partitions the array into three sections:
     * - All elements less than the pivot are placed before it.
     * - All elements greater than the pivot are placed after it.
     * - All elements equal to the pivot are placed in the middle.
     *
     * @param array the array of integers to be sorted
     * @param pivot the pivot element
     */
    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 0, 0, 2, 1, 0};
        int pivot = 1;

        dutchNationalFlagSort(array, pivot);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
    
    public static void dutchNationalFlagSort(int[] array, int pivot) {
        int low = 0; // Pointer for elements less than the pivot
        int mid = 0; // Pointer for elements equal to the pivot
        int high = array.length - 1; // Pointer for elements greater than the pivot

        while (mid <= high) {
            if (array[mid] < pivot) { // Current element is less than the pivot
                swap(array, low, mid); // Swap current element with element at the low index
                low++; // Increment low pointer
                mid++; // Increment mid pointer
            } else if (array[mid] > pivot) { // Current element is greater than the pivot
                swap(array, mid, high); // Swap current element with element at the high index
                high--; // Decrement high pointer
            } else { // Current element is equal to the pivot
                mid++; // Increment mid pointer
            }
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

