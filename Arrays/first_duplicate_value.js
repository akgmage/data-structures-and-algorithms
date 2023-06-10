/*
	Given an array of integers between 1 and n, inclusive, where n is the length of the array, write a function
	that returns the first integer that appears more than once (when the array is read from left to right).

	Sample Input = [2, 1, 5, 2, 3, 3, 4]
	Output : 2

	
*/

//  O(n) time and O(1) space solution.
// Approach: The approach utilizes the fact that the array contains integers between 1 and n, 
// where n is the length of the array. By negating the values at specific indices,
// we can track which numbers have appeared before. If a number has appeared before,
// its corresponding index will have a negative value.
// This allows us to identify the first duplicate encountered during the iteration.
function findFirstDuplicate(nums){
    let n=nums.length;
    for(let i=0;i<n;i++){
        // Check if the absolute value at the current number's index is negative
        if(nums[Math.abs(nums[i])]<0){
        // If it is negative, the number has appeared before and is a duplicate
            return nums[i];
        }
        else{
            // Mark the number at its index as visited by negating its value
            nums[nums[i]]*=-1;
        }
    }
     // No duplicates found
    return -1;
}

// O(n) time and O(n) space solution.
// Approach: Using Set object or map to check if a number appears more than ones.

function findFirstDuplicate(nums){
    let set=new Set();
    for(let i=0;i<nums.length;i++){
        if(set.has(nums[i])==false){
            // If a number does not exists in set add it to set;
            set.add(nums[i]);
        }
        else{
            // Number already exits in set. So return the duplicate number.
            return nums[i]; 
        }
    }
    // If no duplicate element found.
    return -1;
}