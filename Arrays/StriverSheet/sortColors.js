// https://leetcode.com/problems/sort-colors/

function sortColors(nums) {
    if(nums.length <= 1) return nums;

    let low = 0, mid = 0, high = nums.length - 1;

    while(mid <= high) {
        const num = nums[mid];
        switch(num) {
            case 0: 
                swap(num, low++, mid++);
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(num, mid, high--);
        }
    }
    return nums;
}

function swap(nums, i, j) {
    [ nums[i], nums[j] ] = [ nums[j], nums[i] ];
}

