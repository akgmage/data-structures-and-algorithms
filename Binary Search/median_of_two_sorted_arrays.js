/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

  The overall run time complexity should be O(log (m+n)).

  Example 1:
  Input: nums1 = [1,3], nums2 = [2]
  Output: 2.00000
  Explanation: merged array = [1,2,3] and median is 2.

  Example 2:
  Input: nums1 = [1,2], nums2 = [3,4]
  Output: 2.50000
  Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
  
  Constraints:
  nums1.length == m
  nums2.length == n
  0 <= m <= 1000
  0 <= n <= 1000
  1 <= m + n <= 2000
  -106 <= nums1[i], nums2[i] <= 106
*/

// Approach 1: Brute force
function findMedianSortedArrays(arr1, arr2) {
  const merged = arr1.concat(arr2).sort((a, b) => a - b);
  const n = merged.length;
  if (n % 2 === 0) {
    const middle = n / 2;
    return (merged[middle - 1] + merged[middle]) / 2;
  } else {
    const middle = Math.floor(n / 2);
    return merged[middle];
  }
}

// Approach 2:  Binary Search
function findMedianSortedArrays(arr1, arr2) {
  // If arr1 is longer than arr2, swap them to ensure arr1 is shorter
  if (arr1.length > arr2.length) {
    [arr1, arr2] = [arr2, arr1];
  }

  const m = arr1.length;
  const n = arr2.length;
  let left = 0;
  let right = m;

  while (left <= right) {
    // Partition arr1 and arr2
    const partition1 = Math.floor((left + right) / 2);
    const partition2 = Math.floor((m + n + 1) / 2) - partition1;

    // Calculate the max and min elements of the left and right partitions
    const maxLeft1 = partition1 === 0 ? -Infinity : arr1[partition1 - 1];
    const minRight1 = partition1 === m ? Infinity : arr1[partition1];
    const maxLeft2 = partition2 === 0 ? -Infinity : arr2[partition2 - 1];
    const minRight2 = partition2 === n ? Infinity : arr2[partition2];

    // If the partitions are correctly balanced, return the median
    if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
      if ((m + n) % 2 === 0) {
        return (
          (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2
        );
      } else {
        return Math.max(maxLeft1, maxLeft2);
      }
    } else if (maxLeft1 > minRight2) {
      // If maxLeft1 is too big, move partition1 to the left
      right = partition1 - 1;
    } else {
      // If maxLeft2 is too big, move partition1 to the right
      left = partition1 + 1;
    }
  }
}
