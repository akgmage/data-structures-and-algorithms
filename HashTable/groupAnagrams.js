function group(array) { //! Time O(nklogk) klogk --> sorting time for every string
    let hash_map = {};
    for(let i = 0; i < array.length; i++) {
        let sorted_perm = array[i].split("").sort().join("");
        if(hash_map[sorted_perm] == undefined) {
            console.log(hash_map);
            hash_map[sorted_perm] = [array[i]];
            console.log(hash_map);
        } else {
            hash_map[sorted_perm].push(array[i]);
        }
    }
    // return hash_map;
    return Object.values(hash_map);
}

console.log((group(["bat", "ate", "eat", "tan", "nat", "tea"])));