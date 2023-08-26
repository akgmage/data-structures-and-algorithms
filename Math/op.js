function divide(dividend, divisor) {
    // Handle special cases
    if (divisor === 0) {
        throw new Error("Division by zero");
    }
    if (dividend === 0) {
        return 0;
    }
    
    // Determine the sign of the result
    const negativeResult = (dividend < 0) ^ (divisor < 0);
    
    // Make dividend and divisor positive for easier calculations
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    
    let quotient = 0;
    
    while (dividend >= divisor) {
        dividend -= divisor;
        quotient++;
    }
    
    if (negativeResult) {
        quotient = -quotient;
    }
    
    // Check for overflow
    if (quotient < -(2**31) || quotient > 2**31 - 1) {
        return 2**31 - 1; // Return INT_MAX for overflow
    }
    
    return quotient;
}

// Example usage:
const dividend = 10;
const divisor = 3;
const result = divide(dividend, divisor);
console.log(result); // Output should be 3
