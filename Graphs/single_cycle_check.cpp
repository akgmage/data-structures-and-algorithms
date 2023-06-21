#include <iostream>
#include <vector>

using namespace std;

// Function to check if the given array has a single cycle
bool hasSingleCycle(vector<int>& array) {
    int nextElementVisited = 0;
    int currIdx = 0;

    while (nextElementVisited < array.size()) {
        // Check if more than one element has been visited and current index is back to the starting index (0)
        if (nextElementVisited > 0 && currIdx == 0) {
            return false; // Multiple cycles detected, return false
        }

        nextElementVisited++; // Increment the count of visited elements
        currIdx = getNextIdx(array, currIdx); // Get the index of the next element
    }

    return currIdx == 0; // Return true if all elements have been visited in a single cycle
}

// Function to get the index of the next element in the cycle
int getNextIdx(vector<int>& array, int currIdx) {
    int jump = array[currIdx]; // Get the jump value from the current index
    int nextIdx = (currIdx + jump) % array.size(); // Calculate the index of the next element

    if (nextIdx >= 0) {
        return nextIdx; // Return the next index if it is non-negative
    }

    return nextIdx + array.size(); // Adjust the next index if it is negative (wrapped around to the beginning)
}

int main() {
    // Test cases
    vector<int> array1 = {2, 3, 1, -4, -4, 2};
    cout << "Array 1: " << (hasSingleCycle(array1) ? "true" : "false") << endl;

    vector<int> array2 = {2, 2, -1};
    cout << "Array 2: " << (hasSingleCycle(array2) ? "true" : "false") << endl;

    return 0;
}
