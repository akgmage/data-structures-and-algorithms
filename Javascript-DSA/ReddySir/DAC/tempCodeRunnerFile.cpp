
//             max = array[i];
//         }
//         else if (min > array[i])
//         {
//             min = array[i];
//         }
//     }

//     cout << "max: " << max << " min: " << min << endl;
//     return 0;
// }

// int main()
// {
//     int array[] = {50, 70, 60, 35, 25, 75, 12};
//     int firstIndex = 0;
//     int lastIndex = sizeof(array) / sizeof(array[0]);

//     findMaxMinWithDAC(array, firstIndex, lastIndex);

//     return 0;
// }

// TODO WITH DAC  O(n) EVERY CASE | O(n) space


#include <iostream>
using namespace std;

// structure is used to return
// two values from minMax()
struct Pair
{
    int min;
    int max;
};

struct Pair getMinMax(int arr[], int low, int high)
{
    struct Pair minmax, mml, mmr;
    int mid;

    // If there is only one element
    if (low == high)
    {
        minmax.max = arr[low];
        minmax.min = arr[low];
        return minmax;
    }

    // If there are two elements
    if (high == low + 1)
    {
        if (arr[low] > arr[high])
        {
            minmax.max = arr[low];
            minmax.min = arr[high];
        }
        else
        {
            minmax.max = arr[high];
            minmax.min = arr[low];
        }
        return minmax;
    }
else {

    // If there are more than 2 elements
    mid = (low + high) / 2;
    mml = getMinMax(arr, low, mid);
    mmr = getMinMax(arr, mid + 1, high);

    // Compare minimums of two parts
    if (mml.min < mmr.min)
        minmax.min = mml.min;
    else
        minmax.min = mmr.min;

    // Compare maximums of two parts
    if (mml.max > mmr.max)
        minmax.max = mml.max;
    else
        minmax.max = mmr.max;

    return minmax;
}
}

// Driver code
int main()
{
    int arr[] = {1000, 11, 445,
                 1, 330, 3000};
    int arrSize = 6;

    struct Pair minmax = getMinMax(arr, 0, arrsize - 1);

    cout << "Minimum element is " << minmax.min << endl;

    cout << "Maximum element is " << minmax.max;

        return 0;
}

    