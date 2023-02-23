/*
Implementation of insertion sort in Java.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
*/

import java.util.Arrays;

class InsertionSort
 {

  void insertionSort(int array[]) 
  {
    int size = array.length;

    for (int step = 1; step < size; step++) 
    {
      int key = array[step];
      int j = step - 1;

      // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<array[j] to key>array[j].

      while (j >= 0 && key < array[j])
     {
        array[j + 1] = array[j];
        --j;
      }

      // Place key at after the element just smaller than it.
      array[j + 1] = key;
    }
  }

  // Driver code
  public static void main(String args[])
   {
    int[] data = { 9, 5, 1, 4, 3 };
    InsertionSort is = new InsertionSort();
    is.insertionSort(data);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}