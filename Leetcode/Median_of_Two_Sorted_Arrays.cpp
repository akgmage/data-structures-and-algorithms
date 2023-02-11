/*
Approach: 
    let nums1 = [1, 3, 4, 7, 10, 12], nums2 = [2, 3, 6, 15]

    In order to find the median, we need a single sorted array. So a naive approach is that, just merge the 2 sorted arrays and find the median of that array.
    This will have a time Complexity of O(n1 + n2), Space Complexity of O(n1 + n2)

    Now, lets optimise it.
    So, the sorted form of the given array is [1, 2, 3, 3, 4, 6, 7, 10, 12, 15]. To find the median of the array, we need to select the 2 mid elements and average it out. Now suppose, on partitioning the above merged-sorted array in the mid-point, we get 5 elements on left and 5 elements on the right.
    Now, we can get 5 elements by selecting {4 from left, 1 from right}, {3 from left, 2 from right}, {2 from left, 3 from right} and {1 from left, 4 from right}.
    Lets analyse case-wise:
        case 1: 4 from left, 1 from right

*/

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
            // why?? => suppose nums1[] is partitioned at index 3 => nums1[3] = 7.

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
