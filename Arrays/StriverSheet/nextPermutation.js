// https://leetcode.com/problems/next-permutation/


function nextPermutation(nums) {
    if(nums == null || nums.length <= 1) return nums;

    let i = nums.length - 2;

    while(i > -1 && nums[i] >= nums[i + 1]) i--;

    if(i > -1) {
        let j = nums.length - 1;
        while(nums[j] <= nums[i]) j--;
        swap(nums, i, j);
    }

    return reverse(nums, i + 1, nums.length - 1);
}

function swap(nums, i, j) {
    [ nums[i], nums[j] ] = [ nums[j], nums[i] ];
}

function reverse(nums, i, j) {
    if(i >= j) return nums;
    swap(nums, i, j);
    return reverse(nums, i + 1, j - 1);
    while(i < j) swap(nums, i++, j--);
    return nums;
}
console.log(nextPermutation([5, 4, 3, 2, 1]));