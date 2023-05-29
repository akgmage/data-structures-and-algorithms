/*
Implementation of KMP Algorithm. 
Program Author : SNEHA CHAUHAN

Problem: Given a text txt and a pattern pat, write a function search(char pat[], char txt[]) 
that prints all occurrences of pat[] in txt[]. 

Appproach:
1. Preprocess pattern to get lps array (longest proper prefix which is also suffix array)
2. Use lps array to traverse the text.
3. Whenever there is a mismatch, move the pointer of pattern based on lps array.
4. If there is a match, move both pointers of text and pattern.

Time Complexity: O(n+m)
Space Complexity: O(n)


*/

#include <bits/stdc++.h>
using namespace std;

void computeLPSArray(char* pat, int M, int* lps);

void KMPSearch(char* pat, char* txt)
{
    int M = strlen(pat);
    int N = strlen(txt);

    int lps[M];

    computeLPSArray(pat, M, lps);

    int i = 0; 
    int j = 0; 
    while (i < N) {
        if (pat[j] == txt[i]) {
            j++;
            i++;
        }

        if (j == M) {
            cout<<"Found pattern at index "<< i - j<<endl;
            j = lps[j - 1];
        }

        else if (i < N && pat[j] != txt[i]) {
            if (j != 0)
                j = lps[j - 1];
            else
                i = i + 1;
        }
    }
}


void computeLPSArray(char* pat, int M, int* lps)
{
    int len = 0;

    lps[0] = 0; 

    int i = 1;
    while (i < M) {
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
            i++;
        }
        else 
        {
            if (len != 0) {
                len = lps[len - 1];
            }
            else 
            {
                lps[i] = 0;
                i++;
            }
        }
    }
}

int main()
{
    char txt[] = "ABABDABACDABABCABAB";
    char pat[] = "ABABCABAB";
    KMPSearch(pat, txt);
    return 0;
}
