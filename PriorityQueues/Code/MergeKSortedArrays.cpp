/*
Given k different arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).
Hint : Use Heaps.
Input Format:

The first line of input contains an integer, that denotes value of k.
The following lines of input represent k sorted arrays. Each sorted array uses two lines of input. The first line contains an integer, that denotes the size of the array. The following line contains elements of the array.

Output Format:

The first and only line of output contains space separated elements of the merged and sorted array, as described in the task.

Constraints:

0 <= k <= 1000
0 <= n1, n2 <= 10000
Time Limit: 1 second

Sample Input 1:

4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0

Sample Output 1:

0 1 2 5 6 9 45 78 90 100 234

*/
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> mergeKSortedArrays(vector<vector<int> *> input)
{
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
    for (int i = 0; i < input.size(); i++)
    {
        pair<int, pair<int, int>> p;
        p.first = input[i]->at(0);
        p.second.first = i;
        p.second.second = 0;
        pq.push(p);
    }
    vector<int> ans;
    while (!pq.empty())
    {
        pair<int, pair<int, int>> p = pq.top();
        pq.pop();
        ans.push_back(p.first);
        int arrNo = p.second.first;
        int index = p.second.second + 1;
        if (index < input[arrNo]->size())
        {
            p.first = input[arrNo]->at(index);
            p.second.second = index;
            pq.push(p);
        }
    }
    return ans;
}

int main()
{
    int k;
    cin >> k;

    vector<vector<int> *> input;

    for (int j = 1; j <= k; j++)
    {
        int size;
        cin >> size;
        vector<int> *current = new vector<int>;

        for (int i = 0; i < size; i++)
        {
            int a;
            cin >> a;
            current->push_back(a);
        }

        input.push_back(current);
    }

    vector<int> output = mergeKSortedArrays(input);

    for (int i = 0; i < output.size(); i++)
    {
        cout << output[i] << " ";
    }

    return 0;
}