// 1. Queue Using Array:
// 2. Queue Using LinkedList:
/*
    In this implementation, we use an array to store the elements of the queue, and we keep track of the front and rear indices, as well as the current size of the queue.
    The enqueue operation adds an item to the rear of the queue, while the dequeue operation removes an item from the front of the queue.
    The isEmpty and isFull methods check whether the queue is empty or full, respectively, while the size method returns the current size of the queue.

*/  
// 1. Queue Using Array:
public class Queue {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int currentSize;

        public Queue(int size) {
            this.maxSize = size;
            this.queueArray = new int[size];
            this.front = 0;
            this.rear = -1;
            this.currentSize = 0;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            if (rear == maxSize) {
                rear = 0;
            }
            queueArray[rear] = item;
            currentSize++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int temp = queueArray[front];
            front++;
            if (front == maxSize) {
                front = 0;
            }
            currentSize--;
            return temp;
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == maxSize;
        }

        public int size() {
            return currentSize;
        }
    }    


    

// Here's an example implementation of a Queue data structure in Java using a linked list
/*
    In this implementation, we use a linked list to store the elements of the queue, and we keep track of the front and rear nodes, as well as the current size of the queue.
    The enqueue operation adds a new node to the rear of the linked list, while the dequeue operation removes the head node from the linked list.
    The isEmpty method checks whether the queue is empty, while the size method returns the current size of the queue.
    Note that this implementation uses generics to allow the queue to store elements of any type.
*/
// 2. Queue Using LinkedList:
public class Queue<T> {
        private Node<T> front;
        private Node<T> rear;
        private int size;

        public Queue() {
            front = null;
            rear = null;
            size = 0;
        }

        private static class Node<T> {
            T data;
            Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public void enqueue(T item) {
            Node<T> newNode = new Node<>(item);
            if (isEmpty()) {
                front = newNode;
            } else {
                rear.next = newNode;
            }
            rear = newNode;
            size++;
        }

        public T dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }
            T item = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }    

