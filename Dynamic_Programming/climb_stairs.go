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

// Variatiom: A child is climbing up a staircase with 􀝊 steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can jump up the stairs.
// Approach similar to above problem
func ClimbStairs2(n int) int {
	// base case
	if n < 3 {
		return n
	}
	cache := make([]int, n)
	// initialize initial 3 values
	cache[0], cache[1], cache[2] = 1, 2, 4
	for i := 3; i < n; i++ {
		// add previous 3 values
		cache[i] = cache[i-1] + cache[i-2] + cache[i - 3]
	}
	return cache[n-1]
}
func main() {
	fmt.Println(ClimbStairs(5))
	fmt.Println(ClimbStairs2(5))
}