package main

import "fmt"

func coinChangeGreedy(coins []int, target int) int {
    count := 0
    for i := len(coins) - 1; i >= 0; i-- {
        for target >= coins[i] {
            target -= coins[i]
            count++
        }
    }
    return count
}

func main() {
    coins := []int{1, 5, 10, 25}
    target := 36
    result := coinChangeGreedy(coins, target)
    fmt.Printf("Minimum number of coins required to make %d cents: %d\n", target, result)
}
