#include <bits/stdc++.h>

/*
Wave sort, also known as "odd-even sort," is a simple sorting algorithm that works by repeatedly 
comparing and swapping adjacent elements in an array until the array is sorted. 
The algorithm gets its name from the pattern of element swaps, which resembles a wave-like motion.
In this sorting method we arrange array in
Arr[0] >=arr[1]<=arr[2]>=arr[3]<=arr[4]……….   Like a wave
*/

using namespace std;

void wavesort(int arr[], int n)
{
    for (int i = 1; i < n; i += 2)
    {
        if (arr[i] > arr[i - 1])
        {
            swap(arr[i], arr[i - 1]);
        }
        if (arr[i] > arr[i + 1] && i <= n - 2)
        {
            swap(arr[i], arr[i + 1]);
        }
    }
}

int main()
{
    int arr[9] = {1, 3, 4, 7, 5, 6, 2};
    wavesort(arr, 7);
    for (int i = 0; i < 7; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}

/*
Time Complexity: O(N)
Auxiliary Space: O(1)
*/

/*
The idea is based on the fact that if we make sure that all even positioned (at index 0, 2, 4, ..) 
elements are greater than their adjacent odd elements, we don’t need to worry about oddly positioned elements.

- Traverse all even positioned elements of the input array, and do the following.
    - If the current element is smaller than the previous odd element, swap the previous and current.
    - If the current element is smaller than the next odd element, swap next and current.
*/

/*
Dry-Run
Consider the array: [7, 2, 5, 1, 8, 3]

Step 1:

Start with the initial array: [7, 2, 5, 1, 8, 3]
In the first iteration, we compare and swap adjacent elements at even indices (0, 2, 4).
Compare 7 and 2: 7 > 2, so we swap them. Array becomes: [2, 7, 5, 1, 8, 3]
Compare 7 and 8: 7 < 8, so no swap is needed.
After the first phase, the array becomes: [2, 7, 5, 1, 8, 3]
Step 2:

In the second iteration, we compare and swap adjacent elements at odd indices (1, 3, 5).
Compare 7 and 5: 7 > 5, so we swap them. Array becomes: [2, 5, 7, 1, 8, 3]
Compare 7 and 1: 7 > 1, so we swap them. Array becomes: [2, 5, 1, 7, 8, 3]
Compare 7 and 3: 7 > 3, so we swap them. Array becomes: [2, 5, 1, 3, 8, 7]
After the second phase, the array becomes: [2, 5, 1, 3, 8, 7]
Step 3:

In the third iteration, we again compare and swap adjacent elements at even indices (0, 2, 4).
Compare 2 and 5: 2 < 5, so no swap is needed.
Compare 5 and 1: 5 > 1, so we swap them. Array becomes: [1, 5, 2, 3, 8, 7]
Compare 5 and 3: 5 > 3, so we swap them. Array becomes: [1, 3, 2, 5, 8, 7]
After the third phase, the array becomes: [1, 3, 2, 5, 8, 7]
Step 4:

In the fourth iteration, we compare and swap adjacent elements at odd indices (1, 3, 5).
Compare 3 and 2: 3 > 2, so we swap them. Array becomes: [1, 2, 3, 5, 8, 7]
Compare 3 and 5: 3 < 5, so no swap is needed.
Compare 5 and 8: 5 < 8, so no swap is needed.
After the fourth phase, the array remains the same: [1, 2, 3, 5, 8, 7]
Step 5:

In the fifth iteration, we again compare and swap adjacent elements at even indices (0, 2, 4).
Compare 1 and 2: 1 < 2, so no swap is needed.
Compare 2 and 3: 2 < 3, so no swap is needed.
Compare 3 and 5: 3 < 5, so no swap is needed.
After the fifth phase, the array remains the same: [1, 2, 3, 5, 8, 7]
Step 6:

In the sixth iteration, we compare and swap adjacent elements at odd indices (1, 3, 5).
Compare 2 and 3: 2 < 3, so no swap is needed.
Compare 3 and 5: 3 < 5, so no swap is needed.
Compare 5 and 7: 5 < 7, so no swap is needed.
After the sixth phase, the array remains the same: [1, 2, 3, 5, 8, 7]
Since no more swaps occur in the array, the algorithm terminates, and the array is considered sorted.

Final sorted array: [1, 2, 3, 5, 7, 8]
*/