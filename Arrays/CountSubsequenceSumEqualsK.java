package SubsequenceAndSubsets;

import java.util.ArrayList;

public class CountSubsequenceSumEqualsK {
        public static void main(String[] args) {
            int[] arr = {-1, 4, 6, 7, 3, 2};
            ArrayList<ArrayList<Integer>> ans = solve(arr, 10);

            for (ArrayList<Integer> list : ans) {
                System.out.println(list);
            }
        }
        public static ArrayList<ArrayList<Integer>> solve(int[] arr, int k) {
            // O((2^N)*N)) time | O((2^N)*N)) space
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            int n = arr.length;
            for (int i = 0; i < (int) Math.pow(2, n); i++) {
                ArrayList<Integer> list = new ArrayList<>();
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if ( (i & (1 << j)) != 0) {
                        list.add(arr[j]);
                        sum += arr[j];
                    }
                }
                if (sum == k) {
                    ans.add(list);
                }
            }


            return ans;
        }
}

