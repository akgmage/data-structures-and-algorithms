/*
    Given an integer array and a window of size windowSize, find the current maximum value in the window as it slides through the entire array
*/
function findMaxSlidingWindow(nums, windowSize) {
    if (!nums || windowSize <= 0 || nums.length < windowSize) {
        return [];
    }

    const n = nums.length;
    const result = new Array(n - windowSize + 1).fill(0);
    const deque = []; // deque stores the indices of elements in the window

    // process the first window separately
    for (let i = 0; i < windowSize; i++) {
        while (deque.length > 0 && nums[i] >= nums[deque[deque.length - 1]]) {
            deque.pop();
        }
        deque.push(i);
    }
    result[0] = nums[deque[0]];

    // process the remaining windows
    for (let i = windowSize; i < n; i++) {
        while (deque.length > 0 && deque[0] <= i - windowSize) {
            deque.shift(); // remove elements outside the window
        }
        while (deque.length > 0 && nums[i] >= nums[deque[deque.length - 1]]) {
            deque.pop(); // remove elements smaller than nums[i]
        }
        deque.push(i);
        result[i - windowSize + 1] = nums[deque[0]];
    }

    return result;
}

const nums = [1, 3, -1, -3, 5, 3, 6, 7];
const windowSize = 3;

const maxInWindow = findMaxSlidingWindow(nums, windowSize);

console.log(`Max values in sliding window of size ${windowSize}:`);
console.log(maxInWindow.join(' '));

-------------Explanation---------------------

This code defines a findMaxSlidingWindow function that takes an array nums and a window size windowSize as input and returns an array containing the maximum value in each sliding window. The function first checks if the input is valid and creates an empty array result and a deque to store the indices of elements in the window.

The function then processes the first window separately by adding the indices of its elements to the deque in decreasing order of their values. This way, the first element in the deque will always be the maximum value in the window. The function stores this maximum value in the first element of the result array.

The function then processes the remaining windows by first removing any elements in the deque that are outside the current window. The function then adds the index of the current element to the deque and removes any elements in the deque that are smaller than the current element. The function stores the maximum value in the window in the corresponding element of the result array.

Finally, the function returns the result array.

The code also includes an example usage of the findMaxSlidingWindow function on an example array and window size. When the code is executed, it prints the maximum values in each sliding window to the console.