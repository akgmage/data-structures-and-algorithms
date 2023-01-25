function mergeSort(array) {
    mergeSortHelper(array, 0, array.length - 1);
    return array;
}

function mergeSortHelper(array, startIdx, endIdx) {
    if(startIdx == endIdx) return;
    const midIdx = Math.floor((startIdx + endIdx) / 2);
    mergeSortHelper(array, startIdx, midIdx);
    mergeSortHelper(array, midIdx + 1, endIdx);
    doMerge(array, startIdx, midIdx, midIdx + 1, endIdx);
}

function doMerge(array, leftStartIdx, leftEndIdx, rightStartIdx, rightEndIdx) {
    let leftLength = leftEndIdx - leftStartIdx;
    let rightLength = rightEndIdx - rightStartIdx;

    let arr1 = new Array(leftLength);
    let arr2 = new Array(rightLength);

    for(let i = 0; i <= leftLength; i++) {
        arr1[i] = array[leftStartIdx + i];
    }

    for(let i = 0; i <= rightLength; i++) {
        arr2[i] = array[rightStartIdx + i];
    }

    let i = 0;
    let j = 0;
    let k = leftStartIdx;

    while(i < arr1.length && j < arr2.length) {
        if(arr1[i] < arr2[j]) {
            array[k++] = arr1[i++];
        } else {
            array[k++] = arr2[j++];
        }
    }

    while(i < arr1.length) {
        array[k++] = arr1[i++];
    }

    while(j < arr2.length) {
        array[k++] = arr2[j++];
    }
}