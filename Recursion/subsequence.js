// O(2**N * N) time | O(N) space

function subsequence(i, n, array, sequence) {
  if (i === n) {
    if (sequence.length == 0) {
      console.log("{}");
    } else console.log(sequence);
    return;
  }

  //take or pick the particular index into the subsequence.
  sequence.push(array[i]);
  subsequence(i + 1, n, array, sequence);
  sequence.pop();

  //Do not take or do not pick the particular index into the subsequence.
  subsequence(i + 1, n, array, sequence);
}

const array = [3, 1, 2];

// subsequence(0, array.length, array, []);


//! Reverse order

function subsequenceReverse(i, n, array, sequence) {
  if (i === n) {
    if (sequence.length == 0) {
      console.log("{}");
    } else console.log(sequence);
    return;
  }

  //Do not take or do not pick the particular index into the subsequence.
  subsequenceReverse(i + 1, n, array, sequence);

  //take or pick the particular index into the subsequence.
  sequence.push(array[i]);
  subsequenceReverse(i + 1, n, array, sequence);
  sequence.pop();
}




subsequenceReverse(0, array.length, array, []);