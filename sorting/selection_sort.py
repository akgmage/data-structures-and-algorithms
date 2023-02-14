# Selection sort in Python

# Selection sort is a sorting algorithm that selects the smallest element from an unsorted list in each iteration and places   that element at the beginning of the unsorted list.

# Time complexity = O(n^2) and Space complexity = O(n).

# Sample input = [-2, 45, 0, 11, -9] , Output = [-9, -2, 0, 11, 45]


def selectionSort(array, size):
   
    for step in range(size):
        min_idx = step

        for i in range(step + 1, size):
         
            # to sort in descending order, change > to < in this line
            # select the minimum element in each loop

            if array[i] < array[min_idx]:
                min_idx = i
         
        # put min at the correct position
        (array[step], array[min_idx]) = (array[min_idx], array[step])


data = [-2, 45, 0, 11, -9]
size = len(data)
selectionSort(data, size)
print('Sorted Array in Ascending Order:')
print(data)