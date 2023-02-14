// Insertion sort in Java

// Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

// Time complexity = O(n^2) and Space complexity = O(1).

// Sample input = [ 9, 5, 1, 4, 3] , Output = [1, 3, 4, 5, 9]


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