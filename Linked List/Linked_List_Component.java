


/**PROBLEM
 * You are given the head of a linked list containing unique integer values and an integer array nums
 *that is a subset of the linked list values.

*Return the number of connected components in nums where two values are connected if
 *they appear consecutively in the linked list.
*/

// SAMPLE I/O
// Input: head = [0,1,2,3], nums = [0,1,3]
// Output: 2
// Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.

// Approach
/**
 * Creating a HashMap to store all the values of nums[]
 * Iterating list and if current node(head) we check if the hashmap contains the value]
 * if yes the we increment the ans by one and setting the flag to false 
 * 
 * 
 * 
 * Time Complexity: O(N)
 * Space Complexity : O(N)
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        // Create a HashMap to store the values from nums as keys and their indices as values
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        
        boolean flag = true; // Flag to track if a connected component is found
        int ans = 0; // Variable to store the number of connected components
        
        // Traverse the linked list
        while (head != null) {
            // Check if the current node's value is present in the HashMap
            while (head != null && hm.containsKey(head.val)) {
                head = head.next; // Move to the next node
                
                // If this is the start of a new connected component, increment the answer
                if (flag) {
                    ans += 1;
                    flag = false;
                }
            }
            flag = true; // Reset the flag
            
            if (head != null) {
                head = head.next; // Move to the next node
            }
        }
        
        return ans;
    }
}
