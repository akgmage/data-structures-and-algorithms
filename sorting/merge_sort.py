# Time Complexity of O(nlogn)

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
