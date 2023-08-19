// Function to find the number of prime numbers less than n
function countPrimes(n) {
    // Helper function to check if a number is prime
    function isPrime(num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 === 0 || num % 3 === 0) return false;
        for (let i = 5; i * i <= num; i += 6) {
            if (num % i === 0 || num % (i + 2) === 0) return false;
        }
        return true;
    }

    let count = 0;
    for (let i = 2; i < n; i++) {
        if (isPrime(i)) {
            count++;
        }
    }

    return count;
}

// Example usage:
const n = 30; // You can change the value of n
const primeCount = countPrimes(n);
console.log(`Number of prime numbers less than ${n}: ${primeCount}`);
