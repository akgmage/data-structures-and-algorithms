// Implementation of Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

// Time Complexity worst-case and average complexity O(n^{2})
// Bubble sort is O(n) on a list that is already sorted i.e. Best case

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]




package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 8, 17, 19, 45, -78, -87, 0, 11};
        bubble(nums);
        System.out.println(Arrays.toString(nums));


    }
    static void bubble(int[] arr){
        boolean swapped;
        // run the steps n-1 times
        for(int i = 0; i < arr.length; i++){
            swapped = false;
            // for each step, max item will come at the last respective index
            for(int j = 1; j < arr.length-i; j++){
                // swap if the item is smaller than the previous item
                if (arr[j] > arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular of i, it means the array is sorted hence stop the program
            if(!swapped){
                break;
            }
        }
    }
}

