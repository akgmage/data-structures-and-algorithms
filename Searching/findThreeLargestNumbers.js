//! O(n) time | O(1) space
function findThreeLargestNumbers(array) {
    const threeLargest = [null, null, null];
    for(const num of array) {
        updateLargest(threeLargest, num);
    }
    return threeLargest;
}

function updateLargest(threeLargest, num) {
    if (threeLargest[2] == null | num > threeLargest[2]) {
        shiftAndUpdate(threeLargest, num, 2);
    } else if(threeLargest[1] == null || num > threeLargest[1]) {
        shiftAndUpdate(threeLargest, num, 1);
    } else if(threeLargest[0] == null || num > threeLargest[0]) {
        shiftAndUpdate(threeLargest, num, 0);
    }
}

function shiftAndUpdate(array, num, idx) {
    for(let i = 0; i <= idx; i++) {
        if(i == idx) {
            array[idx] = num;
        } else {
            array[i] = array[i + 1];
        }
    }
}


//! O(n) time | O(1) space
function findThreeLargestNumbers(array) {
    let firstLargest = -Infinity;
    let firstLargestIdx;
    let secondLargest = -Infinity;
    let secondLargestIdx;
    let thirdLargest = -Infinity;
    let thirdLargestIdx;
    for (let i = 0; i < array.length; i++) {
        if (array[i] > firstLargest) {
            firstLargestIdx = i;
            firstLargest = array[i];
        }
    }
    swap(firstLargestIdx, 0, array);
    for (let i = 1; i < array.length; i++) {
        if (array[i] > secondLargest) {
            secondLargestIdx = i;
            secondLargest = array[i];
        }
    }
    swap(secondLargestIdx, 1, array);
    for (let i = 2; i < array.length; i++) {
        if (array[i] > thirdLargest) {
            thirdLargestIdx = i;
            thirdLargest = array[i];
        }
    }
    swap(thirdLargestIdx, 2, array);

    swap(0, 2, array);
    return [array[0], array[1], array[2]]

}

function swap(a, b, array) {
    let temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
