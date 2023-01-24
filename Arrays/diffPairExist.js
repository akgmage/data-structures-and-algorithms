function diffPair(array, k) {
    let n = array.length;
    let i = 1;
    let j = 0;
    let res = [];
    
    while (i < n && j < n) {
        // console.log("i", i, "j",);
        let diff = array[i] - array[j];
        if(diff == k) {
            res.push ([array[j], array[i]]);
            i++;
            j++;
        } else if (diff < k) {
            i++; 
        } else if (diff > k) {
            if( j + 1 != i) {
                j++;
            } else {
                i++; 
                j++;
            }
        }
    }
    // return false;
    return res;
}

let array = [1, 1, 4, 6, 7, 8, 11];

console.log(diffPair(array, 4));