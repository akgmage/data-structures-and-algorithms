package main

func DiceThrows(numDice int, numSides int, target int) int {
	storedResults := make([][]int, numDice + 1)
    for i := range storedResults {
        storedResults[i] = make([]int, target + 1)
        for j := range storedResults[i] {
            storedResults[i][j] = -1
        }
    }
    return diceThrowsHelper(numDice, numSides, target, storedResults)
}

func diceThrowsHelper(numDice, numSides, target int, storedResults [][]int) int {
    if numDice == 0 {
        if target == 0 {
            return 1
        }
        return 0
    }
    if storedResults[numDice][target] > -1 {
        return storedResults[numDice][target]    
    }
    numWaysToReachTarget := 0
    for currentTarget := max(0, target - numSides); currentTarget < target; currentTarget++ {
        numWaysToReachTarget += diceThrowsHelper(numDice - 1, numSides, currentTarget, storedResults)
    }
    storedResults[numDice][target] = numWaysToReachTarget
    return numWaysToReachTarget
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
