'''
    Implement an algorithm to determine if a string has all unique characters.
    what if you cannot use additional data structures?
    
    Explanation:
   - The `is_unique_using_bit_vector` function takes a string `s` as input and returns a boolean value indicating whether the string has all unique characters.
   - The variable `checker` is initialized as an integer, representing the bit vector to keep track of character occurrences.
   - The function iterates over each character `c` in the string using a for loop.
   - For each character, the variable `val` is computed by subtracting the ASCII value of `'a'` from the ASCII value of the character. This gives the corresponding index (0-25) for lowercase alphabetic characters.
   - The program checks if the bit at position `val` in `checker` is already set. If it is, it means the character has occurred before, and the function returns `False`.
   - If the character is unique, the bit at position `val` in
'''
def is_unique_using_bit_vector(s):
    checker = 0  # Bit vector to keep track of character occurrences
    for c in s:
        val = ord(c) - ord('a')  # Convert character to corresponding index (0-25)
        if (checker & (1 << val)) > 0:
            # If the bit corresponding to the character is already set, it means the character has occurred before
            return False
        checker |= (1 << val)  # Set the bit corresponding to the character to mark its occurrence
    return True

s = "ABCDD"
t = "ABCD"
u = "AAAAAABCD"
msg = is_unique_using_bit_vector(s)
print(msg)
msg = is_unique_using_bit_vector(t)
print(msg)
msg = is_unique_using_bit_vector(u)
print(msg)

msg = is_unique_using_bit_vector("aa")
print(msg)
