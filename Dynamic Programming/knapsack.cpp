/*
	You're given an array of arrays where each subarray holds two integer values and represents an item;
	the first integer is the item's value, and the second integer is the item's weight.
	You're also given an integer representing the maximum capacity of a knapsack that you have.

	Your goal is to fit items in your knapsack without having the sum of their weights exceed the knapsack's
	capacity, all the while maximizing their combined value. Note that you only have one of each item at your disposal.

	Write a function that returns the maximized combined value of the items that you should pick as well as an array of
	the indices of each item picked.

	Sample Input:= [[1, 2], [4, 3], [5, 6], [6, 7]]
	Output:= [10, [1, 3]] // items [4, 3] and [6, 7]

	Explanation:

	Sure! Let's break down the code step by step:

	1. `KnapsackProblem` function: This function takes in two arguments - `items`, a 2D slice representing the
	   list of items with their values and weights, and `capacity`, an integer representing the maximum weight
	   capacity of the knapsack. It returns an interface slice containing the maximum value that can be achieved
	   and the sequence of items included in the knapsack to achieve that maximum value.

	2. Initializing the `values` array: The function creates a 2D slice called `values` to store the maximum
	   achievable values for different knapsack configurations. The size of this array is `(len(items)+1) x (capacity+1)`,
	   where `(len(items)+1)` represents the number of items, and `(capacity+1)` represents the weight capacity of the knapsack.
	   The `values` array will be filled during the dynamic programming process.

	3. Filling the `values` array: The function iterates through the `items` array and fills the `values`
	   array using dynamic programming. For each item at index `i`, the function calculates the maximum achievable
	   value for all possible capacities from `0` to `capacity`.

	4. Inner loop: The inner loop iterates from `0` to `capacity` and calculates the maximum achievable value for
	   the current item at index `i` and the current capacity `c`.

	5. Updating the `values` array: There are two possibilities for each item:
		a. If the weight of the current item `items[i-1][1]` is greater than the current capacity `c`, we cannot
		   include the item in the knapsack at this capacity. So, we use the value from the previous row `values[i-1][c]`
		   for the current cell `values[i][c]`.
		b. If we can include the current item, we have two choices:
			i. Not include the current item, so the value remains the same as in the previous row `values[i-1][c]`.
			ii. Include the current item, which adds its value `items[i-1][0]` to the value of the knapsack at capacity `c - items[i-1][1]`.
			    We choose the maximum of these two options and update the current cell `values[i][c]`.

	6. Finding the maximum value: Once the `values` array is filled, the maximum achievable value for the knapsack is stored in the
	bottom-right cell `values[len(items)][capacity]`.

	7. Calling `getKnapSackItems` function: The function calls the `getKnapSackItems` function to find the sequence of items included in
	the knapsack to achieve the maximum value.

	8. `getKnapSackItems` function: This function takes in the `values` array and the `items` array as input and returns a slice containing
	the indices of the items included in the knapsack.

	9. Traversing back to find the items: Starting from the bottom-right cell of the `values` array, the function traverses back to find the
	items included in the knapsack. It does this by comparing the value in the current cell `values[i][c]` with the value in the cell above
	`values[i-1][c]`. If the values are the same, it means the current item was not included, so it moves to the previous row. Otherwise,
	it means the current item was included, so it adds the index of the current item `(i-1)` to the `sequence` slice and updates the capacity `c` accordingly.

	10. Reversing the `sequence`: The sequence of items is built in reverse order, so the function uses the `reverse` helper function to
	reverse the order of elements in the `sequence` slice.

	11. Returning the result: The function returns the maximum value and the sequence of items included in the knapsack as an interface slice.

	12. Helper functions: The `max` function is a simple helper function that returns the maximum of two integers, and the `reverse`
	function is used to reverse the order of elements in a slice.

	Time and Space complexity:
	O(nc) time | O(nc) space - where n is the number of items and c is the capacity
*/
#include <vector>
#include <algorithm>

using namespace std;

vector<int> knapsackProblem(vector<vector<int>>& items, int capacity) {
    // Create a 2D vector to store the values of different knapsack configurations.
    vector<vector<int>> values(items.size() + 1, vector<int>(capacity + 1, 0));

    // Iterate through the items and fill the values vector.
    for (int i = 1; i <= items.size(); i++) {
        int currentValue = items[i - 1][0];
        int currentWeight = items[i - 1][1];

        for (int c = 0; c <= capacity; c++) {
            // If the current item's weight is more than the current capacity (c),
            // then we cannot include it, so we use the value from the previous row (i - 1).
            if (currentWeight > c) {
                values[i][c] = values[i - 1][c];
            } else {
                // If we can include the current item, we have two choices:
                // 1. Not include the current item, so the value remains the same as the previous row.
                // 2. Include the current item, which adds its value to the value of the knapsack at capacity (c - currentWeight).
                // We choose the maximum of these two options.
                values[i][c] = max(values[i - 1][c], values[i - 1][c - currentWeight] + currentValue);
            }
        }
    }

    // The value at the bottom-right corner of the values vector represents the maximum achievable value for the knapsack problem.
    int value = values[items.size()][capacity];

    // Call the getKnapSackItems function to find the items that were included in the knapsack to achieve the maximum value.
    vector<int> sequence = getKnapSackItems(values, items);

    // Return the maximum value and the sequence of items included in the knapsack.
    vector<int> result = {value};
    result.insert(result.end(), sequence.begin(), sequence.end());
    return result;
}

// getKnapSackItems is a helper function to find the sequence of items included in the knapsack.
vector<int> getKnapSackItems(vector<vector<int>>& values, vector<vector<int>>& items) {
    vector<int> sequence;
    int i = values.size() - 1;
    int c = values[0].size() - 1;

    // Starting from the bottom-right corner of the values vector,
    // we traverse back to find the items included in the knapsack.
    while (i > 0) {
        if (values[i][c] == values[i - 1][c]) {
            // If the value is the same as in the previous row, it means the current item was not included.
            // So, we move to the previous row without adding the item to the sequence.
            i--;
        } else {
            // If the value is greater than the value in the previous row, it means the current item was included.
            // So, we add the index of the current item (i-1) to the sequence and update the capacity (c) accordingly.
            sequence.push_back(i - 1);
            c -= items[i - 1][1];
            i--;
        }
        // If the capacity becomes 0, it means we have included all the items needed to achieve the maximum value.
        if (c == 0) {
            break;
        }
    }

    // The sequence of items is built in reverse order, so we need to reverse it to get the correct order.
    reverse(sequence.begin(), sequence.end());
    return sequence;
}
