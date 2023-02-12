#include <bits/stdc++.h>
using namespace std;

//function to solve this problem
int solve(int arr[],int n){
  int count=0;
  for(int i=0;i<n;i++){
    for(int j=i+1;j<n;j++){
      if(arr[i]==arr[j]){
        count++;
      }
    }
  }
  return count;
}


int main() 
{
    int n;//number of elements in array
    cin>>n;
    int arr[n];//defining array
    
    //inputs i.e. array elements--
    for(int i=0;i<n;i++){
      cin>>arr[i];
    }
    
    //printing ans--
    cout<<solve(arr,n);
    
    
    return 0;
}
