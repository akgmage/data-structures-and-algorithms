#include <iostream>
#include<vector>

using namespace std;

int main () {

    // int arr[] = {5, 1, 22, 25, 6, -1, 8, 10};
    
    // int sequence[] = {5, 1, 22, 25, 6, -1, 8, 10, 12};

    // int sequenceSize = sizeof(sequence) / sizeof(sequence[0]);
    // int count = sequenceSize;
    // int k = 0;
    // int arrSize =  sizeof(arr) / sizeof(arr[0]);
    // for (int i = 0; i < arrSize; i++)
    // {
    //     if (count != 0) {
    //         if (sequence[k] == arr[i])
    //         {
    //             k++;
    //             count--;
    //         }
    //     } else {
    //         break;
    //     }
        
    // }
    // if ( count == 0) {
    // cout << true << endl;
    // } else {
    //     cout << false << endl;
    // }

    int arr[] = {0, 1, 2, 4, 6, 8, 10};
    vector<int> array;
    for (int i = 0; i < 7; i++) {

            array[i] = arr[i] * arr[i];
    }

    for (auto it = array.begin(); it != array.end(); it++) {
        
    }
    return 0;
}