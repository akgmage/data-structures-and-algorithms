 function upper_bound(array, target) {
     let left = 0;
     let right = array.length - 1;
     let ans = -1;
     while(left <= right) {
         let mid = Math.floor( (left + right) / 2);
         if(array[mid] > target) {
             ans = mid;
             right = mid - 1;
        } else left = mid + 1;
    }
     if (ans == -1) return array.length;
     return ans;
}
function triangle(array) {  
    array.sort( (a, b) => a - b);
    let len = array.length;
    let ans = 0;
    for(let i = 0; i < len; i++) {
        for(let j = i + 1; j < len - 1; j++) {
            const sum = array[i] + array[j];
            ans += len - upper_bound(array, sum);
        }
    }
    return ans;
}
console.log(triangle([4, 2, 10]));