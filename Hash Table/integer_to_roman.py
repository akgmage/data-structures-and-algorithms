# Integer to Roman
'''
    The function takes an integer num as input and returns the corresponding Roman numeral as a string. 
    The mapping of values to symbols is defined in a dictionary symbols. The keys in the dictionary are 
    the values that can be used to represent Roman numerals, and the values are the symbols themselves.

    The keys are sorted in descending order in a list called keys. This is done so that we can iterate 
    through the keys in descending order and subtract the largest value from num until num is 0.

    We initialize an empty string called roman to store the Roman numeral representation. We then iterate 
    through the keys in keys and subtract the largest value from num until num is less than the current key. 
    We append the corresponding symbol to roman for each value subtracted.

    Finally, we return the string roman, which is the Roman numeral representation of the input integer num.
'''
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
