/* OPTIMAL PARTITION OF STRING */
/* PROGRAM AUTHOR : VARUN GARG */
#include<bits/stdc++.h>
using namespace std;

int main(){
      string s;
      cin>>s;

      int cnt=0;
      int n=s.size();
      for(int i=0;i<n;i){
            set<char> sub; 
            // taking the unique substrings in a set 
            while(i<n && sub.find(s[i]) == sub.end()){
                  sub.insert(s[i]); 
                  i++;
            }
            for(auto x: sub){
                  cout<<x<<" ";
            }
            cout<<endl;
            cnt++;
      }

      cout<<"The minimum number of substrings required for partition"<<endl;
      cout<<cnt;
}