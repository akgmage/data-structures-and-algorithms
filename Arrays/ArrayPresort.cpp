def find_unique_elements(arr):
    arr.sort()  # Sort the array

    unique_elements = []

    # Iterate through the sorted array
    for i in range(len(arr)):
        # Check if the current element is different from its neighbors
        if i == 0 or arr[i] != arr[i - 1]:
            unique_elements.append(arr[i])

    return unique_elements

# Example usage
my_array = [4, 2, 4, 1, 2, 6, 3, 3]
unique_elements = find_unique_elements(my_array)
print(unique_elements)  # Output: [1, 2, 3, 4, 6]
