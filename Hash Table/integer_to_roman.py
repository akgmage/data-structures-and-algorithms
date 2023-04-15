def intToRoman(num: int) -> str:
    # define the mapping of values to symbols
    symbols = {1: 'I', 4: 'IV', 5: 'V', 9: 'IX', 10: 'X', 40: 'XL', 50: 'L',
               90: 'XC', 100: 'C', 400: 'CD', 500: 'D', 900: 'CM', 1000: 'M'}
    
    # create a list of keys in descending order
    keys = sorted(symbols.keys(), reverse=True)
    
    # initialize an empty string to store the roman numeral representation
    roman = ''
    
    # iterate through the keys and subtract the largest value from the number
    # until the number is 0
    for k in keys:
        while num >= k:
            roman += symbols[k]
            num -= k
    
    return roman
