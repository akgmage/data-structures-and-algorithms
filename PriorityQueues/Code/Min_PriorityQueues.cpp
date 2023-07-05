#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class priorityQueue
{
    vector<int> pq;

public:
    priorityQueue()
    {
    }
    bool isEmpty()
    {
        return pq.size() == 0;
    }
    int getSize()
    {
        return pq.size();
    }
    int getMin()
    {
        if (isEmpty())
        {
            return -1;
        }
        return pq[0];
    }

    void insert(int data)
    {
        pq.push_back(data);
        int childIndex = pq.size() - 1;
        while (childIndex > 0)
        {
            int parentIndex = (childIndex - 1) / 2;
            if (pq[childIndex] < pq[parentIndex])
            {
                int temp = pq[childIndex];
                pq[childIndex] = pq[parentIndex];
                pq[parentIndex] = temp;
            }
            else
            {
                break;
            }
            childIndex = parentIndex;
        }
    }

    int removeMin()
    {
        if (pq.size() == 0)
        {
            return -1;
        }
        int ans = getMin();
        int temp = pq[0];
        pq[0] = pq[pq.size() - 1];
        pq[pq.size() - 1] = temp;
        pq.pop_back();
        int parentIndex = 0;
        int childIndex1 = 2 * parentIndex + 1;
        int childIndex2 = 2 * parentIndex + 2;
        while (childIndex1 < pq.size())
        {
            int minIndex = parentIndex;
            if (pq[minIndex] > pq[childIndex1])
            {
                minIndex = childIndex1;
            }
            if (childIndex2 < pq.size() && pq[minIndex] > pq[childIndex2])
            {
                minIndex = childIndex2;
            }
            swap(pq[parentIndex], pq[minIndex]);
            if (minIndex == parentIndex)
            {
                break;
            }
            parentIndex = minIndex;
            childIndex1 = 2 * parentIndex + 1;
            childIndex2 = 2 * parentIndex + 2;
        }
        return ans;
    }
};

int main()
{
    priorityQueue p;
    p.insert(100);
    p.insert(10);
    p.insert(15);
    p.insert(4);
    p.insert(17);
    p.insert(21);
    p.insert(67);

    cout << p.getSize() << endl;
    cout << p.getMin() << endl;
    while (!p.isEmpty())
        cout << p.removeMin() << " ";
    return 0;
}