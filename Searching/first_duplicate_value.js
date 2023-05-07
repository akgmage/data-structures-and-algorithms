/*  PROBLEM STATEMENT  */

/*  Given an array of integers between 1 and n, inclusive, where n is the length of the array, 
    write a function that returns the first integer that appears more than once (when the array
    is read from left to right). 
*/



/*  The difference between the two solutions provided is that the first solution has a space complexity
    of 0(1), meaning constant space complexity, while the second solution has a space complexity of 0(n),
    meaning linear space complexity. finally both solutions has a time complexity of 0(n), meaning linear
    time complexity.
*/



//  Big-O = O(n) time complexity
//  Big-O = O(1) space complexity
const firstDuplicate1 = arr => {
    
    // firstly iterate/loop through the given array
    for(let i = 0; i < arr.length; i++){
        // then use the Array.prototype.lastIndexOf() method to check for duplicates.
        // finally return the first number that appers more than once.
        if(arr.lastIndexOf(arr[i]) !== i) return arr[i];
    };

    // return the message No duplicate found, if no dupliacte is found after the iteration process.
    return "No duplicate found!";
}

console.log(firstDuplicate1([2, 1, 5, 2, 3, 3, 4]));




// Big-O = O(n) time complexity
// Big-O = O(n) space complexity
const firstDuplicate2 = arr => {

    // first off, let's create our Set object
    // this Set object will allow us to store each element from the given array as a unique value
    let elementSet = new Set();
    
    // then iterate/loop through the given array
    for (let i = 0; i < arr.length; i++) {
        // we'll check to see if the Set already contains the element that we're currently on in our loop
        // if it exists, then we've found our first duplicate! We'll return that value and be done
        if (elementSet.has(arr[i])) return arr[i];
        // if the element isn't in our Set yet, then we add it to the Set and move on to the next element in the array.
        elementSet.add(arr[i]);
    }

    // return the message No duplicate found, if no dupliacte is found after the iteration process.
    return "No duplicates found!";
}

console.log(firstDuplicate2([2, 1, 5, 2, 3, 3, 4]));

