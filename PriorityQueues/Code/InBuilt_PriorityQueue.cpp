#include <iostream>
#include <queue>
using namespace std;

int main()
{
    priority_queue<int> pq;
    pq.push(10);
    pq.push(20);
    pq.push(30);
    cout << pq.empty() << endl;
    cout << pq.size() << endl;
    cout << pq.top() << endl;
    while (!pq.empty())
    {
        cout << pq.top() << endl;
        pq.pop();
    }
    cout << pq.size() << endl;
    cout << pq.empty() << endl;
    return 0;
}