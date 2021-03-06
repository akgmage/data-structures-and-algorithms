/*
You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
If it does not exist, return -1 for this number.
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
*/
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result(nums1.size(), -1);
        stack<int> st;
        unordered_map<int, int> umap;
        // we will keep pushing the element into stack unless element in num2 is less than TOS
        // if element is greater then we map TOS with element and pop out the TOS
        for(auto element : nums2){
            while(!st.empty() && element > st.top()){
                umap[st.top()] = element;
                st.pop();
            }
            st.push(element);
        }
        // mapping is complete now we just traverse first array i.e num1 and check if its present in map
        // if its present in map then we store it in result or we escape 
        // note : result already is populated with -1's for cases such as if NGE is not present
        for(int i = 0; i < nums1.size(); i++){
            if(umap.find(nums1[i]) != umap.end()){
                result[i] = umap[nums1[i]];
            }
        }
        return result;
    }