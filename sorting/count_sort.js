/*
                                        Count Sort
The Counting Sort algorithm is a non-comparative sorting algorithm that works by counting the occurrences of each distinct element in the input 
list. It then uses this information to determine the correct position of each element in the sorted output.

Here are the steps involved in the Counting Sort algorithm:

1. Find the range: Determine the range of values in the input list. This range is necessary to create an array with the appropriate size to store the counts.

2. Count the occurrences: Create a count array of size equal to the range determined in the previous step. Iterate through the input list and count 
the occurrences of each element by incrementing the corresponding count in the count array.

3. Calculate cumulative counts: Modify the count array such that each element represents the cumulative count of elements up to that index. This step 
ensures that the count array contains the correct positions for each element in the sorted order.

4. Generate the sorted output: Create an output array of the same size as the input list. Iterate through the input list and use the count array to 
determine the correct position of each element in the output array. Place each element in its corresponding position and decrement the count 
in the count array.

5. Return the sorted list: The output array now contains the elements in sorted order. Return this sorted list as the result of the Counting Sort algorithm.

Here's an example to illustrate the process:

Sample Input: [4, 2, 9, 4, 6, 1]

1. Find the range: The range of values in the input list is from 1 to 9.
2. Count the occurrences: Create the count array [0, 1, 1, 0, 2, 0, 1, 0, 0, 1], where the index represents the element and the value represents the count.
3. Calculate cumulative counts: Modify the count array to [0, 1, 2, 2, 4, 4, 5, 5, 5, 6]. Each element represents the cumulative count of elements up to that index.
4. Generate the sorted output: Create the output array [1, 2, 4, 4, 6, 9]. Iterate through the input list, use the count array to determine the correct 
position of each element, place it in the output array, and decrement the count in the count array.
5. Return the sorted list: The sorted list is [1, 2, 4, 4, 6, 9].

Counting Sort is an efficient algorithm when the range of values in the input list is relatively small. It has a time complexity of O(n + k), where n is 
the number of elements in the input list and k is the range of values.
*/

function sort(arr)
{
    var n = arr.length;
 
    // The output character array that will have sorted arr
    var output = Array.from({length: n}, (_, i) => 0);
 
    // Create a count array to store count of individual
    // characters and initialize count array as 0
    var count = Array.from({length: 256}, (_, i) => 0);
 
 
    // store count of each character
    for (var i = 0; i < n; ++i)
        ++count[arr[i].charCodeAt(0)];
    // Change count[i] so that count[i] now contains actual
    // position of this character in output array
    for (var i = 1; i <= 255; ++i)
        count[i] += count[i - 1];
 
    // Build the output character array
    // To make it stable we are operating in reverse order.
    for (var i = n - 1; i >= 0; i--) {
        output[count[arr[i].charCodeAt(0)] - 1] = arr[i];
        --count[arr[i].charCodeAt(0)];
    }
 
    // Copy the output array to arr, so that arr now
    // contains sorted characters
    for (var i = 0; i < n; ++i)
        arr[i] = output[i];
     return arr;
}
 
// Driver method
    var arr = [ 'g', 'e', 'e', 'k', 's', 'f', 'o',
                   'r', 'g', 'e', 'e', 'k', 's' ];
 
    arr = sort(arr);
    document.write("Sorted character array is ");
    for (var i = 0; i < arr.length; ++i)
        document.write(arr[i]);