/*
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
Order of elements in the output is not important.
Input Format :

Line 1 : Size of array (n)
Line 2 : Array elements (separated by space)
Line 3 : Integer k

Output Format :

k largest elements

Sample Input :

13
2 12 9 16 10 5 3 20 25 11 1 8 6
4

Sample Output :

12
16
20
25

Explaination :
    The code first defines a function called kLargest(). This function takes three parameters: an array of integers, the size of the array, and the number of largest elements to find. The function uses a priority queue to find the k largest elements in the array.

    The code then defines a main function. The main function prompts the user to enter the size of the array and the number of largest elements to find. The main function then creates an array of integers and prompts the user to enter the elements of the array. The main function then calls the kLargest() function and prints the k largest elements in the array.

    The kLargest() function works as follows:

        The function first creates a priority queue and pushes the first k elements of the array onto the priority queue.
        The function then iterates through the remaining elements of the array. If the current element is greater than the top element of the priority queue, the function pushes the current element onto the priority queue and pops the top element of the priority queue.
        The function then returns a vector of the elements in the priority queue.


*/
#include <iostream>
#include <queue>
using namespace std;

// This function finds the k largest elements in an array.
vector<int> kLargest(int input[], int n, int k)
{

    // Create a priority queue and push the first k elements of the array onto the priority queue.
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < k; i++)
    {
        pq.push(input[i]);
    }

    // Iterate through the remaining elements of the array.
    // If the current element is greater than the top element of the priority queue,
    // push the current element onto the priority queue and pop the top element of the priority queue.
    for (int i = k; i < n; i++)
    {
        if (input[i] > pq.top())
        {
            pq.push(input[i]);
            pq.pop();
        }
    }

    // Return a vector of the elements in the priority queue.
    vector<int> ans;
    while (!pq.empty())
    {
        ans.push_back(pq.top());
        pq.pop();
    }
    return ans;
}

int main()
{

    // Prompt the user to enter the size of the array and the number of largest elements to find.
    int size;
    cin >> size;
    int *input = new int[1 + size];

    // Prompt the user to enter the elements of the array.
    for (int i = 0; i < size; i++)
    {
        cin >> input[i];
    }

    // Prompt the user to enter the number of largest elements to find.
    int k;
    cin >> k;

    // Call the `kLargest()` function and print the k largest elements in the array.
    vector<int> output = kLargest(input, size, k);
    for (int i = 0; i < output.size(); i++)
    {
        cout << output[i] << endl;
    }

    return 0;
}
