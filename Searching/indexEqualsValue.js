function indexEqualsValue(array) {
    return indexEqualsValueHelper(array, 0, array.length - 1);
}

//! O(n) time | O(1) space
function indexEqualsValueHelper(array, leftIndex, rightIndex) {
    while(leftIndex <= rightIndex) {
        const middleIndex = rightIndex + Math.floor( (rightIndex - leftIndex) / 2 );
        const middleValue = array[middleIndex];
        if(middleValue < middleIndex) {
            leftIndex = middleIndex + 1;
        } else if(middleValue == middleIndex && middleIndex == 0) {
        return middleIndex;
        } else if(middleValue == middleIndex && array[middleIndex - 1] < middleValue - 1) {
        return middleIndex;
         } else {
            rightIndex = middleIndex - 1;
        }
    }
    return -1;
}
//! O(logn) time | O(logn) space
function indexEqualsValueHelper(array, leftIndex, rightIndex) {
    if(leftIndex > rightIndex) return -1;

    const middleIndex = rightIndex + Math.floor( (rightIndex - leftIndex) / 2 );
    const middleValue = array[middleIndex];

    if(middleValue < middleIndex) {
        return indexEqualsValueHelper(array, middleIndex + 1, rightIndex);
    } else if(middleValue == middleIndex && middleIndex == 0) {
        return middleIndex;
    } else if(middleValue == middleIndex && array[middleIndex - 1] < middleValue - 1) {
        return middleIndex;
    } else {
        return indexEqualsValueHelper(array, leftIndex, middleIndex - 1);
    }
}

//! O(n) time | O(1) space
function indexEqualsValue(array) {

    for(let i = 0; i < array.length; i++) {
        const value = array[i];
        if(i == value) return i;
    }
    return -1;
}