/*
Given k different arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).
Hint : Use Heaps.
Input Format:

The first line of input contains an integer, that denotes value of k.
The following lines of input represent k sorted arrays. Each sorted array uses two lines of input. The first line contains an integer, that denotes the size of the array. The following line contains elements of the array.

Output Format:

The first and only line of output contains space separated elements of the merged and sorted array, as described in the task.

Constraints:

0 <= k <= 1000
0 <= n1, n2 <= 10000
Time Limit: 1 second

Sample Input 1:

4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0

Sample Output 1:

0 1 2 5 6 9 45 78 90 100 234

Explaination :
    The intuition behind the code is to use a min-heap (priority queue) to merge K sorted arrays efficiently.

    By taking the first element from each array and inserting it into the priority queue, the smallest element is always at the top. This ensures that when elements are extracted from the priority queue, they are in sorted order.

    The code iteratively extracts the smallest element from the priority queue, adds it to the merged sorted array, and checks if there are remaining elements in the array from which the extracted element came. If so, the next element from that array is inserted into the priority queue.

    This process continues until all elements from all arrays are processed and added to the merged sorted array.

    By utilizing the min-heap property of the priority queue, the code efficiently merges the sorted arrays in a way that the overall time complexity is optimized. The priority queue allows for easy retrieval of the smallest element, resulting in an overall time complexity of O(N log K), where N is the total number of elements across all arrays and K is the number of arrays.
*/
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> mergeKSortedArrays(vector<vector<int> *> input)
{
    // Create a min-heap priority queue to store elements from different arrays
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;

    // Insert the first element from each array into the priority queue
    for (int i = 0; i < input.size(); i++)
    {
        pair<int, pair<int, int>> p;
        p.first = input[i]->at(0); // value of the element
        p.second.first = i;        // array number
        p.second.second = 0;       // index of the element
        pq.push(p);
    }

    // Initialize a vector to store the merged sorted array
    vector<int> ans;

    // Process the priority queue until it becomes empty
    while (!pq.empty())
    {
        pair<int, pair<int, int>> p = pq.top();
        pq.pop();

        // Add the minimum element to the result vector
        ans.push_back(p.first);

        int arrNo = p.second.first;      // array number
        int index = p.second.second + 1; // index of the next element in the array

        // If there are still elements remaining in the array, add the next element to the priority queue
        if (index < input[arrNo]->size())
        {
            p.first = input[arrNo]->at(index); // value of the element
            p.second.second = index;           // update the index
            pq.push(p);
        }
    }

    // Return the merged sorted array
    return ans;
}

int main()
{
    int k;
    cin >> k; // Number of sorted arrays

    vector<vector<int> *> input; // Vector to store the arrays

    // Read the size and elements of each array
    for (int j = 1; j <= k; j++)
    {
        int size;
        cin >> size; // Size of the array

        // Create a dynamically allocated vector for the current array
        vector<int> *current = new vector<int>;

        // Read the elements of the array
        for (int i = 0; i < size; i++)
        {
            int a;
            cin >> a;              // Element of the array
            current->push_back(a); // Add the element to the current array
        }

        // Add the current array to the vector of arrays
        input.push_back(current);
    }

    // Merge the sorted arrays using the mergeKSortedArrays function
    vector<int> output = mergeKSortedArrays(input);

    // Print the merged sorted array
    for (int i = 0; i < output.size(); i++)
    {
        cout << output[i] << " ";
    }

    return 0;
}
