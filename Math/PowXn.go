/* Implement pow(x, n), which calculates x raised to the power n (i.e., xn). in Go

--- Recursion Approach ---

Example 1:
Input: x = 2, n = 10
Output: 1024

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000

Explanation: 2^(-2) = 1/(2^2) = 1/4 = 0.25
 
*/

package main
import "fmt"

func Pow(x float64, n int) float64 {
    switch {
        case n == 0:  return 1
        case n == 1:  return x
        case n < 0: return Pow(1/x, -n)                
        case n %2 == 0: return Pow(x*x, n/2)        
    }
    return  x*Pow(x*x, n/2)
}

func main() {
    var x float64 = 2
    var y int = 10
    fmt.Print(Pow(x, y))
}