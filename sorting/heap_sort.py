"""
Sorts a list by converting the list to a max heap which by definition contains the
largest element at the root node which is the first element of the list. Then the 
function exchanges the first element with the last element of the list and heapifies
the root node to bring the largest element of the remaining list back into the first
position. The function continues this operation n-1 (n = length of the list) times
at which point the list is sorted.

Time complexity: O(n*log(n))
"""

def main():
    an_array = [-5, 4, 0, -1, 2, 4, 6, 1, 3, -10, 1, 2]
    heap_sort(an_array)
    print(an_array)

def heap_sort(arr: list[int]) -> None:
    heap_size = len(arr)
    build_max_heap(arr, heap_size)
    source_idx = 0
    for dest_idx in range(len(arr) - 1, 0, -1):
        arr[source_idx], arr[dest_idx] = arr[dest_idx], arr[source_idx]
        heap_size -= 1
        max_heapify(arr, 0, heap_size)

def build_max_heap(arr: list[int], heap_size: int) -> None:
    """Modifies the input array into a max heap. A tree binary tree structure in every node 
    satisfies the property: parent node > left node and parent node > right node"""
    for idx in range((heap_size // 2) - 1, -1, -1):
        max_heapify(arr, idx, heap_size)

def max_heapify(arr: list[int], idx: int, heap_size: int) -> None:
    """
    A recursive function that recursively modifies sub roots
    of the tree indicated by the idx into a max heap
    """
    left_idx = idx + 1
    right_idx = idx + 2
    if left_idx < heap_size and arr[idx] < arr[left_idx]:
        largest = left_idx
    else:
        largest = idx
    if right_idx < heap_size and arr[largest] < arr[right_idx]:
        largest = right_idx
    if largest != idx:
        arr[idx], arr[largest] = arr[largest], arr[idx]
        return max_heapify(arr, largest, heap_size)

if __name__ == "__main__":
    main()