'''
    An array of boolean values is divided into two sections; the left section consists of all false and the 
    right section consists of all true. Find the First True in a Sorted Boolean Array of the 
    right section, i.e. the index of the first true element. If there is no true element, return -1.
    
    Input: arr = [false, false, true, true, true]
    Output: 2

    Explanation: first true's index is 2.
'''
def findBoundary(arr):
    low = 0               # Initialize the low pointer to the beginning of the list.
    high = len(arr) - 1   # Initialize the high pointer to the end of the list.
    bv = -1               # Initialize bv (boundary value) to -1.

    while low <= high:
        mid = low + (high - low) // 2  # Calculate the middle index.

        if not arr[mid]:
            # If the element at the middle index is 'false',
            # it means that the last 'true' value should be on the right side.
            low = mid + 1               # Move the low pointer to the right of mid.
        else:
            # If the element at the middle index is 'true',
            # update bv to the current middle index and continue searching on the left side.
            bv = mid                    # Update bv to the current middle index.
            high = mid - 1              # Move the high pointer to the left of mid.

    # The loop ends when low > high, indicating that the search is complete.
    # bv contains the index of the last 'true' value encountered.
    return bv

arr = [False, False, False, True, True, True, True]
boundary = findBoundary(arr)
print("Boundary Index:", boundary)
