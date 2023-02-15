# Implementation of Bubble sort.
# Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
# that repeatedly steps through the input list element by element,
# comparing the current element with the one after it, swapping their values if needed.
#  These passes through the list are repeated until no swaps had to be performed during a pass,
# meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

# Time Complexity worst-case and average complexity O(n^{2})
# Bubble sort is O(n) on a list that is already sorted i.e. Best case

# Sample Input : [2, 1, 9, 3, 5, 4, 0]
# Output : [0 1 2 3 4 5 9]
data = []
n = int(input("Enter the number of elements"))  # Total number of elements in an array

for i in range(0,n):
    num = int(input()) # Asking user the element of an array
    data.append(num) # Appending the element in an array

data_copy = data[:]  # Making copy of the array data

for i in range(0, len(data_copy)):
    for j in range(0, len(data_copy) - i - 1):
        if(data_copy[j] > data_copy[j + 1]):
            data_copy[j], data_copy[j + 1] = data_copy[j + 1], data_copy[j]

print(data_copy)
print(sorted(data))
