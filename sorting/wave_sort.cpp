#include <bits/stdc++.h>

/*
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