/*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Explanation:

    The algorithm partitions the array into three sections: elements with the value 0, elements with the value 1, and elements 
    with the value 2. It uses three pointers, `start`, `low`, and `end`, to keep track of the boundaries between these sections.

    The algorithm iterates through the array using the `low` pointer. Here's how it works:

    1. If the element at `low` is 0, it means it should be in the first section. In this case, the algorithm swaps the element 
       with the element at the `start` position, increments both `start` and `low` pointers, and moves the `low` pointer to the 
       next element to process.

    2. If the element at `low` is 1, it means it should be in the second section. In this case, the algorithm simply increments 
       the `low` pointer and moves to the next element to process.

    3. If the element at `low` is 2, it means it should be in the third section. In this case, the algorithm swaps the element 
       with the element at the `end` position, decrements the `end` pointer, and moves the `low` pointer to the next element to process. The reason for moving the `low` pointer to the next element is to recheck the value after the swap, as the swapped element could be 0 or 1.

    The algorithm continues these steps until the `low` pointer surpasses the `end` pointer, indicating that all elements have 
    been processed.

    The "Dutch National Flag" algorithm has a time complexity of O(n), where n is the size of the input array. 
    It performs a single pass through the array, ensuring that all elements are correctly placed in their respective sections.

    Note that the code assumes the input vector `nums` contains only values 0, 1, and 2, and it modifies the vector in-place 
    to achieve the sorted order.

    Time complexity: O(n)
    Space complexity: O(1)
*/
function sortColors(nums) {
  let start = 0;
  let low = 0;
  let end = nums.length - 1;

  while (low <= end) {
    if (nums[low] === 0) {
      // Swap the element at low with the element at start
      [nums[low], nums[start]] = [nums[start], nums[low]];
      start++;
      low++;
    } else if (nums[low] === 1) {
      // Move to the next element
      low++;
    } else {
      // Swap the element at low with the element at end
      [nums[low], nums[end]] = [nums[end], nums[low]];
      end--;
    }
  }
}

// Example usage:
const nums = [2, 0, 2, 1, 1, 0];
sortColors(nums);
console.log(nums);
