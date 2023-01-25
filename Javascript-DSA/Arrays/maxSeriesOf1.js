function maxSeriesOf1(array) {
    let n = array.length;
    let i = -1, j = 0;
    let ans = 0;
    while(j < n && i < n) {
        if(array[j] == 1) {
            ans = Math.max(ans, j - i);
            j++;
        }
        else {
            i = j;
            j++;
        }
    }
    return ans;

}

let array = [0, 1, 0, 0];

console.log(maxSeriesOf1(array));