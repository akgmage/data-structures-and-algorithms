#include<bits/stdc++.h>
using namespace std;

int Hoare_partition(int arr[],int l,int h)
{
	// Here p is the Index of pivot element
	// Here We consider first element as pivot, 
	// But if we Want to consider any element as pivot then just swap that index with the first element
	int pivot=arr[l];
    int i=l-1,j=h+1;
    
    while(true)
    {
    	do{
    		i++;
		}while(arr[i]<pivot);
		
		do{
			j--;
		}while(arr[j]>pivot);
		
		if(i>=j)
		  return j;
		swap(arr[i],arr[j]);
	}
}

void Quick_Sort(int arr[],int low,int high)
{
	
    if(low<high)// If there is single element then no need to sort it
    {
    	int p=Hoare_partition(arr,low,high);
    	
    	Quick_Sort(arr,low,p);
    	Quick_Sort(arr,p+1,high);
	}
}

void Display(int arr[],int n)
{
    for(int i=0;i<n;i++)
      cout<<arr[i]<<" ";
    cout<<endl;
}
int main()
{
    int arr[]={150,400,300,20,-1,100,60,9,100,300};
    int n=sizeof(arr)/sizeof(arr[0]);
    Quick_Sort(arr,0,n-1);
    Display(arr,n);
    return 0;
}