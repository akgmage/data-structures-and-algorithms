function a(arr, k) {

    let result = [];
    for(let i = 0; i < arr.length - k + 1; i++) {
        let j = i;
        let p = i + k - 1;
        let temp = 0;
        while(j <= p) {
            temp = Math.max(temp, arr[j]);
            j++;
        }
        result.push(temp);
        temp = 0;
    }
    return result;
}

let arr = [1, 2, 3, 1, 0, -1, 4, 5, 2, 3, 6];
let k  = 3;

console.log(a(arr, k));