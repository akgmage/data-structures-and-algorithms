/*
Radix sort is a sorting Algorithm that sorts elements by grouping them based on their individual digits or by the position of their digits. 
It is a linear time sorting Algorithm that has a time complexity of O(nk).

Using the Least Significant Bit
In this method, we will write a go language program to implement the radix sort by using the least significant bit. LSD sorts the elements 
from right to left by comparing their individual digits.

Algorithm
Step 1 − First, we need to import the fmt package. Then create a function named radixSortMSD() to sort the array.

Step 2 − Inside the function create a new array. Use the for loop to iterate over the array and store the maximum element of the array in a variable.

Step 3 − Now, initialize a count array to keep track of the number of elements that have a particular digit.

Step 4 − Traverse the array and increment the count for the corresponding digit for each element.

Step 5 − Modify the count array to store the actual position of each element in the Output array. Copy the elements from the input array to the 
Output array in the order specified by the count array.

Step 6 − Update the input array to the sorted Output array and return the sorted array.

Step 7 − Start the main() function. Inside the main() initialize an array and store value to it. further, call the radixSort() function and pass 
the array as an argument to the function.

Step 8 − Store the result obtained by the function in a variable and print It on the screen.

The code implements Radix Sort using the LSD (Least Significant Digit) approach to sort an array of integers. It iterates through each digit from 
the least significant to the most significant, performing counting sort for each digit. Counting sort is used to determine the correct positions 
of elements based on the current digit. The sorted elements are then copied back to the original array. This process is repeated until all digits 
have been processed, resulting in a sorted array.
*/

package main

import "fmt"

// radixSortLSD performs Radix Sort using the LSD (Least Significant Digit) algorithm
func radixSortLSD(arr []int) []int {
   // Find the maximum element in the array
   max := arr[0]
   for i := 1; i < len(arr); i++ {
      if arr[i] > max {
         max = arr[i]
      }
   }
   
   exp := 1
   // Perform counting sort for each digit from LSD to MSD
   for max/exp > 0 {
      // Create a count array to store the frequency of each digit (0-9)
      count := make([]int, 10)
      
      // Count the frequency of each digit at the current exponent
      for i := 0; i < len(arr); i++ {
         count[(arr[i]/exp)%10]++
      }
      
      // Calculate the cumulative sum of count array to determine the correct positions of each digit
      for i := 1; i < 10; i++ {
         count[i] += count[i-1]
      }
      
      // Create an output array to store the sorted elements based on the current digit
      output := make([]int, len(arr))
      
      // Build the output array by placing each element in its correct position based on the current digit
      for i := len(arr) - 1; i >= 0; i-- {
         output[count[(arr[i]/exp)%10]-1] = arr[i]
         count[(arr[i]/exp)%10]--
      }
      
      // Copy the sorted elements from the output array back to the original array
      for i := 0; i < len(arr); i++ {
         arr[i] = output[i]
      }
      
      // Move to the next digit by multiplying the exponent by 10
      exp *= 10
   }
   
   // Return the sorted array
   return arr
}

func main() {
   // Test the radixSortLSD function
   arr := []int{15, 31, 42, 20, 9}
   fmt.Println("The unsorted array is:", arr)
   result := radixSortLSD(arr)
   fmt.Println("The sorted array is:", result)
}

// Output
// The unsorted array is: [15 31 42 20 9]
// The sorted array is: [9 15 20 31 42]

// Time Compexity -> O((n+k)*d)
// Space Complexity -> O(n+k)