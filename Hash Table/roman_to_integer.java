// AUTHOR : Sagar Wadhwa
class Solution {
    public int romanToInt(String s) {
        // Hashmap in java which stores key value pairs. Each key is unique and no key is repeated 
        HashMap<Character,Integer> map = new HashMap<>();

        // Defining the basic rules of mapping from roman numeral to integer numbers.
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        //extract the last character of the string, and find it in the map, store this keys value in the 
        // variable named "res"
        int res = map.get(s.charAt(s.length()-1));

        //iterate over the string from the second last character till the first character. Idea to solve
        // this problem is that in the loop, for every character we check whether the value of the roman 
        // numeral at the i+1 th index is greater than or less than the value of the roman numeral at i th 
        // index. If the value of the roman numeral at the i th index is less than the value of the 
        // roman numeral at i+1 th index, then obviously that means we have to subtract the value of the 
        // roman numeral at the i th index from the result calculated so far. Else we have to add the value 
        // of the roman numeral at the i th index to the result calculated so far. Example: V means five,
        // but if it is IV, then here the value of the roman numeral I is less than the value of the roman 
        // numeral V, so that means subtract I from V (4). If the string is VI, means 6, then here the value of 
        // V is greater than the value of I, so add I in V, that is 6. 
        // Doing so in an iterative fashion and storing the result and then adding or subtracting values 
        // from it accordingly will give us our final result.
        for(int i=s.length()-2;i>=0;i--){

            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res -= map.get(s.charAt(i));
            }else{
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}