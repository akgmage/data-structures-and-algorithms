#include <iostream>

using namespace std;


int linearSearch(int array[], int x) {

    int len = sizeof(array) / sizeof(array[0]);
    int i = 0;

    while (i < len) {
        if (array[i] == x) {
            return i;
        } i++;
    }

    return 0;

}
int main () {

    int arr[] = {1,2,3,4,5,6,7,8};
    int x = 7;

    cout << linearSearch(arr, x) << endl;
    return 0;


}



