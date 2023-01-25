#include <bits/stdc++.h>

using namespace std;

int max(int leftSum, int rightSum, int crossSum) {
    if (leftSum > rightSum && leftSum > crossSum) {
        return leftSum;
    } else if (rightSum > leftSum && rightSum > crossSum) {
        return rightSum;
    }
    else if (crossSum > leftSum && crossSum > rightSum) {
        return crossSum;
    }
}

void printArr(int arr[], int i, int j) {
    for (int k = i; k <= j; k++) {
        cout << arr[k] << " ";
    }
}

int findCrossSum(int arr[], int midLeft, int p, int midRight, int q)
{
    int leftBestSum = 0, leftTotalSum = 0, rightBestSum = 0, rightTotalSum = 0;
    int leftBestSumPosition = -1, rightBestSumPosition = -1;

    for (int i = midLeft; i >= 0; i--) {
        leftTotalSum = leftTotalSum + arr[i];
        if (leftTotalSum > leftBestSum) {
            leftBestSum = leftTotalSum;
            leftBestSumPosition = i;
        }
    }

    for (int i = midRight; i < q; i++) {
        rightTotalSum = rightTotalSum + arr[i];
        if (rightTotalSum > rightBestSum) {
            rightBestSum = rightTotalSum;
            rightBestSumPosition = i;
        }
    }
    printArr(arr, leftBestSumPosition, rightBestSumPosition);

}
int continousMaxSubArraySum(int arr[], int p, int q)
{
    if ( p == q) {
        return arr[p];
    } else {
        int mid = (p + q) / 2;
        int leftSum = continousMaxSubArraySum(arr, p, mid);
        int rightSum = continousMaxSubArraySum(arr, mid + 1, q);
        int crossSum = findCrossSum(arr, mid, p, mid + 1, q);
        return max(leftSum, rightSum, crossSum);
    }
}

int main () {
    int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int p = 0;

    int q = sizeof(arr)/sizeof(arr[0]);

    // cout << "\nMAX SUM " << continousMaxSubArraySum(arr, p, q);
    continousMaxSubArraySum(arr, p, q);

    return 0;
}