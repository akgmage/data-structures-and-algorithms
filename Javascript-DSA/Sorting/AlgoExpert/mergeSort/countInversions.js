function countInversions(array) {
    return countInversionsHelper(array, 0, array.length - 1);
}
function countInversionsHelper(array, startIdx, endIdx) {
    if(startIdx >= endIdx) return 0;
    let midIdx = Math.floor((startIdx + endIdx) / 2);
    let leftInversions = countInversionsHelper(array, startIdx, midIdx);
    let rightInversions = countInversionsHelper(array, midIdx + 1, endIdx);
    let mergedInversions = mergeAndCountInversions(array, startIdx, midIdx, midIdx + 1, endIdx);
    return leftInversions + rightInversions  + mergedInversions;
}
function mergeAndCountInversions(array, leftStartIdx, leftEndIdx, rightStartIdx, rightEndIdx) {
    let inversions = 0;
    let leftArrLength = leftEndIdx - leftStartIdx + 1;
    let rightArrLength = rightEndIdx - rightStartIdx + 1;

    let arr1 = new Array(leftArrLength);
    let arr2 = new Array(rightArrLength);

    for(let i = 0; i < leftArrLength; i++) {
        arr1[i] = array[leftStartIdx + i];
    }
    for(let i = 0; i < rightArrLength; i++) {
        arr2[i] = array[rightStartIdx + i];
    }

    let i = 0;
    let j = 0;
    let k = leftStartIdx;

    while(i < leftArrLength && j < rightArrLength) {
        if(arr1[i] <= arr2[j]) {
            array[k++] = arr1[i++];
        }else {
            inversions += leftArrLength - i;
            array[k++] = arr2[j++];
        }
    }

    while(i < leftArrLength) {
        array[k++] = arr1[i++];
    }
    while(j < rightArrLength) {
        array[k++] = arr2[j++];
    }
    
    return inversions;
}

let array = [2, 3, 3, 1, 9, 5, 6];

console.log(countInversions(array));
