#include <bits/stdc++.h>
using namespace std;

void printArr(int arr[], int len) {
    for (int i = 0; i < len; i++) {
        cout << arr[i] << " ";
    }
}

void swap(int *i, int *j) {
    int temp = *i;
    *i = *j;
    *j = temp;
}

int partition(int arr[], int p, int q) {
    int i = p;
    int x = arr[i]; // ! PIVOT
    
    for (int j = p + 1; j <= q; j++) {
        if (arr[j] <= x) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i], &arr[p]);
    return i;
}

int quickSort(int arr[], int p, int q) {
    // if (p >= q) return;
    // else {
    //     int m = partition(arr, p, q);
    //     quickSort(arr, p, m - 1);
    //     quickSort(arr, m + 1, q);
    // }

    //! MODIFIED QUICK SORT

    while (p <= q) {
        if (p == q) return arr[p];
        else {
            int m = partition(arr, p, q);
            if ( (m - p) < (q - m) ) {
                quickSort(arr, p, m - 1);
                p = m + 1;
            } else {
                quickSort(arr, m + 1, q);
                q = m - 1;
           }
        }
    }
}

int main () {

    int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    int len = sizeof(arr)/ sizeof(arr[0]);

    quickSort(arr, 0, len - 1);

    printArr(arr, len);

    return 0;
}