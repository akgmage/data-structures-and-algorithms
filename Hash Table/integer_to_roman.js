// Integer to Roman
/*
    This solution uses a greedy approach to build the roman numeral string by subtracting the maximum 
    possible value at each step until the input number is zero. The time complexity of this implementation 
    is O(1) since there is a fixed number of roman numerals and the loop will always run 13 times. 
    The space complexity is also O(1) since we only store a single string.
*/
function intToRoman(num) {
  // Create arrays for the symbols and their values
  const symbols = [
    "M",
    "CM",
    "D",
    "CD",
    "C",
    "XC",
    "L",
    "XL",
    "X",
    "IX",
    "V",
    "IV",
    "I",
  ];
  const values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];

  let result = ""; // Initialize an empty string to store the roman numeral

  // Loop through the values array
  for (let i = 0; i < values.length; i++) {
    // While the input num is greater than or equal to the current value
    while (num >= values[i]) {
      result += symbols[i]; // Add the corresponding symbol to the result string
      num -= values[i]; // Subtract the value from the input num
    }
  }

  return result; // Return the roman numeral string
}
