class Solution {
public:
    bool isPalindrome(int num) {
        
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        
        int reversed = 0;
        while (num > reversed) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        return num == reversed || num == reversed / 10;
    }
};