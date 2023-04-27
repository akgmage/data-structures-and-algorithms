#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

void updateLargest(vector<int>& triplets, int num);
void shiftAndUpdate(vector<int>& triplets, int num, int idx);
vector<int> findThreeLargestNumbers(vector<int>& array);

int main() {
    vector<int> array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
    vector<int> result = findThreeLargestNumbers(array);
    for (int num : result) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}

vector<int> findThreeLargestNumbers(vector<int>& array) {
    vector<int> triplets = {INT_MIN, INT_MIN, INT_MIN};
    for (int num : array) {
        updateLargest(triplets, num);
    }
    return triplets;
}

void updateLargest(vector<int>& triplets, int num) {
    if (num > triplets[2]) {
        shiftAndUpdate(triplets, num, 2);
    } else if (num > triplets[1]) {
        shiftAndUpdate(triplets, num, 1);
    } else if (num > triplets[0]) {
        shiftAndUpdate(triplets, num, 0);
    }
}

void shiftAndUpdate(vector<int>& triplets, int num, int idx) {
    for (int i = 0; i < idx + 1; i++) {
        if (i == idx) {
            triplets[i] = num;
        } else {
            triplets[i] = triplets[i + 1];
        }
    }
}
