// Integer to Roman
/*
    Here, we create two arrays to store the Roman numerals and their corresponding values. We then use a 
    StringBuilder to build the resulting Roman numeral string. We use a while loop to iterate through 
    the values array until the number is reduced to 0. In each iteration, we check if the current value is 
    less than or equal to the number. If it is, we subtract the value from the number and append the 
    corresponding Roman numeral to the StringBuilder. If it's not, we move to the next value. Finally, 
    we return the resulting Roman numeral string.

    The time complexity of this implementation is O(1), since the maximum number of iterations in the 
    while loop is 13 (the length of the values array). The space complexity is also O(1), since we only 
    use a StringBuilder and two constant-size arrays to store the Roman numerals and values.
*/
public static String intToRoman(int num) {
    // Create two arrays to store the Roman numerals and their corresponding values
    String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    StringBuilder sb = new StringBuilder();
    int i = 0;
    
    // Iterate through the values array until the number is reduced to 0
    while (num > 0) {
        // If the current value is less than or equal to the number, subtract the value and append the corresponding Roman numeral
        if (values[i] <= num) {
            num -= values[i];
            sb.append(romanNumerals[i]);
        } else {
            i++;
        }
    }
    
    return sb.toString();
}
