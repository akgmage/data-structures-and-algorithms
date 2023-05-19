/* The basic difference in stack and queues is the order they are filled in practically.In Stacks, 
they are inserted on top of previous element while In Queues they are inserted behind the last element.
The push() function is what we have to look out for. First we will empty out our primary stack s1 to another stack s2.
Then We push the element to be inserted x in s1(or s2). 
Then just empty out the stack s2 back into s1. But the element x would be at the last place just like in a Queue.
The other Operations are the same as we have already implemented as a queue.*/


/*Complexity Analysis: 

Time Complexity: 
Push operation : O(1). 
Same as pop operation in stack.
Pop operation : O(N). 
The difference from above method is that in this method element is returned and all elements are restored back in a single call.
Auxiliary Space: O(N). 
Use of stack for storing values.
*/


#include <bits/stdc++.h>
using namespace std;

struct Queue {
	stack<int> s;

	// Enqueue an item to the queue
	void enQueue(int x)
	{
		s.push(x);
	}

	// Dequeue an item from the queue
	int deQueue()
	{
		if (s.empty()) {
			cout << "Q is empty";
			exit(0);
		}

		// pop an item from the stack
		int x = s.top();
		s.pop();

		// if stack becomes empty, return
		// the popped item
		if (s.empty())
			return x;

		// recursive call
		int item = deQueue();

		// push popped item back to the stack
		s.push(x);

		// return the result of deQueue() call
		return item;
	}
};

// Driver code
int main()
{
	Queue q;
	q.enQueue(10);
	q.enQueue(20);
	q.enQueue(30);

	cout << q.deQueue() << '\n';
	cout << q.deQueue() << '\n';
	cout << q.deQueue() << '\n';

	return 0;
}





