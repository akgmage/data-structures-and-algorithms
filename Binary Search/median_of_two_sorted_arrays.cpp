/*
Approach: 
    let nums1 = [1, 3, 4, 7, 10, 12], nums2 = [2, 3, 6, 15]

    In order to find the median, we need a single sorted array. So a naive approach is that, just merge the 2 sorted arrays and find the median of that array.
    This will have a time Complexity of O(n1 + n2), Space Complexity of O(n1 + n2)

    Now, lets optimise it.
    So, the sorted form of the given array is arr = [1, 2, 3, 3, 4, 6, 7, 10, 12, 15]. To find the median of the array, we need to select the 2 mid elements and average it out.
    If we observe the sorted array carefully, then we notice that the 2 middle elements are arr[4] = 4 and arr[5] = 6, => arr[4] <= arr[5].
    
    Thought process:
    Now, since the arrays are sorted, so the binary searh may be able to solve the problem.
    Observation 1: If we partition the sorted array arr into 2 halves, then for sure we know that there would be 5 elements on left half and 5 elements on right half.
        Now, we can select 5 elements for right half from nums1 and nums2 combinedly and similarly the rest of the elements for the left half.
        Example:
            1. left => [1, 3, 4, 7, 2], right => [10, 12, 3, 6, 15]
            2. left => [1, 3, 4, 2, 3], right => [7, 10, 12, 6, 15]
            3. left => [1, 3, 2, 3, 6], right => [4, 7, 10, 12, 15]
    
    Observation 2: All the elements on left half is lesser than all the elements on the right half.
        Now, according to the observation, I have to check that all the elements in the left <= all the elements in the right. This can be done by just comparing the maximum of left half <= minimum of right half.
    
    Hence, the problem boils down to a searching problem; but how to identify the binary search approach??
        Suppose, we partition the element as example 1, then the max of left[] = 7 and min of right[] = 3, but according to the 2nd observation, it is not valid. So, in order to have a correct max in left, I need to reduce its value and consequestly, the min of right[] should be increased. That means, I have to move leftwards in nums1 to have a correct max value in left half.
*/

// Leetcode link: https://leetcode.com/problems/median-of-two-sorted-arrays/

#include<bits/stdc++.h>

class Solution {
public:
    double findMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
        int n1 = nums1.size(); // stores the length of nums1 array
        int n2 = nums2.size(); // stores the length of nums2 array

        if(n2 > n1) return findMedianSortedArrays(nums2, nums1);

        // according to approach described above, I am applying binary search on nums1 array
        int lo = 0, hi = n1;
        while(lo <= hi){
            int mid1 = (lo+hi)/2; // mid of nums1
            int mid2 = (n1 + n2 + 1)/2 - mid1;

            std::pair<int, int> maxleft, minright;
            maxleft.first = mid1 == 0 ? INT_MIN : nums1[mid1-1];
            maxleft.second = mid2 == 0 ? INT_MIN : nums2[mid2-1];

            minright.first = mid1 == n1 ? INT_MAX : nums1[mid1];
            minright.second = mid2 == n2 ? INT_MAX : nums2[mid2];

            if(maxleft.first <= minright.second and maxleft.second <= minright.first){
                if((n1+n2)%2 == 1){
                    return std::max(maxleft.first, maxleft.second);
                } else {
                    return (std::max(maxleft.first, maxleft.second) + std::min(minright.first, minright.second))/2.0;
                }
            } else if (maxleft.first > minright.second){
                hi = mid1-1;
            } else {
                lo = mid1+1;
            }
        }
    }
};

int main(int argc, char const *argv[])
{
    int n;

    std::cin>>n;
    std::vector<int> arr1(n, 0);
    for(int i=0;i<n;i++){
        std::cin>>arr1[i];
    }

    std::cin>>n;
    std::vector<int> arr2(n, 0);
    for(int i=0;i<n;i++){
        std::cin>>arr2[i];
    }

    Solution sol = Solution();
    double res = sol.findMedianSortedArrays(arr1, arr2);

    std::cout<<res<<"\n";
    return 0;
}
