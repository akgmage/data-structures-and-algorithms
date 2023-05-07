/*
Write a function that takes in an array of at least three integers and, 
without sorting the input array, returns a sorted array of the three largest integers in the input array.


Approach:

Before implementing the task logic the array will be checked to see if it meets the criteria.
Here the input array will be checked to see if it´s at least 3 elements big and if it
only contains integers.

After that the logic is implemented.
Because the given array should not be sorted for this task, the used logic works as following:
1. Initialize a result array with 3 values, each of these 3 is initialized as -Infinity
2. Check if first element of array is bigger than the third result value
    2.1 If value is bigger set new value (will be true for the first check as initialized with -Infinity)
    2.2 shift current numbers in result array
    2.3 checks if element is bigger than value 2, and also value 1 - following above logic
3. Sorty the result array in descending order and console logs the result.
*/

function findThreeLargestInteger(array) {

    /************************************************************************
     *        This block checks if given array matches the criteria         *
    ************************************************************************/
    let arrayLength = 0;
    let onlyIntegers = true;
    // iterate over given array and check each element 
    array.forEach(element => {
        // is element an integer
        if (!Number.isInteger(element)) {
            onlyIntegers = false;
        }
        // count length of array
        arrayLength++;
    });


    /************************************************************************
     *                    Implementing the task logic                       *
    ************************************************************************/
    if (onlyIntegers && arrayLength >= 3) {
        // initialize result array with -Infinite
        let result = [-Infinity, -Infinity, -Infinity];

        // Loop through the input array
        for (const num of array) {
            // Check if the current number is larger than the third largest number
            if (num > result[2]) {
                // Shift the current numbers down the result array
                result[0] = result[1];
                result[1] = result[2];
                result[2] = num;
            } else if (num > result[1]) {
                // Shift the current numbers down the result array
                result[0] = result[1];
                result[1] = num;
            } else if (num > result[0]) {
                // Shift the current number down the result array
                result[0] = num;
            }
        }
        // sorts the result in descending order (big to small)
        result.sort(function (a, b) { return b - a });
        console.log(result);

    } else {
        console.log("The passed array does not match the expected criteria.");
    }

}

const testArray = [5, -3, 5, 100, 3, 55, 999, -18];
const functionCheck = findThreeLargestInteger(testArray); // prints [999, 100, 55] to console

const arrayToShort = [100, 999];
const unctionCheck1 = findThreeLargestInteger(arrayToShort); // prints "The passed array does not match the expected criteria." to console

const arrayNoInt = [100, 999, 8.5];
const unctionCheck2 = findThreeLargestInteger(arrayNoInt); // prints "The passed array does not match the expected criteria." to console