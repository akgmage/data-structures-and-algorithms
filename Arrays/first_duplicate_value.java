/* Sure, here's a brief explanation of each solution:

Solution 1 (O(n) time, O(1) space):
This solution uses Floyd's Tortoise and Hare algorithm to find the first duplicate value in the array. 
It initializes two pointers, a slow pointer and a fast pointer, to the first value in the array. 
The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. 
When they meet at a certain point, it indicates that there is a cycle in the array. 
Then, the slow pointer is reset to the first value, and both pointers move one step at a time until they meet again, 
which is the start of the cycle (i.e., the first duplicate value in the array).

Solution 2 (O(n) time, O(n) space):
This solution uses a HashSet to keep track of the integers that have been seen so far in the array. 
As the array is iterated over, each integer is checked to see if it is already in the set. 
If it is, then it is returned as the first integer that appears more than once. 
If no such integer is found, then -1 is returned. This solution has a time complexity of O(n) and a space complexity of O(n). */

// Solution 1: O(n) time and O(1) space
public static int findDuplicate(int[] nums) {
    // iterate through the array
    for (int i = 0; i < nums.length; i++) {
        // calculate the absolute value of the current element
        int val = Math.abs(nums[i]);
        // check if the value at the calculated index is negative
        if (nums[val - 1] < 0) {
            // if it is, return the absolute value of the current element
            return val;
        }
        // otherwise, negate the value at the calculated index
        nums[val - 1] = -nums[val - 1];
    }
    // if no duplicate is found, return -1
    return -1;
}


// Solution 2: O(n) time and O(n) space solution:
public static int findDuplicate(int[] nums) {
    // create a set to keep track of visited elements
    Set<Integer> visited = new HashSet<>();
    // iterate through the array
    for (int num : nums) {
        // check if the current element has already been visited
        if (visited.contains(num)) {
            // if it has, return the current element
            return num;
        }
        // otherwise, add it to the set of visited elements
        visited.add(num);
    }
    // if no duplicate is found, return -1
    return -1;
}

