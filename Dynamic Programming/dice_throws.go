/*

    You're given a set of numDice  dice, each with numSides  sides, and a target  integer, which represents a target sum to obtain when
	rolling all of the dice and summing their values. Write a function that returns the total number of dice-roll permutations that sum
	up to exactly that target value. All three input values will always be positive integers. Each of the dice has an equal probability
	of landing on any number from 1 to numSides . Identical total dice rolls obtained from different individual dice rolls (for example,
	[2, 3] vs [3, 2] ) count as different dice-roll permutations. If there's no possible dice-roll combination that sums up to the target
	given the input dice, your function should return 0.

	Sample Input : numDice = 2 numSides = 6 target = 7
	Output:  6  [1, 6], [2, 5], [3, 4], [4, 3], [5, 2], [6, 1]

	Explanation:

	The provided code is a Go implementation of a function called `DiceThrows`, which calculates the number of possible ways to obtain a specific target sum by rolling a given number of dice with a certain number of sides.

	Let's walk through the code:

	1. `DiceThrows` function: This is the main function that initiates the process of calculating the number of ways to reach the target sum.

	- `numDice`: The number of dice available.
	- `numSides`: The number of sides on each die.
	- `target`: The target sum to achieve.

	2. `storedResults`: This is a 2D slice used to store the intermediate results of the recursive calls to avoid redundant calculations. It stores the number of ways to reach the target sum for a specific number of dice and target.

	3. `diceThrowsHelper` function: This is a helper function that performs the recursive calculations to find the number of ways to reach the target sum.

	- `numDice`, `numSides`, and `target`: The same variables as in the main function.
	- `storedResults`: The 2D slice to store the intermediate results.

	4. Base case: The function checks if `numDice` is 0. If so, it means there are no dice left, and it checks if the `target` is also 0. If yes, it returns 1 (a valid way to reach the target sum using no dice). Otherwise, it returns 0 (no valid way to reach the target sum).

	5. Memoization: Before starting the actual calculations, the function checks if the result for the current number of dice and target sum is already calculated and stored in `storedResults`. If so, it directly returns the stored value, avoiding redundant calculations.

	6. Recursive calculation: If the result is not stored, the function proceeds to calculate the number of ways to reach the target sum using the current number of dice.

	- It iterates over all the possible target sums for the current number of dice (`numDice`) based on the possible outcomes from rolling one die (`max(0, target-numSides)` to `target-1`).
	- For each possible target sum (`currentTarget`), it makes a recursive call to `diceThrowsHelper` with `numDice-1` dice, `numSides` sides, and `currentTarget` as the new target sum.
	- It adds up the number of ways to reach `currentTarget` using `numDice-1` dice.

	7. Storing and returning the result: After calculating the total number of ways to reach the target sum, it stores the result in `storedResults` for future use and returns the result.

	8. `max` function: A helper function to find the maximum of two integers.
*/
package main

// DiceThrows calculates the number of ways to obtain a specific target sum
// by rolling a given number of dice with a certain number of sides.
// It calls the helper function diceThrowsHelper for recursive calculations.
func DiceThrows(numDice int, numSides int, target int) int {
	// Create a 2D slice to store intermediate results of recursive calls.
	storedResults := make([][]int, numDice+1)
	for i := range storedResults {
		storedResults[i] = make([]int, target+1)
		for j := range storedResults[i] {
			// Initialize all values to -1 to indicate that they have not been computed yet.
			storedResults[i][j] = -1
		}
	}
	// Call the helper function to perform the actual calculations.
	return diceThrowsHelper(numDice, numSides, target, storedResults)
}

// diceThrowsHelper is a recursive helper function that calculates the number
// of ways to reach the target sum using a specific number of dice.
func diceThrowsHelper(numDice, numSides, target int, storedResults [][]int) int {
	// Base case: If there are no dice left, check if the target sum is also 0.
	if numDice == 0 {
		if target == 0 {
			// Return 1 if the target sum is 0 (a valid way to reach the target sum using no dice).
			return 1
		}
		// Return 0 if the target sum is not 0 (no valid way to reach the target sum).
		return 0
	}

	// Memoization: Check if the result is already computed and stored in storedResults.
	if storedResults[numDice][target] > -1 {
		// If the result is already stored, return it to avoid redundant calculations.
		return storedResults[numDice][target]
	}

	// Recursive calculation: Find the number of ways to reach the target sum using numDice dice.
	numWaysToReachTarget := 0
	for currentTarget := max(0, target-numSides); currentTarget < target; currentTarget++ {
		// Recursively calculate the number of ways to reach the currentTarget using numDice-1 dice.
		numWaysToReachTarget += diceThrowsHelper(numDice-1, numSides, currentTarget, storedResults)
	}

	// Store the result in storedResults for future use.
	storedResults[numDice][target] = numWaysToReachTarget

	// Return the total number of ways to reach the target sum.
	return numWaysToReachTarget
}

// max is a helper function to find the maximum of two integers.
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
