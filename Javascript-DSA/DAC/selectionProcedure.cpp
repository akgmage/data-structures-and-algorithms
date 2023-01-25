#include <bits/stdc++.h>

using namespace std;

void swap(int *i, int *j)
{
    int temp = *i;
    *i = *j;
    *j = temp;
}
int partition(int arr[], int p, int q)
{
    int i = p;
    int x = arr[i]; // ! PIVOT

    for (int j = p + 1; j <= q; j++)
    {
        if (arr[j] <= x)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i], &arr[p]);
    return i;
}
int selectionProcedure(int arr[], int p, int q, int k) {
    if (p == q) return arr[p];
    else
    {
        int m = partition(arr, p, q);
        if (m == k) return arr[k];
        else {
            if (k < m)
            selectionProcedure(arr, p, m - 1, q);
        else
        {
            selectionProcedure(arr, m + 1, q, k);
        }
    }
 }
}

int main ()  {
    
    int arr[] = { 50, 25, 85, 45, 30, 62, 88, 98, 110, 15, 29, 69 };

    int q = sizeof(arr) / sizeof(arr[0]);
    int p = 0;
    int k = 4;
    cout << selectionProcedure(arr, p, q, k);

    return 0;
} 