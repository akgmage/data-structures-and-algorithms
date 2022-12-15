package main

// A child is climbing a stair case. It takes n steps to reach to the top. Each time child can either climb 1
// or 2 steps. In how many distinct ways can the child climb to the top?
import "fmt"

// ClimbStairs: returns the number of ways in which a child can climb stairs
// Approach: Number of ways to reach kth stair = Number of ways to reach k − 1th stair + Number of ways to reach k − 2th stair
// ClimbStairs(k) = ClimbStairs(k-1) + ClimbStairs(k-2)
func ClimbStairs(n int) int {
	// base case
	if n < 3 {
		return n
	}
	cache := make([]int, n)
	// initialize initial 2 values
	cache[0], cache[1] = 1, 2
	for i := 2; i < n; i++ {
		// add previous 2 values
		cache[i] = cache[i-1] + cache[i-2]
	}
	return cache[n-1]
}

func main() {
	fmt.Println(ClimbStairs(5))
}