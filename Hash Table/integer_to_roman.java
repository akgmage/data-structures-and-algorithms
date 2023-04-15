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
