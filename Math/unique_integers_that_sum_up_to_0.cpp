/*
    Given an integer n, return any array containing n unique integers such that they add up to 0.

    Example 1:
    Input: n = 5
    Output: [-7,-1,1,3,4]
    Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
    
    Example 2:
    Input: n = 3
    Output: [-1,0,1]
    
    Example 3:
    Input: n = 1
    Output: [0]
    
    Constraints:
    1 <= n <= 1000
*/

class Solution {
public:
    vector<int> sumZero(int n) {
        int A[n];
        for(int i = 0; i < n; i++){ A[i] = 0; }
        int start = 0;
        int end = n - 1;
        int i = 1;
        // populate start and end with n and -n
        while(start < end) {
            A[start] = i;
            A[end] = -i;
            i++;
            start++;
            end--;
        }
        vector<int> R;
        for(int a: A){
            R.push_back(a);
        }
        return R;
    }
};