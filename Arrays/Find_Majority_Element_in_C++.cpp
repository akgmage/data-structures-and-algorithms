//approach----
//here we make a map which maintain the frequency of each array element while traversing through the element.
//and also check the frequency at the same time..if frequency(occurence) of any  element is  greater than (n/2) at anytime we will return that element.
// suppose if no such element exist return simply -1.

code----
Find Majority Element in C++ 
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
       unordered_map<int,int>mp;
        for(int i:nums){
            if(++mp[i]>nums.size()/2){
                return i;
            }
        }
        return -1;
    }
};
