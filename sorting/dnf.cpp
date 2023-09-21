/*

The Dutch National Flag algorithm is used to sort an array containing elements with values of 0, 1, and 2. The goal is to rearrange the elements in-place so that all the 0s are grouped at the beginning, followed by all the 1s, and finally all the 2s.

The algorithm uses three pointers: low, mid, and high. The low pointer represents the boundary of the 0s section, the mid pointer scans the array, and the high pointer represents the boundary of the 2s section.

The algorithm iterates through the array and performs the following operations:

    1. If the element at the mid pointer is 0, it is swapped with the element at the low pointer, and both pointers are incremented.
    2. If the element at the mid pointer is 1, it is already in the correct section, so the mid pointer is simply incremented.
    3. If the element at the mid pointer is 2, it is swapped with the element at the high pointer, and the high pointer is decremented.

The iteration continues until the mid pointer crosses the high pointer, indicating that all elements have been processed.

After the algorithm finishes, the array will be sorted according to the Dutch National Flag problem requirements, with all 0s at the beginning, followed by 1s, and finally 2s. The sorting is done in-place, meaning it does not require any additional space.

The time complexity of the Dutch National Flag algorithm is O(n), where n is the length of the array, as we only need to iterate through the array once. The space complexity is O(1) since no extra space is used apart from the input array.

Consider an array: [1, 2, 0, 2, 1, 0].

The algorithm uses three pointers: low, mid, and high. Initially, low = 0, mid = 0, and high = 5.

    Iterate while mid <= high:
        If the element at mid is 0, swap it with the element at low, increment both low and mid.
        If the element at mid is 1, increment mid.
        If the element at mid is 2, swap it with the element at high, decrement high.

After applying the algorithm, the sorted array will be: [0, 0, 1, 1, 2, 2].

In this example, the algorithm moves all the 0s to the beginning, followed by the 1s, and finally the 2s, achieving the desired sorting according to the Dutch National Flag problem requirements.
*/

#include <iostream>
#include <vector>

std::vector<int64_t> DutchNationalFlag(std::vector<int64_t>& array) {
    int low = 0;        // Initialize the low pointer to the beginning of the array
    int mid = 0;        // Initialize the mid pointer to the beginning of the array
    int high = array.size() - 1;  // Initialize the high pointer to the end of the array

    while (mid <= high) {
        switch (array[mid]) {
            case 0:
                // If the value at mid is 0, swap it with the value at low
                std::swap(array[low], array[mid]);
                low++;  // Increment low to move forward
                mid++;  // Increment mid to move forward
                break;
            case 1:
                // If the value at mid is 1, no swapping needed, just move mid forward
                mid++;
                break;
            case 2:
                // If the value at mid is 2, swap it with the value at high
                std::swap(array[mid], array[high]);
                high--;  // Decrement high to move backward
                break;
        }
    }

    return array;
}

int main() {
    std::vector<int64_t> array = {2, 0, 1, 1, 0, 2, 2, 1, 0};
    std::vector<int64_t> sortedArray = DutchNationalFlag(array);

    std::cout << "Sorted Array: ";
    for (int64_t num : sortedArray) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}
