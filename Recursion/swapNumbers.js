function swapNumbers(i, n, array) {
    if(i >= n / 2) return;
    swap(i, n - i - 1, array);
    swapNumbers(i + 1, n, array);
}

function swap(a, b, array) {
    [ array[a], array[b]] = [ array[b], array[a]];
}

const array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
swapNumbers(0, array.length, array);
console.log(array);