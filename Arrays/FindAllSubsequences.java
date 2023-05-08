package SubsequenceAndSubsets;

import java.util.*;

public class FindAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 6, 7, 3, 2};
        ArrayList<ArrayList<Integer>> ans = solve(arr);

        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }
    public static ArrayList<ArrayList<Integer>> solve(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ( (i & (1 << j)) != 0) {
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }


        return ans;
    }
}
