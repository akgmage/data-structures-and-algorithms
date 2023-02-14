class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
           int tar = m+n-1;  // size of nums1 

           int i=m-1;        // index of last element of nums1

            int j = n-1;     // index of last element of nums2

            while(j>=0){    // iterate from last

                   if(i>=0 && nums1[i] > nums2[j]) nums1[tar--] = nums1[i--]; 

                   else nums1[tar--] = nums2[j--];
                           
        }
        // Time complexity of this code is O(m+n)
        
        // Space complexity is S(1)
    }
};