# Implementation of KMP Algorithm. Program Author : SNEHA CHAUHAN
''' problem: Given a text txt and a pattern pat, write a function search(char pat[], char txt[]) 
    that prints all occurrences of pat[] in txt[]. 

    KMP algorithm is used to find the pattern in the given string. This is naive approach to find 
    the pattern in the given string.

    Time Complexity: O(n*m)
    Space Complexity: O(1)

    Example: 
    input: txt = “AAAABAAABA” pat = “AAAA”
    output: Pattern found at index 0
        
    Algorithm:
    1. Start from the leftmost character of txt and one by one compare it with each character of pat.
    2. If a character matches, then move both txt and pat ahead and compare the next character.
    3. If a mismatch occurs, then move pat to the index where the mismatch occurs and compare again.
    4. If pat reaches its end without any mismatch, then pattern found.

    '''

def search(pat, txt):
    M = len(pat)
    N = len(txt)

    # A loop to slide pat[] one by one
    for i in range(N - M + 1):
        j = 0

        # For current index i, check for pattern match
        for j in range(0, M):
            if (txt[i + j] != pat[j]):
                break

        if (j == M - 1):
            print("Pattern found at index ", i)


# Driver Code
if __name__ == '__main__':
    txt = "AABAACAADAABAAABAA"
    pat = "AABA"
    search(pat, txt)