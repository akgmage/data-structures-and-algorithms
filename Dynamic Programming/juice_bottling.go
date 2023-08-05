package main

func JuiceBottling(prices []int) []int {
	numSizes := len(prices)
	maxProfit := make([]int, numSizes)      // Array to store the maximum profit for each bottle size
	dividingPoints := make([]int, numSizes) // Array to store the dividing points that maximize profit

	// Loop through each bottle size
	for size := 0; size < numSizes; size++ {
		// Loop through possible dividing points for the current size
		for dividingPoint := 0; dividingPoint < size+1; dividingPoint++ {
			// Calculate the possible profit by combining the previous maximum profit
			// with the price at the current dividing point
			possibleProfit := maxProfit[size-dividingPoint] + prices[dividingPoint]

			// Update maxProfit and dividingPoints if the new possible profit is greater
			if possibleProfit > maxProfit[size] {
				maxProfit[size] = possibleProfit
				dividingPoints[size] = dividingPoint
			}
		}
	}

	solution := []int{}
	currentDividingPoint := numSizes - 1
	// Reconstruct the solution by tracing back from the end
	// using the dividing points information
	for currentDividingPoint > 0 {
		solution = append(solution, dividingPoints[currentDividingPoint])
		currentDividingPoint -= dividingPoints[currentDividingPoint]
	}
	return solution
}
