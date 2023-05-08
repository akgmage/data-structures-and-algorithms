package Strings;

import java.util.*;

public class CountVowels {

    public static  void main(String args[]) {

        String A = "abcdye";

        System.out.println(solve(A));
    }
    public static String solve(String A) {
        String str = "";

        HashMap<Integer, Character> map = new HashMap();
        map.put(1, 'a');
        map.put(2, 'e');
        map.put(3, 'i');
        map.put(4, 'o');
        map.put(5, 'u');

        for(int i = 0; i < A.length(); i++) {
            if(map.containsValue(A.charAt(i)))
                str += A.charAt(i);
        }
        return str;
    }
}

