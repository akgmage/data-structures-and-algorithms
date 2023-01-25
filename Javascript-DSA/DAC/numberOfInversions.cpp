#include "bits/stdc++.h"
using namespace std;

int merge(int arr[], int start, int mid, int end)
{
    int inversions = 0;
    int l = 0;
    int len = sizeof(arr) / sizeof(arr[0]);

    int leftSubArraySize = mid - start + 1;
    int rightSubArraySize = end - mid;

    int leftSubArray[leftSubArraySize];
    int rightSubArray[rightSubArraySize];

    for (int i = 0; i < leftSubArraySize; i++)
    {
        leftSubArray[i] = arr[i + start + i];
    }
    for (int i = 0; i < rightSubArraySize; i++)
    {
        rightSubArray[i] = arr[i + mid + i];
    }

    int i = 0;
    int j = 0;
    int k = start;
    // int b[len];

    while ((i < leftSubArraySize) && (j < rightSubArraySize))
    {
        if (leftSubArray[i] < rightSubArray[j])
        {
            arr[k++] = leftSubArray[i++];
        }
        else
        {
            arr[k++] = rightSubArray[j++];
            inversions += leftSubArraySize - i;
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
    return inversions;
}
int mergeSort(int arr[], int i, int j)
{ 
    if (i == j) return 0;
         int mid = (i + j) / 2;
         int leftInversions = mergeSort(arr, i, mid);
         int rightInversions = mergeSort(arr, mid + 1, j);
         int mergedInversions = merge(arr, i, mid, j);

    return leftInversions + rightInversions + mergedInversions;
}
int main()
{

    int arr[] ={50, 40, 20, 5, 19, 90, 23, 16};
    cout << mergeSort(arr, 0, 8);
    return 0;
}
