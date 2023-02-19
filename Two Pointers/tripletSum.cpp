// C++ program to find a triplet sum in array
#include <bits/stdc++.h>
using namespace std;
bool findTriplet(int arr[], int n, int target)
{
    int l, r;
    /* Sort the elements */
    sort(arr, arr + n);
    /* start with the first element */
    for (int i = 0; i < n - 2; i++) {
        l = i + 1; // index of the first element
        r = n - 1; // last element
        while (l < r) {
            if (arr[i] + arr[l] + arr[r] == target) {
                return true;
            }
            else if (arr[i] + arr[l] + arr[r] < target)
                l++;
            else 
            // A[i] + A[l] + A[r] is greater than target
                r--;
        }
    }
    // If no triplet was found
    return false;
}

int main()
{
	int arr[] = { 1, 2, 3, 4, 5, 6};
	int target = 9;
	int n = sizeof(arr) / sizeof(arr[0]);
	cout<<findTriplet(arr, n, target)<<endl;
	return 0;
}