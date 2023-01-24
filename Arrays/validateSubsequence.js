//! https://www.algoexpert.io/questions/Validate%20Subsequence
//! O(n) time | O(1) space
function isValidSubsequence(array, sequence) {
  let seqIdx = 0;
  for(const value of array) {
    if(seqIdx == sequence.length) break;
    if(sequence[seqIdx] == value) seqIdx++;
  } return seqIdx == sequence.length;
}
//! O(n) time | O(1) space
function isValidSubsequence(array, sequence) {
  let arrIdx = 0;
  let seqIdx = 0;
  while(arrIdx < array.length && seqIdx < sequence.length) {
       if(array[arrIdx] == sequence[seqIdx]) seqIdx++;
       arrIdx++;
  }
  return seqIdx == sequence.length;
}

let array = [5, 1, 22, 25, 6, -1, 8, 10];
let sequence = [1, 6, -1, 10];

console.log(isValidSubsequence(array, sequence));