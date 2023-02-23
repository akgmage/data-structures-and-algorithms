"""
Implementation of insertion sort in go.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
"""

def main():
    a_lst = [0, 2, 1,-1, 10, 3, 4]
    insertion_sort(a_lst)
    print(a_lst)

# Typing can be changed if needed as python supports comparison
# of types other than int (float, strings, etc.)
def insertion_sort(a_lst: list[int]) -> None:
    for idx in range(1, len(a_lst)):
        value = a_lst[idx]
        position = idx - 1
        while 0 <= position and value < a_lst[position]:
            a_lst[position + 1] = a_lst[position]
            position -= 1
        a_lst[position + 1] = value

if __name__ == "__main__":
    main()
