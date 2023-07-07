/*
Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).
Input Format:

The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.

Output Format :

The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.

Constraints :

1 <= n <= 10^6
Time Limit: 1 sec

Sample Input 1:

6
2 6 8 5 4 3

Sample Output 1:

8 6 5 4 3 2

Explaination :
    The code implements the heap sort algorithm, which is a sorting algorithm that works by first building a max heap. A max heap is a binary tree where the value of each parent node is greater than or equal to the value of each of its child nodes.

    The heap sort algorithm works by repeatedly swapping the root element of the heap with the last element of the array and then rebuilding the heap without the root element. This process is repeated until the array is sorted.

    The code first defines a function called heapSort(). This function takes two parameters: an array of integers and the size of the array. The function builds a max heap from the bottom up and then sorts the array by repeatedly swapping the root element with the last element and rebuilding the heap.

    The main function of the code prompts the user to enter the size of the array and then prompts the user to enter the elements of the array. The main function then calls the heapSort() function and prints the sorted array.

    The intuition behind the heap sort algorithm is that it takes advantage of the fact that a max heap is already partially sorted. By repeatedly swapping the root element with the last element of the array and rebuilding the heap, the algorithm is able to sort the array in a relatively efficient way.

    The heap sort algorithm is a divide-and-conquer algorithm, which means that it breaks the problem of sorting an array into smaller and smaller subproblems until they are trivial to solve. This makes the algorithm very efficient for sorting large arrays.
*/
#include <iostream>

using namespace std;

void heapSort(int arr[], int n)
{
    // This function sorts an array using the heap sort algorithm.
    // The algorithm works by first building a max heap.
    // Then, the root of the heap is swapped with the last element of the array.
    // The heap is then rebuilt without the root element.
    // This process is repeated until the array is sorted.

    for (int i = 1; i < n; i++)
    {
        // Recursively build a max heap from the bottom up.
        int childIndex = i;
        while (childIndex > 0)
        {
            int parentIndex = (childIndex - 1) / 2;
            if (arr[childIndex] < arr[parentIndex])
            {
                // Swap the child and parent.
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
            }
            else
            {
                // The heap is already a max heap.
                break;
            }
            childIndex = parentIndex;
        }
    }

    // Sort the array by repeatedly swapping the root element with the last element and rebuilding the heap.
    int j = n;
    while (j > 1)
    {
        // Swap the root element with the last element.
        int temp = arr[0];
        arr[0] = arr[j - 1];
        arr[j - 1] = temp;
        j--;

        // Rebuild the heap without the root element.
        int parentIndex = 0;
        int rightChildIndex = 2 * parentIndex + 2;
        int leftChildIndex = 2 * parentIndex + 1;
        while (leftChildIndex < j)
        {
            // Find the minimum child.
            int minIndex = parentIndex;
            if (arr[leftChildIndex] < arr[minIndex])
            {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < j && arr[rightChildIndex] < arr[minIndex])
            {
                minIndex = rightChildIndex;
            }

            // Swap the minimum child with the parent.
            int temp = arr[minIndex];
            arr[minIndex] = arr[parentIndex];
            arr[parentIndex] = temp;

            if (parentIndex == minIndex)
            {
                // The heap is already a max heap.
                break;
            }
            parentIndex = minIndex;
            rightChildIndex = 2 * parentIndex + 2;
            leftChildIndex = 2 * parentIndex + 1;
        }
    }
}

int main()
{
    int size;
    cin >> size;

    int *input = new int[size];

    for (int i = 0; i < size; i++)
    {
        cin >> input[i];
    }

    heapSort(input, size);

    for (int i = 0; i < size; i++)
    {
        cout << input[i] << " ";
    }

    delete[] input;
}
