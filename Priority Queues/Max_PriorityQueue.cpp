/*
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.

Explaination :
    This code implements a priority queue using a max-heap data structure. Let's go through the code and add comments to explain each section:
*/

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class PriorityQueue
{
    vector<int> pq;

public:
    void insert(int element)
    {
        pq.push_back(element);
        int childIndex = pq.size() - 1;

        while (childIndex > 0)
        {
            int parentIndex = (childIndex - 1) / 2;
            if (pq[parentIndex] < pq[childIndex])
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

    int getMax()
    {
        if (isEmpty())
        {
            return INT_MIN;
        }
        return pq[0];
    }

    int removeMax()
    {
        if (pq.size() == 0)
        {
            return INT_MIN;
        }
        int ans = pq[0];
        pq[0] = pq[pq.size() - 1];
        pq.pop_back();
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        while (leftChildIndex < pq.size())
        {
            int maxIndex = parentIndex;
            if (pq[leftChildIndex] > pq[parentIndex])
            {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < pq.size() && pq[rightChildIndex] > pq[maxIndex])
            {
                maxIndex = rightChildIndex;
            }
            int temp = pq[parentIndex];
            pq[parentIndex] = pq[maxIndex];
            pq[maxIndex] = temp;

            if (parentIndex == maxIndex)
            {
                break;
            }
            parentIndex = maxIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return ans;
    }

    int getSize()
    {
        return pq.size();
    }

    bool isEmpty()
    {
        return pq.size() == 0;
    }
};

int main()
{
    PriorityQueue pq;
    int choice;
    cin >> choice;

    while (choice != -1)
    {
        switch (choice)
        {
        case 1: // insert
            int element;
            cin >> element;
            pq.insert(element);
            break;
        case 2: // getMax
            cout << pq.getMax() << "\n";
            break;
        case 3: // removeMax
            cout << pq.removeMax() << "\n";
            break;
        case 4: // size
            cout << pq.getSize() << "\n";
            break;
        case 5: // isEmpty
            cout << (pq.isEmpty() ? "true\n" : "false\n");
        default:
            return 0;
        }

        cin >> choice;
    }
}