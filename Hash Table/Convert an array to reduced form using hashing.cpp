/*Declare an array of name ar[ ] with n elements
Create a temp[ ] array of size n
Create a hashmap for the same datatype of the array
Copy the elements of array ar [ ] to temp[ ] array
Sort the temp[ ] array in ascending order
After sorting, mapping the values from 0 to n-1 with the temp array.
Replace the ar[ ] element with the hashtable values.
Print the ar[ ] */








#include<bits/stdc++.h>
using namespace std;
int main()
{
    int ar[] = {12,34,5,6,8};

    /* calculating the size of the given array */
    int size = sizeof(ar)/sizeof(ar[0]);

     /* creating temp array to sort and manipulate the array*/
    int temp[size],val=0;

     /* creating an unordered_map*/
    unordered_map<int,int> mapped;


     /* copying the elements from ar to temp array*/
    for(int i=0;i<size;i++)
    {
        temp[i] = ar[i];
    }

     /*sorting the temp array using the sort method*/
    sort(temp,temp+size);


     /*mapping the values*/
    for(int i=0;i<size;i++)
    {
        mapped[temp[i]] = val++;
    }


     /* reducing the elements of original array and printing them*/
    cout<<"Reduced array:"<<endl;
    for(int i=0;i<size;i++)
    {
        ar[i] = mapped[ar[i]];
        cout<<ar[i]<<" ";
    }
}
 

Python

if __name__ == '__main__':
     ar =[12,34,5,6,8]
     print("Given array: ",ar)
     size = len(ar)
     val = 0
     #copying the elements in tmp array using the copy method
     tmp = ar.copy()
     #sorting the tmp array
     tmp.sort()
     #creating the map
     mapvalues = {}
     
     #mapping the reduced values
     for i in range(size):
         mapvalues[tmp[i]] = val
         val+=1
         
    #reducing the original array and printing it
     for j in range(size):
         ar[j] = mapvalues[ar[j]]
         
     print("Reduced array:",ar)
