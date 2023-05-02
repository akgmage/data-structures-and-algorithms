

"""
Write a function that takes in an array of at least three integers and, 
without sorting the input array, returns a sorted array of the three largest 
integers in the input array.

# Approach

- We will use three variables to store the three max values and initialize them with int_minimum
- We will iterate through the array and compare the values with the three variables
- If the value is greater than the first variable, we will update the variables
- If the value is greater than the second variable, we will update the variables
- If the value is greater than the third variable, we will update the variables
- Return the three variables as a sorted array

"""



def three_max_no(arr:list)-> list:
    # give int minvalue to a,b,
    max_1,max_2,max_3= -9999,-9999,-9999
    # we will iterate through the array and compare the values
    for i in arr:
        if i > max_1:
            # if the value is greater than the first variable, we will update the variables
            max_1,max_2,max_3 = i, max_1, max_2
        elif i > max_2:
            # if the value is greater than the second variable, we will update the variables
            max_2, max_3 = i, max_2
        elif i > max_3:
            # if the value is greater than the third variable, we will update the variables
            max_3 = i
    # return the three max values as a sorted array
    return [max_1, max_2, max_3]


# example-1
arr=[141,1,17,-7,-17,-27,18,541,8,7,7]
print(three_max_no(arr))

# sample output    [541, 141, 18]
