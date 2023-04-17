def groupAnagrams(strs):
    # create a dictionary to store the groups of anagrams
    groups = {}
    
    # iterate through each string in the list
    for s in strs:
        # sort the characters of the string to get its unique signature
        # for example, "eat" and "ate" both have the same signature "aet"
        sig = ''.join(sorted(s))
        
        # check if the signature is already in the dictionary
        # if not, add a new key-value pair with an empty list as the value
        if sig not in groups:
            groups[sig] = []
        
        # append the current string to the list of its corresponding signature
        groups[sig].append(s)
    
    # return the values of the dictionary as a list of lists
    return list(groups.values())
