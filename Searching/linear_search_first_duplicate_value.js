// Linear search in an array of integers


// Big-O = O(n) time complexity
// Big-O = O(1) space complexity
const firstDuplicate2 = arr => {
    for(let i = 0; i < arr.length; i++){
       if(arr.lastIndexOf(arr[i]) !== i){
          return arr[i];
       };
    };
    return "No duplicates found!";
}

console.log(firstDuplicate2([2, 1, 5, 2, 3, 3, 4]));




// Big-O = O(n) time complexity
// Big-O = O(n) space complexity
const firstDuplicate1 = arr => {
    let elementSet = new Set();

    for (let i = 0; i < arr.length; i++) {
        if (elementSet.has(arr[i])) return arr[i];
        elementSet.add(arr[i]);
    }
    return "No duplicates found!";
}

console.log(firstDuplicate1([2, 1, 5, 2, 3, 3, 4]));

