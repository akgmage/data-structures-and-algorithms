//! every case O(nlogn) time | O(n) space

function mergeSort(array) {
  mergeSortHelper(array, 0, array.length - 1);
  return array;
}
function mergeSortHelper(array, startIdx, endIdx) {
  if (startIdx == endIdx) return;
  const midIdx = Math.floor(startIdx + (endIdx - startIdx) / 2);
  mergeSortHelper(array, startIdx, midIdx);
  mergeSortHelper(array, midIdx + 1, endIdx);
  doMerge(array, startIdx, midIdx, midIdx + 1, endIdx);
}
function doMerge(array, leftStartIdx, leftEndIdx, rightStartIdx, rightEndIdx) {
  let leftSubArrLen = leftEndIdx - leftStartIdx + 1;
  let rightSubArrLen = rightEndIdx - rightStartIdx + 1;

  let leftSubArr = new Array(leftSubArrLen);
  let rightSubArr = new Array(rightSubArrLen);

  for (let i = 0; i < leftSubArrLen; i++)
    leftSubArr[i] = array[leftStartIdx + i];

  for (let i = 0; i < rightSubArrLen; i++)
    rightSubArr[i] = array[rightStartIdx + i];

  let i = 0;
  let j = 0;
  let k = leftStartIdx;

  while (i < leftSubArrLen && j < rightSubArrLen) {
    if (leftSubArr[i] < rightSubArr[j]) array[k++] = leftSubArr[i++];
    else array[k++] = rightSubArr[j++];
  }
  while (i < leftSubArrLen) array[k++] = leftSubArr[i++];
  while (j < rightSubArrLen) array[k++] = rightSubArr[j++];
  return;
}

let array = [
  2, -2, -6, -10, 10, 4, -8, -1, -8, -4, 7, -4, 0, 9, -9, 0, -9, -9, 8, 1, -4,
  4, 8, 5, 1, 5, 0, 0, 2, -10,
];

console.log(mergeSort(array));
