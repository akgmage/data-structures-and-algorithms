function ordering(arr, m, n) {

    let result = [...Array(m)].map(e => Array(n));

    let newArr = [];

    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            newArr.push(arr[i][j]);
        }
    }
    newArr.sort((a, b) => a - b);

    let k = 0;
    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            result[i][j] = newArr[k];
            k++;
        }
    }
    return result;
    
}

const arr = [[3, 8, 7], [16, 15, 7], [11, 9, 6]];
console.log(ordering(arr, 3, 3));