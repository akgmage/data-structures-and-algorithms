function sqrt(target) {
    if(target == 10 || target == 1) return target;
    if(target < 0) return NaN;
    let low = 1;
    let high = target - 1;
    while(low <= high) {
        let mid = low + Math.floor( (high - low) / 2);
        if(mid * mid == target) return mid;
        if(mid * mid < target) {
            //? it can be a possible answer otherwise a better ans can be to the right.  
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return ans;
}
console.log(sqrt(50));