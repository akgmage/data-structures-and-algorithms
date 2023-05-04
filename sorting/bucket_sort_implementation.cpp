/*
	Bucket-Sort can be used to sort a set of uniformly distributed floating point numbers.
	Input: 	[0.872, 0.435, 0.516, 0.1004, 0.1065, 0.3464]
	Output:	[0.1004, 0.1065, 0.3464, 0.435, 0.516, 0.872]
	
	Input: 	[9.81, 9.6, 1.1, 1.9, 5.07,5.04, 3.0, 11.11, 0.18, 6.78]
	Output:	[0.18, 1.1, 1.9, 3, 5.04, 5.07, 6.78, 9.6, 9.81, 11.11 ]


	APPROACH
	1. Create N buckets.
	2. Calculate the range of floating points using the formula:
			RANGE = (MAX_ELEMENT - MIN_ELEMENT)/ N
	3. Calculate bucket index for current element using the following formula:
			BUCKET_INDX = (CURR_ELEMENT - MIN_ELEMENT)/RANGE
	4. If BUCKET_INDX is an integer i.e its floating part==0.00 and its is not equal to MIN_ELEMENT, update BUCKET_INDX as follows:
			BUCKET_INDX = BUCKET_INDX - 1
	5. Insert CURR_ELEMENT the bucket as per BUCKET_INDX
	6. Sort each bucket individually.
	7. Concatenate all sorted buckets and return concatenated list as answer.

	TIME COMPLEXITY:  O(N) 
	SPACE COMPLEXITY: O(N)
*/
#include <bits/stdc++.h>
using namespace std;

void bucketSort(vector<double>& nums)
{
    // Intialize variables we will be needing later
    int N=nums.size();
    double max_ele = *max_element(nums.begin(), nums.end());
    double min_ele = *min_element(nums.begin(), nums.end());
    double range = (max_ele - min_ele)/N;
    vector<double> buckets[N];

    // Insert elements into their correct buckets by calculating bucket indexes
    for(int i=0;i<N;i++)
    {
        double diff=((nums[i]-min_ele)/range)-(int)((nums[i]-min_ele)/range);
        int indx=(nums[i]-min_ele)/range;
        if(diff==0 && nums[i]!=min_ele){
            buckets[indx-1].push_back(nums[i]);
        }
        else{
            buckets[indx].push_back(nums[i]);
        }
    }

    // Sort each bucket
    for(int i=0;i<N;i++)
    {
        if(buckets[i].size()==0) continue;
        sort(buckets[i].begin(),buckets[i].end());
    }

    // Concatenate all the buckets and store in the original list
    int indx=0;
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<buckets[i].size();j++)
        {
            nums[indx]=buckets[i][j];
            indx++;
        }
    }
}
int main(){

vector<double> nums1={0.872, 0.435, 0.516, 0.1004, 0.1065, 0.3464};
bucketSort(nums1);
for(auto i:nums1) cout<<i<<" ";
vector<double> nums2={ 9.81,  9.6, 1.1, 1.9, 5.07,5.04, 3.0, 11.11,  0.18, 6.78};
bucketSort(nums2);
cout<<"\n";
for(auto i:nums2) cout<<i<<" ";
return 0;
}