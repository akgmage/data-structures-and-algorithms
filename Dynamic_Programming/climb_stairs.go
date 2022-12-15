package main

// A child is climbing a stair case. It takes n steps to reach to the top. Each time child can either climb 1
// or 2 steps. In how many distinct ways can the child climb to the top?
import "fmt"

func ClimbStairs(n int) int {
	if n < 3 {
		return n
	}
	cache := make([]int, n)
	cache[0], cache[1] = 1, 2
	for i := 2; i < n; i++ {
		cache[i] = cache[i-1] + cache[i-2]
	}
	return cache[n-1]
}

func main() {
	fmt.Println(ClimbStairs(5))
}