/*
	Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from an 
	unsorted part of the array and putting it at the beginning of the array. 
    
  In each iteration, the minimum element is found by comparing each element of the unsorted part of the array with the current minimum 
	element, and if a smaller element is found, it becomes the new minimum element. 
    
  Once the minimum element is found, it is swapped with the first element of the unsorted part of the array. 

	This process is repeated until the entire array is sorted. The main idea behind selection sort is to divide 
	the array into two parts: a sorted part and an unsorted part. 
    
  Initially, the sorted part is empty, and the unsorted part is the entire array. In each iteration, the minimum element is selected from 
	the unsorted part and added to the end of the sorted part.

	The time complexity of selection sort is O(n^2) in both the best and worst cases, where n is the number 
	of elements in the array. This is because for each element in the array, it needs to compare it with 
	every other element to find the smallest one, which takes O(n) time. Since this process needs to be 
	repeated for each element, the overall time complexity becomes O(n^2).

	The space complexity of selection sort is O(1) because it does not require any extra space other than 
	the input array itself. It performs the sorting in place by swapping the elements within the array.
*/
// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]

import java.util.Arrays;

class SelectionSort {
  void selectionSort(int array[])
   {
    int size = array.length;

    for (int step = 0; step < size - 1; step++)
     {
      int min_idx = step;

      for (int i = step + 1; i < size; i++) 
      {
        // To sort in descending order, change > to < in this line.
        // Select the minimum element in each loop.

        if (array[i] < array[min_idx])
        {
          min_idx = i;
        }
      }

      // put min at the correct position
      
      int temp = array[step];
      array[step] = array[min_idx];
      array[min_idx] = temp;
    }
  }

  // driver code
  public static void main(String args[]) 
  {
    int[] data = { 20, 12, 10, 15, 2 };
    SelectionSort ss = new SelectionSort();
    ss.selectionSort(data);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}