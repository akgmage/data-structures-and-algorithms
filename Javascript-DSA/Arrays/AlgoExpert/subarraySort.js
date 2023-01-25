//? https://www.algoexpert.io/questions/Subarray%20Sort
function subarraySort(array) {
    let minOutOfOrder = Infinity;
    let maxOutOfOrder = -Infinity;
    for(let i = 0; i < array.length; i++) {
        const num = array[i];
        if(isOutOfOrder(i, num, array)) {
            minOutOfOrder = Math.min(minOutOfOrder, num);
            maxOutOfOrder = Math.max(maxOutOfOrder, num);
        }
    }
    if(minOutOfOrder == Infinity) return [-1, -1];
    
    let subArrayLeftIdx = 0;
    while(minOutOfOrder >= array[subArrayLeftIdx]) {
        subArrayLeftIdx++;
    }
    let subArrayRightIdx = array.length - 1;
    while(maxOutOfOrder <= array[subArrayRightIdx]) {
        subArrayRightIdx--;
    }
    return [subArrayLeftIdx, subArrayRightIdx];
}
function isOutOfOrder(i, num, array) {
    if(i == 0) return num > array[i + 1];
    if(i == array.length - 1) return num < array[i - 1];
    return num > array[i + 1] || num < array[i - 1];
}

console.log(subarraySort([1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]));


