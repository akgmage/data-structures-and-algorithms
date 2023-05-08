package Searching;

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        System.out.println(binarySearchRecursion(array, target, 0, array.length - 1));
    }
    public static int binarySearch(int array[], int target, int left, int right) {
        // O(log(n)) time | O(1) space
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int potentialMatch = array[mid];
            if(target == potentialMatch) return mid;
            else if(target < potentialMatch) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static int binarySearchRecursion(int array[], int target, int left, int right) {
        // O(log(n)) time | O(log(n)) space
        if(left > right) return -1;
        int mid = left + (right - left) / 2;
        int potentialMatch = array[mid];
        if(target == potentialMatch) return mid;
        else if(target < potentialMatch)
            return binarySearchRecursion(array, target, left, mid - 1);
        else
            return binarySearchRecursion(array, target, mid + 1, right);
    }
}
