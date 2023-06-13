'''
    Write a function that takes in an array of at least three integers and,
    without sorting the input array, returns a sorted array of the three largest
    integers in the input array.

    Explanation:

    This code defines a function called `FindThreeLargestNumbers` that takes an array of integers as input and
    returns an array of the three largest integers in the input array.

    The `triplets` array is initialized with three smallest possible values. Then, the function iterates through
    the input array using a `for` loop and calls the `updateLargest` function to update the `triplets` array with
    the current number if it is larger than one of the values in the array.

    The `updateLargest` function takes two arguments: `triplets` and `num`. It first checks if `num` is greater
    than the third value in the `triplets` array. If so, it calls the `shiftAndUpdate` function to update the
    `triplets` array with the current number at the third index.

    If `num` is not greater than the third value in the `triplets` array, it checks if `num` is greater than the second value in the `triplets` array.

    If so, it calls the `shiftAndUpdate` function to update the `triplets` array with the current number at
    the second index. Finally, if `num` is not greater than either the third or second value in the `triplets`
    array, it checks if `num` is greater than the first value in the `triplets` array.

    If so, it calls the `shiftAndUpdate` function to update the `triplets` array with the current number at
    the first index.

    The `shiftAndUpdate` function takes three arguments: `triplets`, `num`, and `idx`. It iterates through the
    `triplets` array using a `for` loop and shifts each value to the left by one position until it reaches
    the `idx` index. Then it updates the value at the `idx` index with the current number `num`.

    Time and Space complexity : O(n) time | O(1) space - where n is the length of the input array

'''
def find_three_largest_numbers(array):
    # Initialize a list to hold the three largest numbers, starting with negative infinity
    triplets = [float('-inf'), float('-inf'), float('-inf')]
    
    # Iterate through each number in the input array
    for num in array:
        # Call the update_largest function to determine if the number should be included in the triplet
        update_largest(triplets, num)
    
    # Return the list containing the three largest numbers
    return triplets


def update_largest(triplets, num):
    # If the number is larger than the third-largest element in the triplet
    if num > triplets[2]:
        # Shift the other elements to make room and add the number as the new third-largest element
        shift_and_update(triplets, num, 2)
    # Otherwise, if the number is larger than the second-largest element
    elif num > triplets[1]:
        # Shift and update the triplet accordingly
        shift_and_update(triplets, num, 1)
    # Otherwise, if the number is larger than the first-largest element
    elif num > triplets[0]:
        # Shift and update the triplet accordingly
        shift_and_update(triplets, num, 0)


def shift_and_update(triplets, num, idx):
    # Iterate through the elements of the triplet
    for i in range(idx + 1):
        # If the loop reaches the specified index, add the new number to the triplet
        if i == idx:
            triplets[i] = num
        # Otherwise, shift the elements to the right
        else:
            triplets[i] = triplets[i + 1]


# Test the find_three_largest_numbers function
array = [1, 5, 2, 9, 10, 3]
result = find_three_largest_numbers(array)
print(result)
