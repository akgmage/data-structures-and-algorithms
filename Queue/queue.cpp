// Implement Queue data structure in C++
#include <iostream>
using namespace std;

const int MAX_SIZE = 100; // maximum size of the queue

class Queue {
private:
    int front, rear;
    int arr[MAX_SIZE];
public:
    Queue() {
        front = -1; // initialize front and rear to -1 to indicate the queue is empty
        rear = -1;
    }

    bool isFull() {
        return rear == MAX_SIZE - 1; // check if the rear index is at the maximum size
    }

    bool isEmpty() {
        return front == -1 && rear == -1; // check if both front and rear indices are at -1, indicating an empty queue
    }

    void enqueue(int x) {
        if (isFull()) {
            cout << "Error: Queue is full" << endl;
            return;
        }
        if (isEmpty()) {
            front = rear = 0; // if the queue is empty, set both front and rear to 0 to add the first element
        }
        else {
            rear++; // increment rear to add the new element
        }
        arr[rear] = x; // add the new element to the rear of the queue
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Error: Queue is empty" << endl;
            return;
        }
        if (front == rear) {
            front = rear = -1; // if the queue has only one element, set both front and rear indices to -1 to indicate an empty queue
        }
        else {
            front++; // increment front to remove the element
        }
    }

    int peek() {
        if (isEmpty()) {
            cout << "Error: Queue is empty" << endl;
            return -1;
        }
        return arr[front]; // return the element at the front of the queue
    }

    void print() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return;
        }
        cout << "Queue: ";
        for (int i = front; i <= rear; i++) {
            cout << arr[i] << " "; // print each element in the queue from front to rear
        }
        cout << endl;
    }
};

int main() {
    Queue q;
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.print(); // output: Queue: 1 2 3
    q.dequeue();
    q.print(); // output: Queue: 2 3
    cout << "Front element: " << q.peek() << endl; // output: Front element: 2
    return 0;
}
