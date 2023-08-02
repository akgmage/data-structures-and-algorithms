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
