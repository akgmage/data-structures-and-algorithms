//Given an array of integers nums,we have to return the number of good pairs.

//A pair (i, j) is called good if nums[i] == nums[j] and i < j.  means our search space will start from i+1 for nums[i] as it is mentioned that i<j;



//Input1: nums = [1,2,3,1,1,3]
//Output1: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.


//Input2: nums = [1,1,1,1]
//Output2: 6
//Explanation: Each pair in the array are good i.e.(0,1),(0,2),(0,3),(1,2),(1,3),(2,3).


//Input3: nums = [1,2,3]
//Output3: 0
//Explanation:as no duplicates are present in the array so is the output.

//Constraints:
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

//as constraints are quite small we can easily run two for loop  in outer loop i goes from 0 to size-1 of array(as 0-indexed).And in another loop j starts from i+1  and goes to size-1.

//now come on the actual code---

//taking two parameters in the function first one is the array itself and second  is number of elements in  array.

int count_good_pairs(int num[],int n){
  int count=0;//intially initialize count as 0.
  
  for(int i=0;i<n;i++){
    for(int j=i+1;j<n;j++){
      if(nums[i]==nums[j]){
        count++;
      }
    }
  }
  return count;
}
