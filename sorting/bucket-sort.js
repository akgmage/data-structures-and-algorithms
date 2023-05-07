function bucketSort(arr, bucketSize = 5) {
    if (arr.length === 0) {
        return arr;
    }

    // Determine minimum and maximum values in the array
    let minValue = arr[0];
    let maxValue = arr[0];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] < minValue) {
            minValue = arr[i];
        } else if (arr[i] > maxValue) {
            maxValue = arr[i];
        }
    }

    // Determine number of buckets needed and initialize empty buckets
    const bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;
    const buckets = new Array(bucketCount);
    for (let i = 0; i < bucketCount; i++) {
        buckets[i] = [];
    }

    // Assign array elements to buckets based on their value
    for (let i = 0; i < arr.length; i++) {
        const bucketIndex = Math.floor((arr[i] - minValue) / bucketSize);
        buckets[bucketIndex].push(arr[i]);
    }

    // Sort each bucket using another sorting algorithm (here, insertion sort)
    const sortedArray = [];
    for (let i = 0; i < buckets.length; i++) {
        const bucket = buckets[i];
        insertionSort(bucket);
        sortedArray.push(...bucket);
    }

    return sortedArray;
}

function insertionSort(arr) {
    for (let i = 1; i < arr.length; i++) {
        const currentValue = arr[i];
        let j = i - 1;
        while (j >= 0 && arr[j] > currentValue) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = currentValue;
    }
}
