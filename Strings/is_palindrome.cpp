/*
	is_palindrome in c++
	code by Brian Salkas 
 */

#include<iostream>
// start l and r at the beginning and end of the string
// each time we loop, we incrament l and decrament r
// and check if the 'lth' char of the string is
// equal to the 'rth' char.  
// If they are not equal return false
// we continue looping as long as l is less than r
// if the loop completes without returning false,
// then our string is a palindrome and we return true
bool is_palindrome(std::string const& str) {
	size_t l = 0, r = str.size() - 1;
	while (l < r) {
		if (str[l++] != str[r--]) {
			return false;
		}
	}
	return true;
}
// this function contains identical logic to the iterative one above
// notice the second parameter "size_t l=0", this is a default argument
// this means if you do not pass a second parameter, l will be assigned to
// zero.  on the next line, we assign r to str.size() - 1 - l,
// which means that each time we incrament l we decrament r!
// base case 1: return true if we get to middle without returning false
// base case 2: return false if not palindrome
// recursive case: call function again incramenting l. 
bool is_palindrome_rec(std::string const& str, size_t l=0) {
	size_t r = str.size() -1- l;
	if (r <= l) { // base case 1
		return true;
	}
	if (str[l] != str[r]) { // base case 2
		return false;
	}
	return is_palindrome_rec(str, l+1); // recursive case
}

// driver function with test cases
int main() {
	std::cout << "hello: " << (is_palindrome("hello") ?"true" : "false") << '\n';
	std::cout << "racecar: " << (is_palindrome("racecar") ?"true" : "false") << '\n';
	std::cout << "hello: " << (is_palindrome_rec("hello") ?"true" : "false") << '\n';
	std::cout << "racecar: " << (is_palindrome_rec("racecar") ?"true" : "false") << '\n';
}
