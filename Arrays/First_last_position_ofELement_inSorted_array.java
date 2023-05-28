
/**
 * Problem :-  Find First and Last Position of Element in Sorted Array
  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
  
 * Problem Statement:-
  
    Given an array of integers nums sorted in non-decreasing order,
    find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.

  * SAMPLE I/O
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

 * 
 */

/**
 * APPROACH :- Binary Search
 
 1. We make a function 'BS' that takes the input [nums,target,indexfirst] ,
  where if indexfirst=true i.e we want  the first element else the last element,
  ans return an integer
  
 2. For the first index:
    In this function 'BS' it will Apply Binary Search, pass the Argument 'indexfirst'=true.
    And if(nums[mid]==target),then we save the indx in a variable 'ans' and make end=mid-1;
    this will happen till we reach the first occurence of the element
    when the loop is over,
    return the 'ans' at last, and store this in "arr[0]"

    
 
 3. For the Last index:
     Apply Binary Search,
     pass the Argument 'indexfirst'=false.
    And if(nums[mid]==target),then we save the indx in a variable 'ans' and make start=mid+1;
    this will happen till we reach the last occurence of the element
    when the loop is over
    return the 'ans' at last, and store this in "arr[1]"
    
   Time Complexity :- O(log n) 
   Because of the application of binary search.

   Space Complexity :- O(1)
   There is no extra space is used.
   (the  arr we return at last is always- arr.length==2, Hence Constant space )

 */




class Solution {
    public int[] searchRange(int[] nums, int target) {
        
	int [] arr= {-1,-1};//return this if target is not found
	arr[0]=BS(nums, target, true);
        if(arr[0]==1) return arr; //means the target doesn't exist hence return {-1,-1}
        	
    arr[1]=BS(nums, target, false);
      
	return arr;
}
static int BS(int []nums,int target,boolean indexfirst) {
		int ans=-1;//potential ans 
		int start=0,end=nums.length-1;
		while(start<=end) {
		    int mid=start+(end-start)/2;
		 
          if(target>nums[mid]) {
			start=mid+1;
			}
		 
		  else if(target<nums[mid])  {
		 end=mid-1;
		}

		else {          //else means target ==nums[mid]
			ans=mid;       //ans updated because possible  ans is  found
			if(indexfirst) {
				end=mid-1; // shift the end till it reaches the first occurence
			}
			else {
				start=mid+1; //shift the end till it reaches the last occurence
			}
		}
		}
		return ans;
	}
}