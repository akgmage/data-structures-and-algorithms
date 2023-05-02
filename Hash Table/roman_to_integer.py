# Roman to Integer
'''
    The function takes a string s as an input and returns the corresponding integer value
    by converting the string from Roman numerals to its integer value.

    It does this by iterating through the string. If the current character has a lower
    value than the character after it, the current character value is subtracted from
    the total, so that it is added correctly.

    Otherwise, the current character value is added to the total.

    Finally, the total integer value is returned.
'''

def roman_to_int(s: str) -> int:
    # define mapping of values to symbols
    symbols = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }

    # initialise integer to return total value
    total = 0

    # iterate through characters
    for i in range(len(s) - 1):
        # if the symbol after current symbol is less than it,
        # subtract it from the total value
        if symbols[s[i]] < symbols[s[i+1]]:
            total -= symbols[s[i]]
        # else, just add the corresponding value
        else:
            total += symbols[s[i]]
    # add the last value
    total += symbols[s[-1]]

    return total