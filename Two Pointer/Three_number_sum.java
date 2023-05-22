import java.util.*;

class Three_number_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i], num2 = nums[j];
                int index = binarySearch(j + 1, nums.length-1, -(num1 + num2), nums);
                if(index >= 0 && index < nums.length && (nums[index] + num1 + num2 == 0)) {
                    List<Integer> triplet = List.of(num1, num2, nums[index]);
                    if(!triplets.contains(triplet)) {
                        pairs.add(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return pairs;
    }

    private int binarySearch(int start, int end, int target, int[] arr) {
        if(start > end) return start;
        int index =  (end - start) / 2 + start;
        if(arr[index] == target) return index;
        else if (arr[index] < target) return binarySearch(index + 1, end, target, arr);
        else return binarySearch(start, index - 1, target, arr);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -3, 5, 2, 6};
        int target = 6;

        List<List<Integer>> ans = threeSum(nums, target);

        System.out.println(ans);
    }
}

// This program is exclusively for sum target of 0