/*
Given an array A of random integers and an integer k, find and return the kth largest element in the array.
Note: Try to do this question in less than O(N * logN) time.
Input Format :

The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following contains an integer, that denotes the value of k.

Output Format :

The first and only line of output contains the kth largest element

Constraints :

1 <= N, Ai, k <= 10^5
Time Limit: 1 sec

Sample Input 1 :

6
9 4 8 7 11 3
2

Sample Output 1 :

9

Sample Input 2 :

8
2 6 10 11 13 4 1 20
4

Sample Output 2 :

10

Explaination :
    The code uses a min-heap priority queue (pq) to find the kth largest element in the given array. It initializes the priority queue with the first k elements of the array. Then, it iterates over the remaining elements of the array and compares each element with the smallest element (top) of the priority queue. If the current element is larger, it replaces the smallest element in the priority queue. Finally, it returns the top element of the priority queue, which will be the kth largest element.

    Note: The code dynamically allocates memory for the array using new and deallocates it using delete[] to ensure proper memory management.

*/
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// Function to find the kth largest element in an array
int kthLargest(int *arr, int n, int k)
{
    // Create a min-heap priority queue
    priority_queue<int, vector<int>, greater<int>> pq;

    // Insert the first k elements into the priority queue
    for (int i = 0; i < k; i++)
    {
        pq.push(arr[i]);
    }

    // Iterate over the remaining elements in the array
    for (int i = k; i < n; i++)
    {
        // If the current element is greater than the smallest element in the priority queue (top),
        // replace the smallest element with the current element
        if (arr[i] > pq.top())
        {
            pq.push(arr[i]);
            pq.pop();
        }
    }

    // The top element of the priority queue will be the kth largest element
    return pq.top();
}

int main()
{
    int n;
    cin >> n;

    // Dynamically allocate memory for the array
    int *arr = new int[n];

    // Read the elements of the array from the user
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    int k;
    cin >> k;

    // Call the kthLargest function to find the kth largest element
    cout << kthLargest(arr, n, k);

    // Deallocate the memory for the array
    delete[] arr;
}
