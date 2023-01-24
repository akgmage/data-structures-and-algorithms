#include <iostream>

using namespace std;


int binarySearch(int arr[], int i, int j, int x) {
    int mid;
//! USING DAC
    if (i == j) {
        if (arr[i] == x) {
            return i;
        }
            else {
                return -1;
            }      
    }
    else {
        mid = (i + j ) / 2;
        if (x == arr[mid]) {
                return mid;
        }
        else if (x < arr[mid]) {
            binarySearch(arr, i, mid - 1, x );
        } else {
            binarySearch(arr, mid + 1, j, x);
        }
    }


}
//! using loop 


int binarySearchUsingWhileLoop (int arr[], int i, int j, int x) {
    int mid;
    while (i < j) {
        if (i == j) {
            if (arr[i] == x) {
                return i;
            } else {
                return -1;
            }
        }
        else {
            mid = (i + j) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
    }
}


int main () {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

    int i = 0;
    int j = sizeof(arr) / sizeof(arr[0]);
    int x = 8;

    // cout << binarySearch(arr, i, j, x) << endl;
    cout << binarySearchUsingWhileLoop(arr, i, j, x) << endl;

    return 0;
}