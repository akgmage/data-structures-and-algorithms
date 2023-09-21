  
'''
    Heap sort is a sorting algorithm that works by transforming an unsorted list into a heap data structure, 
    which is a binary tree where each parent node is greater than or equal to its children if any.
    then it repeatedly extracts the maximum element from the heap and puts it into its correct sorted position until the whole list is sorted.

    Sample_input : [5,16,8,14,20,1,26]
    Sample_output : [1,5,8,14,16,20,26]

    Here's how the algorithm works:

    The heap_sort function takes an unsorted list arr as input.
    It starts by building the initial heap by calling the heapify function on each parent node in the tree. 
    It does this by iterating over the parent nodes in reverse order starting from the last parent node,
    and calling heapify on each of them. This builds a heap where each parent node is greater than or equal to its children.
    It then repeatedly extracts the maximum element from the heap and puts it into its correct sorted position. 
    It does this by swapping the maximum element which is always at the root of the heap with the last element in the heap, 
    and then calling heapify on the root node to restore the heap property.
    Finally, it returns the sorted list.

  '''
def heap_sort(arr):
    # Build the initial heap
    n = len(arr)
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    
    # Extract the maximum element repeatedly
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0] # Swap
        heapify(arr, i, 0)
    
    return arr

def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2
    
    # Check if left child is larger than root
    if left < n and arr[left] > arr[largest]:
        largest = left
    
    # Check if right child is larger than root
    if right < n and arr[right] > arr[largest]:
        largest = right
    
    # Swap if necessary and heapify the affected subtree
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)
