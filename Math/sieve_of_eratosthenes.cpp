// In mathematics, the sieve of Eratosthenes is an ancient algorithm for finding all prime numbers up to any given limit.
// It does so by iteratively marking as composite (i.e., not prime) the multiples of each prime, 
// starting with the first prime number, 2. The multiples of a given prime are generated as a sequence of numbers 
// starting from that prime, with constant difference between them that is equal to that prime. 
// This is the sieve's key distinction from using trial division to sequentially test each candidate 
// number for divisibility by each prime. Once all the multiples of each discovered prime have been marked as composites, 
// the remaining unmarked numbers are primes. Source(https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)

// Sample INput: 100
// Output :  2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97

#include<bits/stdc++.h>
using namespace std;
const int nmax = 100001;
bool is_prime[nmax];
void seive_of_ero(int n){
    for(int i = 2; i <= n; i++){
        is_prime[i] = true;
    }
    for(int i = 2; i <= n / 2; i++){
        if(is_prime[i]){
            for(int j = i * 2; j <= n; j += i){
                is_prime[j] = false;
            }
        }
    }
}
int main(){
	int n;
    cin >> n;
    seive_of_ero(n);
    for(int i = 0; i <= 500; i++){
        if(is_prime[i])
        cout << i << " " << endl;
    }
	
return 0;
}
