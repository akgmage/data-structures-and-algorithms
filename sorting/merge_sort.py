#  In computer science, merge sort (also commonly spelled as mergesort) is an efficient, general-purpose,
#  and comparison-based sorting algorithm. Most implementations produce a stable sort,
#  which means that the order of equal elements is the same in the input and output.
#  Merge sort is a divide-and-conquer algorithm that was invented by John von Neumann in 1945.
#  A detailed description and analysis of bottom-up merge sort appeared in a report by Goldstine and von Neumann as early as 1948.
#  Conceptually, a merge sort works as follows:

#  Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
#  Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list
#  Source(https://en.wikipedia.org/wiki/Merge_sort)

#  Approach: Divide by finding the number mid of the position midway between left and right. Do this step the same
#  way we found the midpoint in binary search
#  Conquer by recursively sorting the subarrays in each of the two subproblems created by the divide step.
#  That is, recursively sort the subarray Arr[left. . mid] and recursively sort the subarray Arr[mid + 1. . right].
#  Combine by merging the two sorted subarrays back into the single sorted subarray Arr[left. . right].

def main():
    # test for merge sort
    a_lst = [3,2,-1,9,0,7,-3,-4,10,9]
    merge_sort(a_lst, 0, 9)
    print(a_lst)

def merge_sort(a_lst: list[int], start: int, n: int) -> None:
    if start < n:
        mid: int = (start + n) // 2
        merge_sort(a_lst, start, mid)
        merge_sort(a_lst, mid + 1, n)
        merge(a_lst, start, mid, n)


def merge(a_lst: list[int], start: int, mid: int, n: int):
    n_left: int = mid - start + 1 # length of left array
    n_right: int = n - mid      # length of right array
    
    left: list[int] = [0] * n_left         # Initialize left and right arrays
    right: list[int] = [0] * n_right

    for idx in range(n_left):   # Fill left and right arrays
        left[idx] = a_lst[start + idx]
    for idx in range(n_right):
        right[idx] = a_lst[mid + idx + 1]

    # Fill the orignal array with the smallest element from either
    # left or right until left or right is empty
    l_idx: int = 0
    r_idx: int = 0
    idx: int = start
    while l_idx < len(left) and r_idx < len(right):
        if left[l_idx] < right[r_idx]:
            a_lst[idx] = left[l_idx]
            l_idx += 1
        else:
            a_lst[idx] = right[r_idx]
            r_idx += 1
        idx += 1

    # Fill the original array with the rest of the elements
    # from the half array that is nonempty

    while l_idx < len(left):
        a_lst[idx] = left[l_idx]
        l_idx += 1
        idx += 1
    while r_idx < len(right):
        a_lst[idx] = right[r_idx]
        r_idx += 1
        idx += 1

if __name__ == "__main__":
    main()  
