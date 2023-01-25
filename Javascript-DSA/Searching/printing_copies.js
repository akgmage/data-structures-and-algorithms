function can_i_make_copies_in_m_seconds(m, x, y, d) {
// m --> is the time, d --> requires number of copies, x & y are the speed of machines
return (Math.floor(m / x) + Math.floor(m / y) >= d);
}

function min_time_for_n_copies(x, y, n) {
    if(n == 1) return Math.min(x, y, n);
    let l = 0, r = Math.max(x, y) * n;
    let ans = 0;
    while(l <= r) {
        let mid = l + Math.floor( (r - l) / 2);
        if(can_i_make_copies_in_m_seconds(mid, x, y, n - 1)) {
          ans = mid;
          r = mid - 1;
        } else l = mid + 1;
    }
    return ans + Math.min(x, y);
}

console.log(min_time_for_n_copies(1, 2, 5));