#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& arr, int start, int mid, int end) {
    vector<int> temp(end - start + 1);
    int i = start, j = mid + 1, k = 0;

    while (i <= mid && j <= end) {
        if (arr[i] <= arr[j]) {
            temp[k] = arr[i];
            ++i;
        } else {
            temp[k] = arr[j];
            ++j;
        }
        ++k;
    }

    while (i <= mid) {
        temp[k] = arr[i];
        ++i;
        ++k;
    }

    while (j <= end) {
        temp[k] = arr[j];
        ++j;
        ++k;
    }

    for (int l = start; l <= end; ++l) {
        arr[l] = temp[l - start];
    }
}

void merge_sort(vector<int>& arr, int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        merge_sort(arr, start, mid);
        merge_sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}