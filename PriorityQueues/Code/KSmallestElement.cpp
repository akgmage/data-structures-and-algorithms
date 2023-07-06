/*
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(n * logk) and space complexity should not be more than O(k).
Note: Order of elements in the output is not important.
Input Format :

The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of k.

Output Format :

The first and only line of output print k smallest elements. The elements in the output are separated by a single space.

Constraints:

Time Limit: 1 sec

Sample Input 1 :

13
2 12 9 16 10 5 3 20 25 11 1 8 6
4

Sample Output 1 :

1 2 3 5

Explaination :

    The code first defines a function called kSmallest(). This function takes three parameters: an array of integers, the size of the array, and the number of smallest elements to find. The function uses a priority queue to find the k smallest elements in the array.

    The code then defines a main function. The main function prompts the user to enter the size of the array and the number of smallest elements to find. The main function then creates an array of integers and prompts the user to enter the elements of the array. The main function then calls the kSmallest() function and prints the k smallest elements in the array.

    The kSmallest() function works as follows:

        The function first creates a priority queue and pushes the first k elements of the array onto the priority queue.
        The function then iterates through the remaining elements of the array. If the current element is less than the top element of the priority queue, the function pushes the current element onto the priority queue and pops the top element of the priority queue.
        The function then returns a vector of the elements in the priority queue.


*/
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

// This function finds the k smallest elements in an array.
vector<int> kSmallest(int arr[], int n, int k)
{

    // Create a priority queue and push the first k elements of the array onto the priority queue.
    priority_queue<int> pq;
    for (int i = 0; i < k; i++)
    {
        pq.push(arr[i]);
    }

    // Iterate through the remaining elements of the array.
    // If the current element is less than the top element of the priority queue,
    // push the current element onto the priority queue and pop the top element of the priority queue.
    for (int i = k; i < n; i++)
    {
        if (arr[i] < pq.top())
        {
            pq.push(arr[i]);
            pq.pop();
        }
    }

    // Return a vector of the elements in the priority queue.
    vector<int> vec;
    while (!pq.empty())
    {
        vec.push_back(pq.top());
        pq.pop();
    }
    return vec;
}

// This is the main function.
int main()
{

    // Prompt the user to enter the size of the array and the number of smallest elements to find.
    int size;
    cin >> size;

    // Create an array of integers.
    int *input = new int[size];

    // Prompt the user to enter the elements of the array.
    for (int i = 0; i < size; i++)
    {
        cin >> input[i];
    }

    // Prompt the user to enter the number of smallest elements to find.
    int k;
    cin >> k;

    // Call the `kSmallest()` function and print the k smallest elements in the array.
    vector<int> output = kSmallest(input, size, k);

    // Sort the output vector in ascending order.
    sort(output.begin(), output.end());

    // Print the output vector.
    for (int i = 0; i < output.size(); i++)
    {
        cout << output[i] << " ";
    }

    // Delete the array.
    delete[] input;
    return 0;
}
