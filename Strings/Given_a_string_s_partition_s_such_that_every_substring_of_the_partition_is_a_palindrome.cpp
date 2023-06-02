/*
Name : MAnmay Ghosh
Github username : ManmayGhosh
Repository name : data-structures-and-algorithms
Problem :  Given a string s, partition s such that every substring of the partition is a palindrome in C++
Issue Number : #1373

Explanation of the below C++ code :

A string is given, then a partition of the string is a palindrome partitioning if every substring of the partition is a palindrome. 
For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. 
We have to find the minimum cuts needed for a palindrome partitioning of a given string. 
For example, minimum of 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.

Edge Cases
If string is  palindrome, then minimum 0 cuts are needed. 
If string contain all different characters, then minimum n-1 cuts are needed as by atleast 

-------------------------------------------------------------------------//C++ code begins here------------------------------------------------------------------------
*/

// Dynamic Programming Solution for Palindrome Partitioning Problem
#include <bits/stdc++.h>
using namespace std;

// This function returns the minimum number of cuts needed to partition a string such that every part is a palindrome
int minPalPartion(string str)
{
	int n = str.length(); 
	// C[i][j] = Minimum number of cuts needed for palindrome partitioning	of substring str[i..j]
	int C[n][n];
    
	// P[i][j] = true if substring str[i..j] is palindrome, else false
	bool P[n][n];

	// Note that C[i][j] is 0 if P[i][j] is true

	// A string of length 1 will always be palindrome
	for (int i = 0; i < n; i++) {
		P[i][i] = true;
		C[i][i] = 0;
	}

	// L is substring length. Build the	solution in bottom up manner by	considering all substrings of length starting from 2 to n.
	for (int L = 2; L <= n; L++) {
		// For substring of length L, set different possible starting indexes
		for (int i = 0; i < n - L + 1; i++) {
			int j = i + L - 1; // Set ending index

			// If L is 2, then we just need tocompare two characters. 
			if (L == 2)
				P[i][j] = (str[i] == str[j]);
            // Else need to check two corner charactersand value of P[i+1][j-1]
			else
				P[i][j] = (str[i] == str[j]) && P[i + 1][j - 1];

			// IF str[i..j] is palindrome, then C[i][j] is 0
			if (P[i][j] == true)
				C[i][j] = 0;
			else {
				// Make a cut at every possiblen location starting from i to j,n and get the minimum cost cut.
				C[i][j] = INT_MAX;
				for (int k = i; k <= j - 1; k++)
					C[i][j] = min(C[i][j], C[i][k] + C[k + 1][j] + 1);
			}
		}
	}
	// Return the min cut value for complete string. ababbbabbababa
	return C[0][n - 1];
}

// Driver code
int main()
{
	string str;
    cout << "Enter String\t"; 
    cin >> str;
	cout << "Min cuts needed for Palindrome Partitioning is "<< minPalPartion(str);
	return 0;
}

