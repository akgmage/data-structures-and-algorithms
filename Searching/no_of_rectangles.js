function can_we_fit_n_rect_in_sq_of_m(n, w, h, m) {
    return (Math.floor(m / w) * Math.floor(m / h)) >= n;
}

function min_rect(n, w, h) {
    let l = 1, r = Math.max(w, h)*n;
    let ans = 0; 
    while(l <= r) {
        let mid = l + Math.floor( (r - l) / 2);
        if(can_we_fit_n_rect_in_sq_of_m(n, w, h, mid)) {
            ans = mid;
            r = mid - 1;
        } else l = mid + 1;
    }
    return ans;
}

console.log(min_rect(10, 2, 3));