package main

// IsPalindrome: returns true if supplied string is a palindrome
// Time Complexity: O(n). Space Complexity: O(n/2) ≈ O(n).
func IsPalindrome(s string) bool {
	stack := NewStack(1)
	i, n := 0, len(s)
	// push hald element into stack
	for i < n/2 {
		stack.Push(s[i])
		i++
	}
	// escape mid character
	if n%2 == 1 {
		i++
	}
	// compare other half of string with stack
	for i < len(s) {
		// if element doesn't match, or stack is empty then return false
		if stack.IsEmpty() || s[i] != stack.Pop() {
			return false
		}
		i++
	}
	return true
}