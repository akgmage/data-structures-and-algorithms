const quadruplets = [];
     array.sort((a, b) => a - b);
     const len = array.length;
    for(let i = 0; i < len; i++) {
        for(let j = i + 1; j < len; j++) {
            const currentSum = array[i] + array[j];
            const difference = targetSum - currentSum;
            
            let left = j + 1;
            let right = len - 1;
            
            while(left < right) {
                const twoSum = array[left] + array[right];
                
                if(twoSum < difference) left++;
                if(twoSum > difference) right--;
                else{
                    quadruplets[quadruplets.length] = [array[i], array[j], array[left], array[right]]; 
                    while(left < right && array[left] == quadruplets[quadruplets.length - 1][2]) left++;
                    while(left < right && array[right] == quadruplets[quadruplets.length - 1][3]) right--;
                }
            }
            while(j + 1 < len && array[j + 1] == array[j]) j++;
        }
        while(i + 1 < len && array[i + 1] == array[i]) i++;
    }
    return quadruplets;
    