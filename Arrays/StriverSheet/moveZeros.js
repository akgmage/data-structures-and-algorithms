// https://leetcode.com/problems/move-zeroes/submissions/

function nonZeros(nums) {

    if(nums.length == 0) return;

    let currentPosition = 0;

    for(const num of nums) {
        if(num != 0) nums[currentPosition++] = num;
    }

    while(currentPosition < nums.length) {
        nums[currentPosition++] = 0;
    }

    return nums;
}


