class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1; // There's only one number with 0 digits, which is 0.
        }
        
        int result = 10; // For n = 1, there are 10 numbers with unique digits (0-9).
        int uniqueDigits = 9;
        int availableDigits = 9;
        
        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigits *= availableDigits;
            result += uniqueDigits;
            availableDigits--;
        }
        
        return result;
    }
};
