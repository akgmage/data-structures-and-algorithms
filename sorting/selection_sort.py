#  Implementation of selection sort.
#  Selection sort is an in-place comparison sorting algorithm.
#  It has an O(n^{2}) time complexity which makes it inefficient on large lists,
#  and generally performs worse than the similar insertion sort.
#  Selection sort is noted for its simplicity and has performance advantages
#  over more complicated algorithms in certain situations,
#  particularly where auxiliary memory is limited. (Source wiki) https://en.wikipedia.org/wiki/Selection_sort

#  Sample Input : [2, 1, 9, 3, 5, 4, 0]
#  Output : [0 1 2 3 4 5 9]

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