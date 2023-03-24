/*
    Given an integer array and a window of size windowSize, find the current maximum value in the window as it slides through the entire array
*/
import java.util.*;

public class SlidingWindowMax {
    public static int[] findMaxSlidingWindow(int[] nums, int windowSize) {
        if (nums == null || windowSize <= 0 || nums.length < windowSize) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - windowSize + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // deque stores the indices of elements in the window

        // process the first window separately
        for (int i = 0; i < windowSize; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[0] = nums[deque.peekFirst()];

        // process the remaining windows
        for (int i = windowSize; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - windowSize) {
                deque.removeFirst(); // remove elements outside the window
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast(); // remove elements smaller than nums[i]
            }
            deque.addLast(i);
            result[i - windowSize + 1] = nums[deque.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;

        int[] maxInWindow = findMaxSlidingWindow(nums, windowSize);

        System.out.println("Max values in sliding window of size " + windowSize + ": ");
        for (int i = 0; i < maxInWindow.length; i++) {
            System.out.print(maxInWindow[i] + " ");
        }
    }
}

---------------Explanation---------------------

This program defines a findMaxSlidingWindow method that takes an array nums and a window size windowSize as input and returns an array containing the maximum value in each sliding window. The method first checks if the input is valid and creates a deque to store the indices of elements in the window.

The method then processes the first window separately by adding the indices of its elements to the deque in decreasing order of their values. This way, the first element in the deque will always be the maximum value in the window. The method stores this maximum value in the first element of the result array.

The method then processes the remaining windows by first removing any elements in the deque that are outside the current window. The method then adds the index of the current element to the deque and removes any elements in the deque that are smaller than the current element. The method stores the maximum value in the window in the corresponding element of the result array.

Finally, the method returns the result array.