#include <bits/stdc++.h>

using namespace std;

void merge(int arr[], int start, int mid, int end)
{
    int leftSubArraySize = mid - start + 1;
    int rightSubArraySize = end - (mid + 1) + 1;

    int leftSubArray[leftSubArraySize];
    int rightSubArray[rightSubArraySize];

    for (int i = 0; i < leftSubArraySize; i++)
    {
        leftSubArray[i] = arr[i + start];
    }
    for (int i = 0; i < rightSubArraySize; i++)
    {
        rightSubArray[i] = arr[i + mid + 1];
    }

    int i = 0;
    int j = 0;
    int k = start;

    while ((i < leftSubArraySize) && (j < rightSubArraySize))
    {
        if (leftSubArray[i] < rightSubArray[j])
        {
            arr[k++] = leftSubArray[i++];
        }
        else
        {
            arr[k++] = rightSubArray[j++];
        }
    }
    while (i < leftSubArraySize)
    {
        arr[k++] = leftSubArray[i++];
    }
    while (j < rightSubArraySize)
    {
        arr[k++] = rightSubArray[j++];
    }
}
int mergeSort(int arr[], int i, int j)
{
    if (i == j)
        return arr[i];

    else
    {
        int mid = (i + j) / 2;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }
}

int main () {

    int arr[] = {50, 60, 70, 80, 10, 12, 13, 8, 3, 2, 1, 0};

    int len = sizeof(arr) / sizeof(arr[0]);

    mergeSort(arr, 0, 12);

    for ( int i = 0; i < 12; i++ ) {
        cout << arr[i] << " ";
    }

    return 0;
}