/*

Here is a step by step process :
Set up an array of initially empty "buckets".
Scatter: Go over the original array, putting each object in its bucket.
Sort each non-empty bucket.
Gather: Visit the buckets in order and put all elements back into the original array.

Bucket Sort time complexity
Best Case Time Complexity: O(n+k)
Average Case Time Complexity: O(n)
Worst Case Time Complexity: O(n^2^)
Best Case Time Complexity:
If the array elements are uniformly distributed, bucket size will almost be the same for all the buckets. Hence, this will be the best case which will take up the least amount of time.
Sorting time complexity will reduce even further if all the elements inside each bucket are already sorted.
To create n buckets and scatter each element from the array, time complexity = O(n). If we use Insertion sort to sort each bucket, time complexity = O(k). Hence, best case time complexity for bucket sort = O(n+k), where n = number of elements, and k = number of buckets
Worst Case Time Complexity
If the array elements are not uniformly distributed, i.e., elements are concentrated within specific ranges.
This will result in one or more buckets having more elements than other buckets, making bucket sort like any other sorting technique, where every element is compared to the other. Time complexity increases even further if the elements in the array are present in the reverse order. If insertion sort is used, the worst-case time complexity can go up to O(n^2^).


Bucket Sort Space Complexity
Space Complexity : O(n+k)
Space Complexity for bucket sort is O(n+k), where n = number of elements in the array, and k = number of buckets formed Space taken by each bucket is O(k), and inside each bucket, we have n elements scattered. Hence, the space complexity becomes O(n+k).

*/

package util;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

static void bucketSort(int[] arr, int noOfBuckets) {

boolean isNegativePresent = false;
int offset = Integer.MAX_VALUE;
for (int i : arr) {
  if (i < offset) offset = i;
  if (i < 0) isNegativePresent = true;
}

int globalMax = Integer.MIN_VALUE;
int globalMin = Integer.MAX_VALUE;
for (int i = 0; i < arr.length; i++) {
  arr[i] -= offset;
  globalMin = Math.min(arr[i], globalMin);
  globalMax = Math.max(arr[i], globalMax);
}

int range = globalMax - globalMin;
int bucketRange = (int) Math.ceil((double) range / noOfBuckets);

// Create bucket array
List<Integer>[] buckets = new List[noOfBuckets];

// Associate a list with each index in the bucket array
for (int i = 0; i < noOfBuckets; i++) {
  buckets[i] = new LinkedList<>();
}

// Assign numbers from array to the proper bucket
// by using hashing function
for (int num : arr) {
  buckets[hash(num, bucketRange, noOfBuckets)].add(num);
}

// sort buckets
for (List<Integer> bucket : buckets) Collections.sort(bucket);

int idx = 0;
// Merge buckets to get sorted array
for (List<Integer> bucket : buckets) {
  for (int num : bucket) {
    arr[idx++] = num;
  }
}

if (isNegativePresent) {
  for (int i = 0; i < arr.length; i++) {
    arr[i] += offset;
  }
}
}

private static int hash(int num, int hashValue, int numberOfBuckets) {
int bucketNumber = num / hashValue;
if (bucketNumber == numberOfBuckets)
bucketNumber--;
return bucketNumber;
}
}