/* OPTIMAL PARTITION OF STRING */
/* PROGRAM AUTHOR : VARUN GARG */

/*

      Our task is to partition the string into one or more substrings such that the characters in each substring are unique.

      Approach:
      Intuitively, we can consider adding characters to a substring as long as we don't see a character 
      that has already been added to the current substring. When we see a character that is already
      present in the substring, we start a new substring and repeat this process until we iterate over the entire string s.
      we are declaring a set in which if the character is not present in the set then the character will be inserted in it 
      else it will break from the loop then the count of the strings will be increased .


      sample input : abacaba
      sample output : a b 
                      a c
                      a b
                      a
                      The minimum number of substrings required for partition
                      4

      Time Complexity: O(n)
      Space Complexity: O(n)
*/
#include<bits/stdc++.h>
using namespace std;

int main(){
      string s;
      cin>>s; // taking input of the string 

      int cnt=0;
      int n=s.size();
      for(int i=0;i<n;i){
            // declaring the set in which characters will be inserted by checking if they were present or not
            set<char> sub; 
            // taking the unique substrings in a set by checking the character is present in the set or not 
            while(i<n && sub.find(s[i]) == sub.end()){
                  sub.insert(s[i]); 
                  i++;
            }
            for(auto x: sub){
                  cout<<x<<" ";
            }
            cout<<endl;
            cnt++; // counting the unique substrings 
      }

      cout<<"The minimum number of substrings required for partition"<<endl;
      cout<<cnt;
}