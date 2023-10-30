/*
    Fruits into basket
*/
class Solution {
    public int totalFruit(int[] fruits) {
        int longest = 0;           // Initialize a variable to track the longest subarray length
        int max = 0;               // Initialize a variable to store the maximum number of fruits
        int startWindow = 0;       // Initialize the left boundary of the window
        HashMap<Integer, Integer> basket = new HashMap<>(); // Create a HashMap to track fruit counts
        
        for(int endWindow = 0; endWindow < fruits.length; endWindow++) {
            basket.put(fruits[endWindow], basket.getOrDefault(fruits[endWindow], 0) + 1);
            // Add the current fruit to the basket and increment its count
            
            while(basket.size() > 2) {
                basket.put(fruits[startWindow], basket.get(fruits[startWindow]) - 1);
                basket.remove(fruits[startWindow], 0);
                // Adjust the window to maintain at most two fruit types
                startWindow++; // Move the left boundary of the window to the right
            }
            
            max = Math.max(max, (endWindow - startWindow) + 1);
            // Update max with the maximum window size seen so far
        }
        
        return max; // Return the maximum number of fruits that can be collected
    }
}
