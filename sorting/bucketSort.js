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