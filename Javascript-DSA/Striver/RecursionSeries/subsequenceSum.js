function subsequenceSum(i, nums, currentSum, array, sum) {

    if(i == n) {
        if(currentSum == sum) {
            console.log(nums);
        }
        return;
    }
    nums.push(array[i]);
    currentSum += array[i];
    subsequenceSum(i + 1, nums, currentSum, array, sum);

    currentSum -= array[i];
    nums.pop();
    subsequenceSum(i + 1, nums, currentSum, array, sum);
}

const array = [1, 2, 1];
const n = array.length;
const sum = 2;

subsequenceSum(0, [], 0, array, sum);
