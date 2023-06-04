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

#include <iostream>
using namespace std;

int getMax(int a[], int n)
{
    int max = a[0];
    for (int i = 1; i < n; i++)
    {
        if (a[i] > max)
            max = a[i];
    }
    return max; // maximum element from the array
}

void countSort(int a[], int n) // function to perform counting sort
{
    int output[n + 1];
    int max = getMax(a, n);
    int count[max + 1]; // create count array with size [max+1]

    for (int i = 0; i <= max; ++i)
    {
        count[i] = 0; // Initialize count array with all zeros
    }

    for (int i = 0; i < n; i++) // Store the count of each element
    {
        count[a[i]]++;
    }

    for (int i = 1; i <= max; i++)
        count[i] += count[i - 1]; // find cumulative frequency

    /* This loop will find the index of each element of the original array in count array, and
     place the elements in output array*/
    for (int i = n - 1; i >= 0; i--)
    {
        output[count[a[i]] - 1] = a[i];
        count[a[i]]--; // decrease count for same numbers
    }

    for (int i = 0; i < n; i++)
    {
        a[i] = output[i]; // store the sorted elements into main array
    }
}

void printArr(int a[], int n) /* function to print the array */
{
    int i;
    for (i = 0; i < n; i++)
        cout << a[i] << " ";
}

int main()
{
    int a[] = {31, 11, 42, 7, 30, 11};
    int n = sizeof(a) / sizeof(a[0]);
    cout << "Before sorting array elements are - \n";
    printArr(a, n);
    countSort(a, n);
    cout << "\nAfter sorting array elements are - \n";
    printArr(a, n);
    return 0;
}