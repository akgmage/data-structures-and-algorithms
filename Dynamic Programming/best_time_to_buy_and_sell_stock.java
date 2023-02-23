class Solution {
    public int maxProfit(int[] prices) {
        int minElement = prices[0];
        int maxDiff = 0;
        int size = prices.length;
        for (int i = 0; i < size; i++){
            minElement = Math.min(prices[i], minElement);
            maxDiff = Math.max(prices[i] - minElement, maxDiff);
         }
        return maxDiff;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }
}
