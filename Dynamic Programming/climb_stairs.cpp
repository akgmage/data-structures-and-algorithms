// A child is climbing a stair case. It takes n steps to reach to the top. Each time child can either climb 1
// or 2 steps. In how many distinct ways can the child climb to the top?
#include <iostream>
using namespace std;

// ClimbStairs: returns the number of ways in which a child can climb stairs
// Approach: Number of ways to reach kth stair = Number of ways to reach k − 1th stair + Number of ways to reach k − 2th stair
// ClimbStairs(k) = ClimbStairs(k-1) + ClimbStairs(k-2)
int climbStairs(int n) {
    // Base case
    if (n < 3) {
        return n;
    }
    int cache[n];
    // Initialize initial 2 values
    cache[0] = 1;
    cache[1] = 2;
    for (int i = 2; i < n; i++) {
        // Add previous 2 values
        cache[i] = cache[i - 1] + cache[i - 2];
    }
    return cache[n - 1];
}

// Variation: A child is climbing up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can jump up the stairs.
// Approach similar to the above problem
int climbStairsVariation(int n) {
    // Base case
    if (n < 3) {
        return n;
    }
    int cache[n];
    // Initialize initial 3 values
    cache[0] = 1;
    cache[1] = 2;
    cache[2] = 4;
    for (int i = 3; i < n; i++) {
        // Add previous 3 values
        cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
    }
    return cache[n - 1];
}

int main() {
    cout << climbStairs(5) << endl;
    cout << climbStairsVariation(5) << endl;
    return 0;
}
