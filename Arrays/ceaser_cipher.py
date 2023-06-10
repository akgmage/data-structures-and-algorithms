'''
    Given a non-empty string of lowercase letters and a non-negative integer
    representing a key, write a function that returns a new string obtained by
    shifting every letter in the input string by k positions in the alphabet,
    where k is the key.

    Note that letters should "wrap" around the alphabet; in other words, the
    letter z shifted by one returns the letter a

    Sample Input : abz key: 3
    Output: dec

    Explanation:

    The CaesarCipherEncryptor function takes a string and a key (integer) as input and returns a new string
    obtained by shifting each character of the input string by the key number of positions to the right in
    the alphabet, wrapping around if necessary.

    The function first calculates the shift amount and offset value. The shift amount is calculated by taking
    the key modulo 26, which ensures that the shift amount is always within the range of 0 to 25. The offset
    value is calculated by taking 26, which is the number of letters in the alphabet.

    The function then converts the input string to a rune slice (for ease of manipulation). A rune is a single
    character in a programming language. The rune type is used to represent characters in Go.

    The function then iterates over each character in the rune slice. For each character, the function checks

    if the character is a lowercase letter and if shifting it will still be within the lowercase range.

    If the character is a lowercase letter and shifting it will still be within the lowercase range, the
    function simply adds the shift amount to the character. If the character is outside of the lowercase range after shifting, the function wraps it around by adding the shift amount - offset to the character.

    The function then updates the character in the rune slice.

    The function then converts the resulting rune slice back to a string and returns it.

    The time complexity of the CaesarCipherEncryptor function is O(n), where n is the length of the input string.
    This is because the function iterates over each character in the input string, performing a constant amount
    of work for each character.

    The space complexity of the CaesarCipherEncryptor function is O(n), where n is the length of the input string.
    This is because the function creates a new rune slice to store the encrypted string. The rune slice is the
    same size as the input string, so the space complexity is O(n).
'''
# Python

def caesar_cipher_encryptor(str, key):
  # Calculate the shift amount and offset value
  shift = key % 26
  offset = 26

  # Convert the input string to a list of characters
  chars = list(str)

  # Iterate over each character in the list
  for i in range(len(chars)):
    # If the character is a lowercase letter and shifting it will still be within the lowercase range
    if chars[i] >= 'a' and chars[i] + shift <= 'z':
      chars[i] += shift
    else:
      # If the character is outside of the lowercase range after shifting, wrap it around
      chars[i] += shift - offset

  # Convert the resulting list of characters back to a string and return it
  return ''.join(chars)

