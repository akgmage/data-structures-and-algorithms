// Queue Data Structure
/*
	In this implementation, we define a struct for the queue that has a slice to store the values and pointers to the 
	front and rear of the queue. We also define methods for checking if the queue is empty, adding an element to the 
	rear of the queue, and removing an element from the front of the queue.

	The NewQueue() function creates a new queue and initializes its front and rear pointers to nil. The IsEmpty() 
	method checks if the queue is empty by checking if the front pointer is nil. The Enqueue() method adds an 
	element to the rear of the queue by appending it to the slice and updating the rear pointer. The Dequeue() 
	method removes an element from the front of the queue by removing it from the slice and updating the front 
	pointer.

	In the main() function, we create a new queue, add some elements to it, and then dequeue them one 
	by one and print their values.
*/
package main

import "fmt"

// Define a struct for queue that has a slice to store values and pointers to the front and rear of the queue
type Queue struct {
    values []int
    front  *int
    rear   *int
}

// Function to create a new queue and initialize its front and rear pointers
func NewQueue() *Queue {
    q := Queue{values: make([]int, 0), front: nil, rear: nil}
    return &q
}

// Function to check if the queue is empty
func (q *Queue) IsEmpty() bool {
    return q.front == nil
}

// Function to add an element to the rear of the queue
func (q *Queue) Enqueue(val int) {
    // If the queue is empty, set both front and rear pointers to the new element
    if q.front == nil {
        q.front = &val
        q.rear = &val
    } else {
        // Otherwise, add the new element to the rear of the queue and update the rear pointer
        q.values = append(q.values, val)
        q.rear = &q.values[len(q.values)-1]
    }
}

// Function to remove an element from the front of the queue and return its value
func (q *Queue) Dequeue() (int, error) {
    // If the queue is empty, return an error
    if q.front == nil {
        return 0, fmt.Errorf("queue is empty")
    }

    // Get the value of the element at the front of the queue
    val := *q.front

    // If there is only one element in the queue, set both front and rear pointers to nil
    if len(q.values) == 1 {
        q.front = nil
        q.rear = nil
    } else {
        // Otherwise, remove the front element from the slice and update the front pointer
        q.values = q.values[1:]
        q.front = &q.values[0]
    }

    // Return the value of the dequeued element
    return val, nil
}

func main() {
    // Create a new queue
    q := NewQueue()

    // Add some elements to the queue
    q.Enqueue(10)
    q.Enqueue(20)
    q.Enqueue(30)

    // Dequeue elements from the queue and print their values
    for !q.IsEmpty() {
        val, err := q.Dequeue()
        if err != nil {
            fmt.Println(err)
        } else {
            fmt.Println(val)
        }
    }
}
