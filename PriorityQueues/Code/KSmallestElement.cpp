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

*/
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<int> kSmallest(int arr[], int n, int k)
{
    priority_queue<int> pq;
    for (int i = 0; i < k; i++)
    {
        pq.push(arr[i]);
    }
    for (int i = k; i < n; i++)
    {
        if (arr[i] < pq.top())
        {
            pq.push(arr[i]);
            pq.pop();
        }
    }
    vector<int> vec;
    while (!pq.empty())
    {
        vec.push_back(pq.top());
        pq.pop();
    }
    return vec;
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

    int k;
    cin >> k;

    vector<int> output = kSmallest(input, size, k);
    sort(output.begin(), output.end());

    for (int i = 0; i < output.size(); i++)
    {
        cout << output[i] << " ";
    }

    delete[] input;
}