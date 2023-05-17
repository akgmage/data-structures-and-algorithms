/* The basic difference in stack and queues is the order they are filled in practically.In Stacks, 
they are inserted on top of previous element while In Queues they are inserted behind the last element.
The push() function is what we have to look out for. First we will empty out our primary stack s1 to another stack s2.
Then We push the element to be inserted x in s1(or s2). 
Then just empty out the stack s2 back into s1. But the element x would be at the last place just like in a Queue.
The other Operations are the same as we have already implemented as a queue.*/



class MyQueue {
private:
    stack<int> s1,s2;
public:
    MyQueue() { 
    }
    void push(int x) {
        s1.push(x);
    }
    int pop() {
        int res = peek();
        s2.pop();
        return res;
    }
    int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.top());
                s1.pop();
            }
        }
        int res = s2.top();   
        return res;
    }
    bool empty() {
        return s1.empty()&&s2.empty();
    }
};
