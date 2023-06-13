/*
   Questions:- An array arr a mountain if the following properties hold:

     1.)arr.length >= 3
     2.)There exists some i with 0 < i < arr.length - 1 such that:
         1.)arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
          2.)arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] 
        < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

       You must solve it in O(log(arr.length)) time complexity.

Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
 

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
*/

   class Solution {
   public:
       int peakIndexInMountainArray(vector<int>& arr) {
        int m=*max_element(arr.begin(),arr.end());
          int n=arr.size();
        int lo=0;
         int hi=n-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
                return mid;
            }
            if(mid-1<0&&arr[mid]<arr[mid+1]){
                lo=mid+1;
            }
            else if(mid+1>n-1&&arr[mid]<arr[mid-1]){
                hi=mid-1;
            }
            else if(arr[mid]<arr[mid-1]&&arr[mid]>arr[mid+1]){
                hi=mid-1;
            }
            else if(arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]){
                lo=mid+1;
            }
        }
        return -1;
    }
};

