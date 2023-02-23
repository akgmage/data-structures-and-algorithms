#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
 
int maxProfit(vector<int>& prices)
{
    int minElement = prices[0], maxDiff = 0;
    for (int i = 1; i < prices.size(); i++) {
 
        minElement = min(minElement, prices[i]);
        maxDiff = max(maxDiff, prices[i] - minElement);
    }
    return maxDiff;
}

int main()
{
    vector<int> prices = { 7, 1, 5, 3, 6, 4 };
    int maxProfitEarned = maxProfit(prices);
    cout << maxProfitEarned << endl;
    return 0;
}
