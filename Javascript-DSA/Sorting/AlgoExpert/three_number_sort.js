// ! O(n) time | O(1) space
function three_number_sort(array, order) {
    let firstValue = array[0];
    let secondValue = array[1];

    let firstIdx = 0;
    let secondIdx = 0;
    let thirdIdx = array.length - 1;

    while(secondIdx <= thirdIdx) {
        const value = array[secondIdx];
        if(value == firstValue) {
            swap(firstIdx, secondIdx, array);
            firstIdx++;
            secondIdx++;
        } else if(value == secondValue) {
            secondIdx++;
        } else {
            swap(secondIdx, thirdIdx, array);
            thirdIdx--;
        }
    }
    return array;

}









// ! O(n) time | O(1) space
function three_number_sort(array, order) {
    const firstValue = order[0];
    const thirdValue = order[2];

    let firstIdx = 0;
    for(let i = 0; i < array.length; i++) {
        if(array[i] === firstValue) {
            swap(i, firstIdx, array);
            firstIdx++;
        }
    }

    let thirdIdx = array.length - 1;
    for(let i = array.length - 1; i > -1; i--) {
        if(array[i] === thirdValue) {
            swap(i, thirdIdx, array);
            thirdIdx--;
        }
    }
    return array;
}

function swap(i, j, array) {
    [array[i], array[j]] = [array[j], array[i]];
}

// ! O(n) time | O(1) | space modified bucket sort
function three_number_sort(array, order) {
    const valueCounts = [0, 0, 0];
    for(const element of array) {
        const orderIdx = order.indexOf(element);
        valueCounts[orderIdx]++;
    }
    for(let idx = 0; idx < 3; idx++) {
        const value = order[idx];
        const count = valueCounts[idx];

        const numElementsBefore = valueCounts.slice(0, idx).reduce((a, b) => a + b, 0);

        for(let n = 0; n < count; n++) {
            const currentIdx = numElementsBefore + n;
            array[currentIdx] = value;
        }
    }
    return array;
}


let array = [1, 0, 0, -1, -1, 0, 1, 1];
const order = [0, 1, -1];
console.log(three_number_sort(array, order));