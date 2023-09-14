lass Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        int n=nums.size(), ans=0;
        for(int i=0;i<32;i++){
            int count=0; 
            for(int k=0;k<n;k++){
                count += (nums[k]>>i)&1;
            }
            ans += count*(n-count);
        }
        return ans;
    }
};
