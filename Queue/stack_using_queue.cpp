// ISSUE # 258
/* Aim : To implement Stack data structure using two Queues. 
Inspired from - https://leetcode.com/problems/implement-stack-using-queues/
Contributor - github user - harsh9607

LOGIC : We have two queues q1 and q2 within the Class Queue_As_stack . The Logic is to use the front of q1 to behave as top of the stack. q2 is used
as a helper queue. So whenever we want to add a new element we transfer all existing elements from q1 into q2 . When q1 is empty we push the new element.
Then we transfer back all the elements originally in q1 from q2. 

Approach In short : a) Push all from q1 -> q2  b) Insert new element c) Push all from q2 -> q1     

EXAMPLES : Say we want to input three numbers in a stack - 1 , 2 , 3 
           Implementation will be as follows
           q1 :  <empty>  
           q2 :  <empty>
           >> 1
           q1 : 1 
           q2 : <empty>
           
           >> 2
           ( existing data structure ) 
           q1 : 1
           q2 : <empty> 
           (Step a ) Transfer from q1 ->  q2  
           q1 : <empty>
           q2 : 1 
           Step b ) Insert new element to q1 
           q1 : 2
           q2 : 1
           Step c ) Transfer all from q2 -> q1  
           q1 : 2 , 1 
           q2 : <empty> 
           
           >> 3 
           ( existing data structure ) 
           q1 : 2 , 1 
           q2 : <empty> 
           (Step a ) Transfer from q1 ->  q2  
           q1 : <empty>
           q2 : 2 , 1
           Step b ) Insert new element to q1 
           q1 : 3
           q2 : 2 , 1
           Step c ) Transfer all from q2 -> q1  
           q1 : 3 , 2 , 1 
           q2 : <empty>  
  
    
*/
#include<iostream>
#include<queue>
using namespace std; 

class Queue_As_stack {
public : queue<int> q1,q2; 
	   void PUSH(int d) {
		   if (q1.empty())
		   {
			   q1.push(d);
		   }

		   else
		   {
			   while (!q1.empty())
			   {
				   q2.push(q1.front());
				   q1.pop();
			   }
			   q1.push(d);
			   while (!q2.empty())
			   {
				   q1.push(q2.front());
				   q2.pop();
			   }
		   }
	   }

      // Pops out top of stack 
		   void POP()
		   {
			   q1.pop();
		   }
       
      // Returns the top of stack
		   int TOP()
		   {
			   return q1.front();
		   }
			 // It displays as well as empties the stack. 
		   void DISPLAY()
		   {

			   while (!q1.empty())
			   {
				   cout << q1.front() << endl;
				   q1.pop();
			   }

		   }
       // To check if stack is empty  
       bool EMPTY()
       {
            if(q1.empty())
            {
            return true; 
            }
            return false;
       }
};



int main()
{
	Queue_As_stack Q1;
	for (int i = 1; i <= 10; i++) {
		Q1.PUSH(i);
		
	}
	
	Q1.POP();
	
	Q1.DISPLAY();
	
	if(Q1.EMPTY())
	{
	    cout<<"Stack is empty ! ";
	}

	return 0;
}
