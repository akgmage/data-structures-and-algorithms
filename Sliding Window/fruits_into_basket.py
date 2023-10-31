'''
    Fruits into basket
    Summary:
    The given code defines a Java class `Solution` with a method `totalFruit` that solves a problem related to collecting fruits 
    from fruit trees while adhering to a constraint of collecting fruits from at most two different types of fruit trees. 
    The code uses a sliding window approach to find the maximum number of fruits that can be collected from the trees under 
    this constraint.

    - The `fruits` array represents the types of fruit trees, where each element represents a type of fruit.

    - The code initializes variables `longest` and `max` to keep track of the length of the longest subarray with at 
    most two distinct elements and the maximum number of fruits collected, respectively.

    - The `startWindow` variable represents the left boundary of the sliding window.

    - A `HashMap` called `basket` is used to keep track of the count of each type of fruit in the current window.

    - The code iterates through the `fruits` array using two pointers, `startWindow` and `endWindow`, to traverse 
    the array from left to right.

    - Within the loop, the code updates the `basket` map with the count of fruit types in the current window, and it 
    ensures that there are at most two different types of fruits in the window by adjusting the window as needed.

    - The `max` variable is updated with the maximum window size seen so far.

    - Finally, the method returns `max`, which represents the maximum number of fruits that can be collected under 
    the given constraint.

    Space Complexity:
    - The space complexity of this code is O(1) in addition to the input `fruits` array. This is because the space used 
    for variables such as `longest`, `max`, `startWindow`, and `basket` remains constant and does not depend on the size 
    of the `fruits` array.

    Time Complexity:
    - The time complexity of this code is O(n), where 'n' is the length of the `fruits` array. The code iterates through the 
    `fruits` array once with two pointers, and the work done within each iteration is constant time. Therefore, the overall 
    time complexity is linear in the size of the input array.
'''
class Solution:
    def totalFruit(self, fruits):
        longest = 0            # Initialize a variable to track the longest subarray length
        max_fruits = 0          # Initialize a variable to store the maximum number of fruits
        start_window = 0       # Initialize the left boundary of the window
        basket = {}            # Create a dictionary to track fruit counts

        for end_window in range(len(fruits)):
            basket[fruits[end_window]] = basket.get(fruits[end_window], 0) + 1
            # Add the current fruit to the basket and increment its count

            while len(basket) > 2:
                basket[fruits[start_window]] -= 1
                if basket[fruits[start_window]] == 0:
                    del basket[fruits[start_window]]
                # Adjust the window to maintain at most two fruit types
                start_window += 1  # Move the left boundary of the window to the right

            max_fruits = max(max_fruits, (end_window - start_window) + 1)
            # Update max_fruits with the maximum window size seen so far

        return max_fruits  # Return the maximum number of fruits that can be collected
