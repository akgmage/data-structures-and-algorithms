/* Name : Rajeev Kumar
Github username : Tonystart121
Repository name : data-structures-and-algorithms
Problem : Searching in 2D sorted array in C++
Issue Number : #273
Problem statement : Given a sorted matrix mat[n][m] and an element ‘x’. Find the position of x in the matrix if it is present, else print -1.

Sample testcases: 

Testcase 1 --> 

Input: number of rows(n) and column(m).Let n=3,m=3 and value to search x = 20 .
arr[n][m] =  { {1, 5, 9},
              {14, 20, 21},
               {30, 34, 43} }

Output: found at (1,2);

Testcase 2 -->
Input: number of rows(n) and column(m).Let n=3,m=4 and value to search x = 43
arr[n][m] = { {1, 5, 9, 11},
              {14, 20, 21, 26},
              {30, 34, 43, 50} }
Output: Found at (2,3);

Time Complexity = O(n+m)
Space Complexity = O(n+m)


Explanation:
This code asks the user to enter the number of rows and column in the array and element to find in the array, and then prompts them to enter each element of the array one at a time. Once the array is complete, the code applies the linear search/mapping algorithm to find the element within the array, and then prints the position of that element to the console.

Start at the top left corner of the matrix.
Compare the target element to the element at the current position.
If the target element is equal to the element at the current position, then return the current position.
If the target element is less than the element at the current position, then move down one row.
If the target element is greater than the element at the current position, then move right one column.
Repeat steps 2-5 until the target element is found or the entire matrix has been searched.
*/

// ----------------------------------------------------------------------------- code begins now!


#include<bits/stdc++.h>
using namespace std;

int main(){

    // enter array rows and column
    int n,m;
    cin>>n>>m;

    // taking input array.
    int arr[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>arr[i][j];
        }
    }
   
    // taking input value to search.
    int key;
    cin>>key;

    // initializing rightmost element as current element.
    int cr_row =  0, cr_col=m-1;
    bool ans = false;
    while(cr_row<n and cr_col>=0){
        
        // if key==curr output its position
        if(arr[cr_row][cr_col]==key){
            cout<<cr_row<<" "<<cr_col;
            ans=true;
            break;
        }
       
        // if key greater than array elements, row increasing.
        else if(key>arr[cr_row][cr_col]){
            cr_row++;
        }

        // if key less than array elements, col decreasing. 
        else if(key<arr[cr_row][cr_col]){
            cr_col--;
        }
    }

    // if not found outputting -1.
    if(ans==false) cout<<"-1"<<endl;

    return 0;
}