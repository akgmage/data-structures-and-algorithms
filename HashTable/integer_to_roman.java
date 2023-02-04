/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:

1 <= num <= 3999
*/

class Solution {
    public String intToRoman(int num) {
        String ones[] = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX"};
    String tens[] = {"XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        StringBuilder str = new StringBuilder();
        if (num>=1000) {
            int t = num/1000;
            for (int i = 1; i <= t; i++) str.append("M");
            num = num%1000;            
        }
        if (num>=900){
            str.append("CM");
            num = num%900;
        }
        if (num>=500) {
            str.append("D");
            num = num%500;            
        }
        if (num>=400) {
            str.append("CD");
            num = num%400;
        }
        if (num>=100) {
            int t = num/100;
            for (int i = 1; i <= t; i++) str.append("C");
            num = num % 100;
        }
        if (num>=20) {
            str.append(tens[num/10-2]);
            num = num % 10;            
        }
        if (num>0) str.append(ones[num-1]);
        return str.toString();
    }
}