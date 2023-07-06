/*
You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).
The tickets are sold in the following manner -

1. The first person (pi) in the queue requests for the ticket.
2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
3. Otherwise, give him the ticket (and don't make him stand in queue again).

Giving a ticket to a person takes exactly 1 minute and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.
Input Format:

The first line of input contains an integer, that denotes the value of total number of people standing in queue or the size of the array of priorities. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array of priorities.
The following contains an integer, that denotes the value of index of your priority. Let us denote it with symbol k.

Output Format :

The first and only line of output contains the time required for you to get the ticket.

Constraints:

Time Limit: 1 sec

Sample Input 1 :

3
3 9 4
2

Sample Output 1 :

2

Sample Output 1 Explanation :

Person with priority 3 comes out. But there is a person with higher priority than him. So he goes and then stands in the queue at the end. Queue's status :  {9, 4, 3}. Time : 0 secs.
Next, the person with priority 9 comes out. And there is no person with higher priority than him. So he'll get the ticket. Queue's status :  {4, 3}. Time : 1 secs.
Next, the person with priority 4 comes out (which is you). And there is no person with higher priority than you. So you'll get the ticket. Time : 2 secs.

Sample Input 2 :

5
2 3 2 2 4
3

Sample Output 2 :

4

Explaination :
    The code first defines two data structures: a priority queue and a queue. The priority queue is used to store the priorities of all the people in the queue, and the queue is used to store the indices of the people in the queue.

    The function buyTicket() takes three parameters: an array of priorities, the number of people in the queue, and the index of the person who is buying the ticket. The function first pushes all the priorities into the priority queue. Then, it pushes all the indices into the queue.

    The function then enters a loop. In each iteration of the loop, the function checks if the priority of the person at the front of the queue is equal to the priority of the person who is buying the ticket. If it is, the function increments the time by 1, pops the person at the front of the queue, and pops the person at the front of the queue. If it is not, the function pops the person at the front of the queue and pushes them back into the queue.

    The function continues looping until the person who is buying the ticket is at the front of the queue. The function then returns the time it took for the person to buy the ticket.

    The main function of the code first prompts the user to enter the number of people in the queue. Then, it creates an array of priorities and prompts the user to enter the priorities of all the people in the queue. Finally, it prompts the user to enter the index of the person who is buying the ticket, and it prints the time it took for the person to buy the ticket.

*/

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int buyTicket(int *arr, int n, int k)
{
    // Initialize a priority queue to store the priorities of all the people in the queue.
    priority_queue<int> pq;
    // Initialize a queue to store the indices of all the people in the queue.
    queue<int> indices;
    // Push all the priorities into the priority queue.
    for (int i = 0; i < n; i++)
    {
        pq.push(arr[i]);
    }
    // Push all the indices into the queue.
    for (int i = 0; i < n; i++)
    {
        indices.push(i);
    }
    // Initialize the time it took for the person to buy the ticket.
    int time = 0;
    // Loop until the person who is buying the ticket is at the front of the queue.
    while (!indices.empty())
    {
        // Check if the priority of the person at the front of the queue is equal to the priority of the person who is buying the ticket.
        if (arr[indices.front()] == pq.top() && indices.front() == k)
        {
            time++;
            pq.pop();
            indices.pop();
            break;
        }
        // If the priorities match, increment the time by 1 and break out of the loop.
        if (arr[indices.front()] == pq.top())
        {
            time++;
            pq.pop();
            indices.pop();
        }
        // If the priorities do not match, pop the person at the front of the queue and push them back into the queue.
        else
        {
            int temp = indices.front();
            indices.pop();
            indices.push(temp);
        }
    }
    // Return the time it took for the person to buy the ticket.
    return time;
}

int main()
{
    // Prompt the user to enter the number of people in the queue.
    int n;
    cin >> n;
    // Create an array of priorities and prompt the user to enter the priorities of all the people in the queue.
    int *arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    // Prompt the user to enter the index of the person who is buying the ticket.
    int k;
    cin >> k;

    // Print the time it took for the person to buy the ticket.
    cout << buyTicket(arr, n, k);

    // Delete the array of priorities.
    delete[] arr;
}