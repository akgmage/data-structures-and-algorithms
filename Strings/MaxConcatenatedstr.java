class Solution {
public:
    // i: arr[i] we are currently looking at
	// mask: Bitmask that represents all the characters that have been added to the current string
	// If 0-th bit in mask is set, it means that we have added "a" in the current string
    int solve(vector<string> &arr, int i, int mask) {
        int n = arr.size();
        
        if (i >= n)
            return 0;
        
        // Skip concatenating arr[i]
        int curRes = solve(arr, i+1, mask)
		
		// Mask to keep track of the characters that are present in arr[i]
		int curMask = 0;
        
        // Check whether any character in arr[i] is present in current string, i.e. 
		// Check whether (arr[i]-'a')-th bit is set in mask
        // If any existing character's bit is set, it means that we cannot concatenate arr[i]
        // to the given string and so return curRes only which contains the result of skipping arr[i]
        // Also, use curMask to maintain the characters in arr[i] that have been seen.
		// It is possible that arr[i] itself has duplicate characters in which case, we will not be able to concatenate arr[i]
        // So check whether (c-'a')-th bit is set in curMask and after that set the (c-'a')-th bit in curMask
        for (char &c: arr[i]) {
            if (mask & (1 << (c - 'a')))
                return curRes;
            
            if (curMask & (1 << (c - 'a')))
                return curRes;
            
            curMask |= (1 << (c - 'a'));
        }
        
        // All the bits that were set in curMask will be now set in mask, 
		// in order to add all characters of arr[i] to the current string
        mask |= curMask;
        
        // We make a call to i+1 with the updated mask and arr[i]'s length being added
        curRes = max(curRes, (int) arr[i].length() + solve(arr, i+1, mask));
        return curRes;
    }
    
    int maxLength(vector<string>& arr) {
        return solve(arr, 0, 0);
    }
};
