/**
 * Approach: 
    let nums1 = [1, 3, 4, 7, 10, 12], nums2 = [2, 3, 6, 15]

    In order to find the median, we need a single sorted array. So a naive approach is that, just merge the 2 sorted arrays and find the median of that array.
    This will have a time Complexity of O(n1 + n2), Space Complexity of O(n1 + n2)
*/

# include <bits/stdc++.h>

class Solution {
    std::vector<int> merge(std::vector<int>& nums1, std::vector<int>& nums2){
        int n1 = nums1.size();
        int n2 = nums2.size();

        int i=0, j=0;

        std::vector<int> res;
        while(i < n1 and j < n2){
            if(nums1[i] < nums2[j]){
                res.push_back(nums1[i]);
                i++;
            } else {
                res.push_back(nums2[j]);
                j++;
            }
        }

        while(i < n1){
            res.push_back(nums1[i]);
            i++;
        }

        while(j < n2){
            res.push_back(nums2[j]);
            j++;
        }

        return res;
    }
public:
    double findMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
        std::vector<int> sortedarr = merge(nums1, nums2);

        if(sortedarr.size() % 2 == 0){
            return (sortedarr[sortedarr.size()/2] + sortedarr[sortedarr.size()/2 - 1])/2.0;
        } else {
            return (double)sortedarr[sortedarr.size()/2];
        }
    }
};

int main(int argc, char const* argv[]) {
    int n;

    std::cin >> n;
    std::vector<int> arr1(n, 0);
    for (int i = 0;i < n;i++) {
        std::cin >> arr1[i];
    }

    std::cin >> n;
    std::vector<int> arr2(n, 0);
    for (int i = 0;i < n;i++) {
        std::cin >> arr2[i];
    }

    Solution sol = Solution();
    double res = sol.findMedianSortedArrays(arr1, arr2);

    std::cout << res << "\n";
    return 0;
}