/*
Sorting: Implement Heap Sort in Java
*/

/*
APPROACH: Build Max Heap: The first step is to build a max heap from the given array. This is done by starting from the middle element of the array and heapifying each subtree in a bottom-up manner. Heapify operation ensures that the largest element is at the root of the subtree.

Extract Elements: After building the max heap, the largest element (root) is at the top of the heap. We swap it with the last element of the heap and reduce the heap size by 1. Then, we heapify the root to maintain the heap property. We repeat this process until all the elements are extracted and the heap is empty.
*/

public class HeapSort {
  
    public void heapSort(int[] array) {
        int length = array.length;

        // Build max heap
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        // Extract elements from the heap in sorted order
        for (int i = length - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    void heapify(int[] array, int length, int i) {
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1; // Left child index
        int rightChild = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (leftChild < length && array[leftChild] > array[largest])
            largest = leftChild;

        // If right child is larger than largest so far
        if (rightChild < length && array[rightChild] > array[largest])
            largest = rightChild;

        // If largest is not the root
        if (largest != i) {
            // Swap the root with the largest element
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(array, length, largest);
        }
    }

    // Utility function to print an array
    void printArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        int length = array.length;

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        System.out.println("Sorted array: ");
        heapSort.printArray(array);
    }
}
/*
Time Complexity: The time complexity of Heap Sort is O(n log n), where n is the number of elements in the array. The initial heap construction takes O(n) time, and the repeated heapify operation during extraction takes O(log n) time. As we perform heapify for each element, the overall time complexity is O(n log n).

Space Complexity: The space complexity of Heap Sort is O(1) since the sorting is performed in-place, without requiring any additional space proportional to the input size.
*/

