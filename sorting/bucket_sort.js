Here's an implementation of bucket sort in JavaScript:

function bucketSort(arr, numBuckets = 10) {
  const n = arr.length;
  const buckets = new Array(numBuckets);
  
  // Initialize the buckets
  for (let i = 0; i < numBuckets; i++) {
    buckets[i] = [];
  }
  
  // Distribute the elements into the buckets
  for (let i = 0; i < n; i++) {
    const bucketIndex = Math.floor(arr[i] * numBuckets);
    buckets[bucketIndex].push(arr[i]);
  }
  
  // Sort the elements within each bucket
  for (let i = 0; i < numBuckets; i++) {
    buckets[i].sort((a, b) => a - b);
  }
  
  // Concatenate the sorted buckets
  let sortedArr = [];
  for (let i = 0; i < numBuckets; i++) {
    sortedArr = sortedArr.concat(buckets[i]);
  }
  
  return sortedArr;
}


The bucketSort function takes an array arr of numbers and an optional parameter numBuckets that specifies the number of buckets to use (default is 10).
The algorithm works by distributing the elements of arr into numBuckets buckets based on their value. Each bucket contains elements within a range of values,
and since the buckets are sorted, the elements within each bucket are sorted as well. Finally, the sorted buckets are concatenated to obtain the final sorted
array.

Note that the performance of bucket sort depends on the distribution of the elements in the input array. If the elements are evenly distributed, bucket sort can achieve a time complexity of O(n), which is faster than many other sorting algorithms. However, if the elements are concentrated in a small range of values, the buckets may become unbalanced and the performance may degrade. Therefore, bucket sort is often used as a sub-routine in other sorting algorithms, or when the distribution of the input is known to be relatively even.
