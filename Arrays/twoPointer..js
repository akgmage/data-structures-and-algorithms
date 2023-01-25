function maxSeriesOf1(arr) {
    let n = arr.length;
    let i = -1, j = 0;
    let ans = Number.MIN_SAFE_INTEGER;

    while(i < n && j < n) {
        if(arr[j] == 1) {
            ans = Math.max(ans, j++ - i);
        } else {
            i = j++;
        }
    }
    return ans;
}

let arr = [1, 1, 1, 1, 1, 0, 0, 1, 1];

console.log(maxSeriesOf1(arr));