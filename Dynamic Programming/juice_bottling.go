package main

func JuiceBottling(prices []int) []int {
	numSizes := len(prices)
	maxProfit := make([]int, numSizes)
	dividingPoints := make([]int, numSizes)

	for size := 0; size < numSizes; size++ {
		for dividingPoint := 0; dividingPoint < size+1; dividingPoint++ {
			possibleProfit := maxProfit[size-dividingPoint] + prices[dividingPoint]

			if possibleProfit > maxProfit[size] {
				maxProfit[size] = possibleProfit
				dividingPoints[size] = dividingPoint
			}
		}
	}
	solution := []int{}
	currentDividingPoint := numSizes - 1
	for currentDividingPoint > 0 {
		solution = append(solution, dividingPoints[currentDividingPoint])
		currentDividingPoint -= dividingPoints[currentDividingPoint]
	}
	return solution
}
