/*The code implements the bucket sort algorithm in C++. It defines a bucketSort function that takes a vector of integers as input and sorts it using the bucket sort technique. The algorithm distributes the elements into separate buckets based on their values, sorts each bucket individually, and then concatenates the sorted buckets to obtain the final sorted array.*/
/*Time Complexity: O(n + k) for best case and average case and O(n^2) for the worst case.
The space complexity of bucket sort is O(n + k)*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void bucketSort(vector<int>& arr) {
    // Find the maximum value in the array to determine the range of buckets
    int max_value = *max_element(arr.begin(), arr.end());

    // Calculate the number of buckets needed
    int num_buckets = max_value + 1;

    // Create empty buckets
    vector<vector<int>> buckets(num_buckets);

    // Distribute the elements into buckets
    for (int num : arr) {
        buckets[num].push_back(num);
    }

    // Sort each bucket individually
    for (auto& bucket : buckets) {
        sort(bucket.begin(), bucket.end());
    }

    // Concatenate the sorted buckets to get the sorted array
    int index = 0;
    for (const auto& bucket : buckets) {
        for (int num : bucket) {
            arr[index++] = num;
        }
    }
}

int main() {
    // Create an array of integers
    vector<int> array = {5, 3, 9, 1, 8, 2, 7, 4, 6};

    // Sort the array using bucket sort
    bucketSort(array);

    // Print the sorted array
    for (int num : array) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
