// Search in a rowwise/colwise sorted matrix O(n + m) 
#include<bits/stdc++.h>
using namespace std;
bool search_in_sorted_mat(int Mat[][10], int R, int C, int key){
    int i = 0, flag = 0, j = C-1;
    while(j >= 0 && i < R){
            if(Mat[i][j] == key){
                cout << "Found at position " << i << " " << j << endl;
                flag = 1;
                break;
            }    
            else if(Mat[i][j] < key)
                i++;
            else if(Mat[i][j] > key){
                j--;        
            }    
    }
    return flag == 1 ? true : false;
}
int main(){
    int Mat[10][10], R, C;
    cin >> R >> C;
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cin >> Mat[i][j];
        }
    }
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cout << Mat[i][j] << " ";
        }
        cout << endl;
    }
    int key;
    cin >> key;
    cout << search_in_sorted_mat(Mat, R, C, key);
}