/*
    Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. 
    It starts with the second element of the array, compares it with the first element, and swaps them 
    if necessary. It then continues to the third element, compares it with the first and second elements, 
    and swaps it into the correct position. This process continues until the last element is compared and 
    sorted into its correct position in the sorted array.

    At each iteration, the algorithm assumes that the subarray to the left of the current element is already 
    sorted, and it searches for the correct position of the current element within that subarray by comparing 
    it to each element from right to left until it finds the correct position. Once it finds the correct 
    position, it shifts all the larger elements to the right to make space for the current element and 
    inserts it in its correct position.

    Insertion sort has an average-case time complexity of O(n^2) but can perform better than other O(n^2) 
    algorithms, such as bubble sort or selection sort, in certain cases. It is also an efficient algorithm 
    for small data sets or partially sorted data sets.
    
	In this implementation, we define a function called InsertionSort that takes an array of integers and sorts
	it in ascending order using the Insertion Sort algorithm.

	The algorithm works by iterating over the array from the second element to the end.

	For each element, it compares it with the previous elements in the array and inserts it in the correct position.

	The current variable holds the value of the current element being compared.

	The j variable holds the index of the previous element being compared.

	The loop compares the current value with the previous values in the array and shifts the values to the right to make space for the current value.

	Once the correct position is found, the current value is inserted into the array.

	Finally, the sorted array is returned. In the main function, we define an array of integers, sort it using the InsertionSort function, and print the sorted array.

	Sample input: [0, 2, 1,-1, 10, 3, 4]
	Output: [-1 0 1 2 3 4 10]
*/

// InsertionSort is a function that takes an array of integers and sorts it in
// ascending order using the Insertion Sort algorithm.
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are greater than key, to one
            position ahead of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
