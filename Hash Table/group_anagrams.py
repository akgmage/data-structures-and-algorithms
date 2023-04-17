# Group Anagrams
'''
    The function groupAnagrams takes a list of strings as input and returns a list of lists, where each inner list 
    contains a group of anagrams from the input list.

    The function starts by creating an empty dictionary groups to store the groups of anagrams. The keys of the dictionary 
    will be the unique signatures of the anagrams, and the values will be lists of the actual anagrams.

    Then, the function iterates through each string s in the input list strs. For each string, it sorts the characters 
    of the string to get its unique signature sig. If the signature is not already in the dictionary, a new key-value pair 
    is added to the dictionary with the signature as the key and an empty list as the value. Finally, the current 
    string s is appended to the list of its corresponding signature in the dictionary.

    Once all the strings have been processed, the function returns the values of the dictionary as a list of lists, 
    where each inner list contains a group of anagrams from the input list.

    For example, if the input list is ["eat", "tea", "tan", "ate", "nat", "bat"], 
    the function will return [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']], which 
    represents the three groups of anagrams: ['eat', 'tea', 'ate'], ['tan', 'nat'], and ['bat'].

    The time complexity of this implementation is O(n * k log k), where n is the length of the input array and k is the 
    length of the longest string in the array. This is due to the time complexity of sorting each string in the array.

	The space complexity of this implementation is O(n * k), as we need to store each string in the map along with its 
    corresponding group of anagrams.

'''
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
