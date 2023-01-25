function lower_bound(array, target) {
    let left = 0;
    let right = array.length - 1;
    let ans = -1;
    while(left <= right) {
        let mid = Math.floor((left + right) / 2);
        if(array[mid] >= target) {
            ans = mid;
            right = mid - 1;
        } else left = mid + 1;
    }
    if(ans == -1) return NaN;
    return ans;
}
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
     if (ans == -1) return NaN;
     return ans;
}

 function sex_tuples(array) {
     let len = array.length;
     let lhs = [];
     let rhs = [];
     for(let i = 0; i < len; i++) {
        for(let j = 0; j < len; j++) {
            for(let k = 0; k < len; k++) {
                lhs.push( array[i] * array[j] + array[k] );
            }
        }
    }
     for(let i = 0; i < len; i++) {
         if(array[i] == 0) continue;
        for(let j = 0; j < len; j++) {
            for(let k = 0; k < len; k++) {
                rhs.push( array[i] * (array[j] + array[k]) );
            }
        }
    }

    rhs.sort( (a, b) => a - b);
    let ans = 0;
    for(let i = 0; i < lhs.length; i++) {
        let lb = lower_bound(rhs, lhs[i]);
        let ub = upper_bound(rhs, lhs[i]);
        ans += (ub - lb);
    }
  return ans;
}
console.log(sex_tuples([2, 3]));

