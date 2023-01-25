function can_we_put_c_cows_with_min_dist_d(d, cows, stalls) {
    let last_placed_cow_pos = stalls[0];
    let no_of_cows_placed = 1;
    for(let i = 1; i < stalls.length; i++) {
        let dist = stalls[i] - last_placed_cow_pos;
        if(dist >= d) {
            no_of_cows_placed++;
            last_placed_cow_pos = stalls[i];
        }
        if(no_of_cows_placed == cows) {
            return true;
        }
    }
    return false;
}
function place_cows(cows, stalls) {
    stalls.sort( (a, b) => a - b );
    let l = 1, r = stalls[stalls.length - 1] - stalls[0];
    let ans = 1;
    while(l <= r) {
        let mid = l + Math.floor( (r - l) / 2);
        if(can_we_put_c_cows_with_min_dist_d(mid, cows, stalls)) {
            ans = mid;
            l = mid + 1;
        } else r = mid - 1;
    }
    return ans;
}

console.log(place_cows(3, [1, 2, 8, 4, 9]));