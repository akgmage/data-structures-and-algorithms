/*
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
Input Format:

The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.

Output Format :

The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.

Constraints:

1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec

Sample Input 1:

8
42 20 18 6 14 11 9 4

Sample Output 1:

true

Explaination :
    The code first defines a function called isMaxHeap(). This function takes two parameters: an array of integers and the size of the array. The function recursively checks if the array is a max heap. A max heap is a binary tree where the value of each parent node is greater than or equal to the value of each of its child nodes.

    The function starts by checking the last element of the array. If the parent of the last element is smaller than the last element, the function returns false. Otherwise, the function recursively checks the parent of the last element. This process continues until the function reaches the root of the tree.

    If the function reaches the root of the tree and all of the parent nodes are greater than or equal to their child nodes, the function returns true. Otherwise, the function returns false.

    The main function of the code prompts the user to enter the size of the array and then prompts the user to enter the elements of the array. The main function then calls the isMaxHeap() function and prints the result.

*/

#include <iostream>
using namespace std;

bool isMaxHeap(int arr[], int n)
{

    // This function recursively checks if the array is a max heap.
    // The function starts at the last element of the array and checks if the parent is smaller than the child.
    // If the parent is smaller than the child, the function returns false.
    // Otherwise, the function recursively checks the parent of the child.

    int childIndex = n - 1;
    while (childIndex >= 0)
    {
        int parentIndex = (childIndex - 1) / 2;
        // Check if the parent is smaller than the child.
        if (arr[parentIndex] < arr[childIndex])
        {
            return false;
        }
        // Recursively check the parent of the child.
        childIndex--;
    }
    // The array is a max heap.
    return true;
}

int main()
{

    // Prompt the user to enter the size of the array.
    int n;
    cin >> n;

    // Create an array and prompt the user to enter the elements of the array.
    int *arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    // Check if the array is a max heap.
    cout << (isMaxHeap(arr, n) ? "true\n" : "false\n");

    // Delete the array.
    delete[] arr;
}
