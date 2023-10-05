public class min_number_of_jumps {
    
}
/*
	The given code snippet calculates the minimum number of jumps required to reach the end of an array of integers. 
	Each element in the array represents the maximum distance you can jump from that position.

	Here's a step-by-step explanation of the code:

	1. The function `MinNumberOfJumps` takes an integer array `array` as input and returns the minimum number of jumps 
	required to reach the last element.

	2. The code first checks if the length of the `array` is 1. If so, it means there's only one element, and we don't 
	need any jumps to reach the end. In this case, the function returns 0.

	3. If the array has more than one element, the code proceeds with the jump calculation.

	4. The variables `jumps`, `maxreach`, and `steps` are initialized. `jumps` keeps track of the total number of jumps 
	taken, `maxreach` represents the farthest position that can be reached in a single jump, and `steps` represents the 
	remaining steps until a new jump is required.

	5. The loop starts from the second element (index 1) and iterates until the second-to-last element (index `len(array) - 1`). 
	The reason for stopping at the second-to-last element is that we don't need to take any additional jumps from there, as 
	we are already at the end.

	6. For each iteration, the code checks if the current index plus the value at that index (`i + array[i]`) is greater 
	than the current `maxreach`. If so, it updates `maxreach` to the new value, representing the farthest position that 
	can be reached in a single jump.

	7. It then decrements `steps` by 1, representing the steps taken in the current jump.

	8. If `steps` becomes 0, it means the current jump is completed, and a new jump is required. So, it increments `jumps` 
	by 1 and updates `steps` with the number of steps required to reach the farthest position (i.e., `maxreach - i`).

	9. After the loop completes, the function returns `jumps + 1`. The `+1` is added because the loop doesn't consider the 
	last element in the array (as we don't need an additional jump from there), so we need to add one more jump to reach the last element.

	In summary, the code efficiently calculates the minimum number of jumps required to reach the last element in the array 
	by simulating the jumps and keeping track of the farthest position that can be reached in each jump. The final result 
	is the total number of jumps taken to reach the end.
*/
public static int minNumberOfJumpsOptimal(int[] array) {
    // If the array has only one element, no jumps are needed.
    if (array.length == 1) {
        return 0;
    }

    // Initialize variables to keep track of jumps, maximum reachable position, and remaining steps in a jump.
    int jumps = 0;
    int maxReach = array[0];
    int steps = array[0];

    // Iterate through the array to calculate the minimum number of jumps.
    // We stop at the second-to-last element as we don't need an additional jump from there.
    for (int i = 1; i < array.length - 1; i++) {
        // Update the maximum reachable position if the current position plus the value at that index is greater.
        if (i + array[i] > maxReach) {
            maxReach = i + array[i];
        }

        // Decrement the remaining steps in the current jump.
        steps--;

        // If the current jump is completed (steps becomes 0), calculate the new jump.
        if (steps == 0) {
            // Increment jumps to count the completed jump.
            jumps++;

            // Update steps to the number of steps required to reach the farthest position.
            steps = maxReach - i;
        }
    }

    // The minimum number of jumps to reach the last element is the total number of jumps taken plus one
    // because the loop doesn't consider the last element (as we don't need an additional jump from there).
    return jumps + 1;
}
