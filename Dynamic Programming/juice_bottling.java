/*


Explanation:

1. The function `JuiceBottling` takes an array `prices` as input, where `prices[i]` represents the price of a juice bottle of size `i`.

2. It initializes two arrays, `maxProfit` and `dividingPoints`, both of size `numSizes` (the number of bottle sizes).
These arrays will be used to store information about maximum profit and dividing points.

3. The outer loop iterates through each possible bottle size, from 0 to `numSizes - 1`.

4. The inner loop iterates through possible dividing points for the current bottle size. For each combination of bottle size
and dividing point, it calculates the possible profit by adding the maximum profit from the previous bottle sizes and the
price of the bottle at the current dividing point.

5. If the calculated possible profit is greater than the current maximum profit for the bottle size, it updates both `maxProfit`
and `dividingPoints` arrays.

6. After completing the loops, the function reconstructs the solution by backtracking from the last bottle size to the first.
It appends the recorded dividing points to the `solution` array, which represents the optimal way to divide the bottles.

7. The function returns the `solution` array, which contains the indices of the dividing points that maximize profit.

In summary, the code uses dynamic programming to determine the optimal division of juice bottles to maximize profit.
It calculates the maximum profit for each bottle size and keeps track of the dividing points that lead to the maximum profit.
The solution is then reconstructed by backtracking from the end using the recorded dividing points.
*/

import java.util.ArrayList;
import java.util.List;

public class JuiceBottling {

    public static List<Integer> juiceBottling(int[] prices) {
        int numSizes = prices.length;
        int[] maxProfit = new int[numSizes];        // Array to store the maximum profit for each bottle size
        int[] dividingPoints = new int[numSizes];   // Array to store the dividing points that maximize profit

        // Loop through each bottle size
        for (int size = 0; size < numSizes; size++) {
            // Loop through possible dividing points for the current size
            for (int dividingPoint = 0; dividingPoint < size + 1; dividingPoint++) {
                // Calculate the possible profit by combining the previous maximum profit
                // with the price at the current dividing point
                int possibleProfit = maxProfit[size - dividingPoint] + prices[dividingPoint];

                // Update maxProfit and dividingPoints if the new possible profit is greater
                if (possibleProfit > maxProfit[size]) {
                    maxProfit[size] = possibleProfit;
                    dividingPoints[size] = dividingPoint;
                }
            }
        }

        List<Integer> solution = new ArrayList<>();
        int currentDividingPoint = numSizes - 1;
        // Reconstruct the solution by tracing back from the end
        // using the dividing points information
        while (currentDividingPoint > 0) {
            solution.add(dividingPoints[currentDividingPoint]);
            currentDividingPoint -= dividingPoints[currentDividingPoint];
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        List<Integer> result = juiceBottling(prices);

        System.out.println("Dividing Points for Maximum Profit: " + result);
    }
}
