/*

	Write a function that takes in an array of unique integers and returns its powerset.

	Sample Input : [1, 2, 3]
	Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]

	Explanation:

	The code snippet represents a function `Powerset` that takes an array of integers as input and returns the powerset
	of the array. The powerset of a set is the set of all possible subsets of that set, including the empty set and the set itself.

	The function `Powerset` calls a helper function `powerset` to perform the actual computation. Here's how the code works:

	1. The `Powerset` function initializes the computation by calling the `powerset` function with the array and the index
	   of the last element in the array (`len(array) - 1`).

	2. The `powerset` function is a recursive function that calculates the powerset. It takes the array and the current
	   index as input.

	3. At each recursive call, the function checks if the index is less than 0. If so, it means all elements have been
	   processed, and it returns a 2D slice containing the empty set as the only subset.

	4. If the index is not less than 0, the function retrieves the element at the current index from the array.

	5. The function recursively calls itself with the array and the index decremented by 1 to generate the subsets without
	   the current element.

	6. It then calculates the length of the subsets generated so far.

	7. Using a loop, the function iterates over the existing subsets and creates new subsets by appending the current element
	   to each subset. The new subsets are added to the existing subset slice.

	8. Finally, the function returns the updated subset slice, which contains all the subsets of the original array.

	By recursively generating subsets while building upon the subsets generated at each step, the function constructs the
	powerset of the given array.

	O(n*2^n) time | O(n*2^n) space - where n is the length of the input array
*/
import java.util.ArrayList;
import java.util.List;

class Main {

    public static List<List<Integer>> powerset(int[] array, int index) {
        // Base case: when the index reaches -1, return a list with an empty subset
        if (index < 0) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
            return subsets;
        }

        int element = array[index];
        // Recursive call to generate the powerset for the elements up to index - 1
        List<List<Integer>> subsets = powerset(array, index - 1);

        // Length of the current subsets list
        int length = subsets.size();

        // Iterate through each subset and create new subsets by adding the current element
        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = subsets.get(i);
            // Create a new subset by making a copy of the current subset
            List<Integer> newSubset = new ArrayList<>(currentSubset);
            // Add the current element to the new subset
            newSubset.add(element);
            // Add the new subset to the existing subsets list
            subsets.add(newSubset);
        }

        // Return the resulting subsets list
        return subsets;
    }

    public static List<List<Integer>> powerset(int[] array) {
        // Call the helper function to generate the powerset starting from the last index
        return powerset(array, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<List<Integer>> subsets = powerset(array);
        
        // Print the subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}


// Iterative approach
public class Powerset {
    public static List<List<Integer>> powerset(int[] array) {
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>()); // Initialize the powerset with the empty subset

        // Iterate over each element in the input array
        for (int ele : array) {
            int length = subset.size(); // Get the current length of the subset

            // Iterate over each existing subset
            for (int i = 0; i < length; i++) {
                List<Integer> currentSubset = new ArrayList<>(subset.get(i)); // Get the current subset

                // Create a new subset by making a copy of the current subset
                List<Integer> newSubset = new ArrayList<>(currentSubset);

                // Add the current element to the new subset
                newSubset.add(ele);

                // Append the new subset to the powerset
                subset.add(newSubset);
            }
        }

        // Return the powerset
        return subset;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<List<Integer>> result = powerset(array);
        System.out.println(result);
    }
}