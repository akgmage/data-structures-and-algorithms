class Solution {
public:
    int numberOfSteps(int num) {
        // We initialize the step counter.
        int steps = 0;
        // While the number is still not zero...
        while (num != 0) {
            // ...we check if it is odd or even.
            // If it is even...
            if (num % 2 == 0) {
                // ...we divide it by 2 and increase the step counter.
                num /= 2;
                steps++;
            // If it is odd...
            } else {
                // ...we substract 1 and increase the step counter.
                num -= 1;
                steps++;
            }
        }
        // Finally, we return the step counter.
        return steps;
    }
};
