/*
You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
Input Format :

The first line of input contains an integer 'N', denoting the number of integers in the stream.

The second line of input contains 'N' integers separated by a single space.

Output Format :

Print the running median for every integer added to the running list in one line (space-separated).

Input Constraints

0 <= N <= 10 ^ 5
1 <= ARR[i] <= 10 ^ 5

Time Limit: 1 sec

Sample Input 1 :

6
6 2 1 3 7 5

Sample Output 1 :

6 4 2 2 3 4

Explanation of Sample Output 1 :

S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4

Sample Input 2 :

5
5 4 3 2 1

Sample Output 2 :

5 4 4 3 3

Explaination :

    The code aims to efficiently find and print the median of a stream of integers as they are read one by one. It achieves this by using two priority queues: `min` and `max`. These priority queues divide the elements encountered so far into the lower and higher halves, allowing for the calculation of the median.

    When reading the integers one by one, the code follows these steps:

    1. For the first element, it is pushed into the `max` priority queue. At this point, the median is simply the first element.

    2. For subsequent elements, the code compares each element with the current median (which is the top element of the `max` priority queue). If the new element is smaller, it is pushed into the `max` priority queue. This ensures that the lower half of the elements is stored in `max`, with the maximum element of the lower half at the top.

    3. If the new element is larger than the current median, it is pushed into the `min` priority queue. This ensures that the higher half of the elements is stored in `min`, with the minimum element of the higher half at the top.

    4. After each insertion, the code checks the size difference between the `min` and `max` priority queues. If the difference exceeds 1, it rebalances the queues by transferring the top element from the larger queue to the smaller one. This ensures that the size difference between the two halves remains at most 1, allowing for accurate median calculations.

    5. To calculate and print the median, the code checks the total number of elements (c) in both priority queues. If c is even, the median is the average of the top elements of `min` and `max`. If c is odd, the median is the top element of the priority queue with more elements.

    By using two priority queues to maintain the lower and higher halves of the elements encountered so far, the code efficiently updates and calculates the median of the stream of integers in a scalable manner. The rebalancing step ensures that the size difference between the two halves remains at most 1, allowing for accurate median calculations even as new elements are added to the stream.

*/
#include <iostream>
#include <queue>
using namespace std;

void findMedian(int *arr, int n)
{
    priority_queue<int, vector<int>, greater<int>> min; // Min-heap to store the higher half of the elements encountered
    priority_queue<int> max;                            // Max-heap to store the lower half of the elements encountered

    for (int i = 0; i < n; i++)
    {
        if (i == 0)
        {
            max.push(arr[i]); // For the first element, push it into the max heap
        }
        else
        {
            if (max.top() > arr[i])
            {
                max.push(arr[i]); // If the new element is smaller than the current median, push it into the max heap
            }
            else
            {
                min.push(arr[i]); // If the new element is larger than the current median, push it into the min heap
            }
        }

        if (int(min.size() - max.size()) > 1)
        {
            int temp = min.top();
            min.pop();
            max.push(temp); // Rebalance the heaps by transferring the top element from min heap to max heap
        }
        else if (int(max.size() - min.size()) > 1)
        {
            int temp = max.top();
            max.pop();
            min.push(temp); // Rebalance the heaps by transferring the top element from max heap to min heap
        }

        int c = max.size() + min.size(); // Total count of elements

        if (c % 2 == 0)
        {
            cout << (min.top() + max.top()) / 2 << " "; // If total count is even, median is the average of the top elements of both heaps
        }
        else
        {
            if (min.size() > max.size())
            {
                cout << min.top() << " "; // If total count is odd and min heap has more elements, median is the top element of min heap
            }
            else
            {
                cout << max.top() << " "; // If total count is odd and max heap has more elements, median is the top element of max heap
            }
        }
    }

    cout << endl;
}

int main()
{
    int n;
    cin >> n; // Number of elements

    int *arr = new int[n]; // Dynamically allocate memory for the array

    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i]; // Read the elements of the array
    }

    findMedian(arr, n); // Find and print the median of the stream

    delete[] arr; // Deallocate the memory

    return 0;
}
