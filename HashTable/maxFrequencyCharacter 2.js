function maxFreqChar(str) {
    let hm = {};
    for(let i = 0; i < str.length; i++) {
        if(hm[str[i]] == undefined) hm[str[i]] = 1;
        else hm[str[i]] += 1;
    }
    let maxFreq = 0;
    let ans = undefined;
    for(const [key, value] of Object.entries(hm)) {
        if(maxFreq < value) {
            ans = value;
            maxFreq = value;
        }
    }
    return ans;
}

console.log(maxFreqChar("aaaaaabc"));