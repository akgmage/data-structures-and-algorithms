function sortZeroOneTwo(array) {

    const counts = {0: 0, 1:0, 2:0};

    for (let i = 0; i < array.length; i++) {
        counts[array[i]] += 1;
    }
    let len = 0;

    for(const count in counts) {
        let numCount = counts[count];

        while(numCount >= 1) {
            array[len++] = parseInt(count);
            numCount--;
        }
    }
    return array;

}

const array = [1, 1, 1, 2, 0, 0, 0];


console.log(sortZeroOneTwo(array));