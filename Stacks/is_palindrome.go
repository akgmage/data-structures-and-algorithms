package main

func IsPalindrome(s string) bool {
	stack := NewStack(1)
	i, n := 0, len(s)
	for i < n/2 {
		stack.Push(s[i])
		i++
	}
	if n%2 == 1 {
		i++
	}
	for i < len(s) {
		if stack.IsEmpty() || s[i] != stack.Pop() {
			return false
		}
		i++
	}
	return true
}