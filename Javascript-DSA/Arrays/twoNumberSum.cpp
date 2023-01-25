
// TODO DNF VARIANT ---> BRUTE FORCE    O(n^2) 

#include<iostream>
using namespace std;

int arr[] = {3, 5, -4, 8, 11, 1, -1, 6, 2};
int len = sizeof(arr) / sizeof(arr[0]);
int targetSum = 10;
int i = 0;
int j = len-1;
int main () {
    
    // for (int i = 0; i < len - 1; i++) 
    // {        
    //    for (int j = i; j < len - 1; j++) {
    //        if (arr[i] + arr[j+1] == target) {
    //            cout << arr[i] << "," << arr[j+1] << endl;
    //            break;
    //        }
    //    }
       
    // }    
    
    while ( i < j ) {
        if ( arr[i] + arr[j] == targetSum) {
            cout << arr[i] << "," << arr[j] << endl;
            i++;
            j--;
        }
        else if ( arr[i] + arr[j] > targetSum) {
            j--;
        }
        else i++;
    }
 }