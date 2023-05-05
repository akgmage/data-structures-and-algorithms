"""
Write a function that takes in an array of integers and returns the length of the longest peak
in the array.A peak is defined as adjacent integers in the array that are strictly increasing
until they reach a tip (the highest value in the peak), at which point they become strictly 
decreasing. At least three integers are required to form a peak.
"""



#approach
"""
1. iterate through the array from index 1 to len(arr) - 1
2. check if the current element is a peak
3. if it is a peak, then find the length of the peak
4. go to the uphill start
5. go to the downhill end
6. update the ans
"""
# Time Complexity: O(n)
# Space Complexity: O(1)



arr=[1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]


def longestPeak(arr: list) -> int:
        ans = 0
        # iterate through the array from index 1 to len(arr) - 1
        for indx in range(1, len(arr) - 1):
            # check if the current element is a peak
            if arr[indx - 1] < arr[indx] > arr[indx + 1]:
                # if it is a peak, then find the length of the peak
                uphill_start = downhill_ends = indx
                # go to the uphill start
                while uphill_start > 0 and arr[uphill_start] > arr[uphill_start - 1]:
                    uphill_start -= 1
                    # go to the downhill end
                while downhill_ends + 1 < len(arr) and arr[downhill_ends] > arr[downhill_ends + 1]:
                    downhill_ends += 1
                    # update the ans 
                ans = max(ans, (downhill_ends - uphill_start + 1))
        return ans


print(longestPeak(arr))
# output: 6