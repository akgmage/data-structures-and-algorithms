//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers
// m and n, representing the number of elements in nums1 and nums2 respectively.

//Merge nums1 and nums2 into a single array sorted in non-decreasing order.

//The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that
// should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.


import java.util.Arrays;

class merge_sorted_array{

    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] merged=new int[m+n]; //new merged array
        //copying the first m elements from nums1 to the merged array
        if (m >= 0) System.arraycopy(nums1, 0, merged, 0, m);
        //copying the first n elements from nums2 to the merged array
        if (n >= 0) System.arraycopy(nums2, 0, merged, m + 0, n);
        //sorting the merged array
        Arrays.sort(merged);
        //copying the merged array to the nums1 array
        System.arraycopy(merged, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 ={2, 5, 6};

        merge_sorted_array is = new merge_sorted_array();
        is.merge(nums1, m, nums2, n);
        for (int j : nums1) {
            System.out.print(j + " ");
        }
    }
}
