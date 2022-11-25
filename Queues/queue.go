// Implement Stack Data Structure

package main

import "fmt"

type Queue []string

func (q *Queue) IsEmpty() bool{
	return len(*q) == 0
}

func (q *Queue) EnQueue(str string) {
	fmt.Printf("%s entered queue\n", str)
	*q = append(*q, str)
}

func (q *Queue) DeQueue() (string, bool) {
	if q.IsEmpty() {
		return "", false
	} else {
		element := (*q)[0]
		*q = (*q)[1:]
		return element, true
	}
}

func main() {
	var queue Queue

	queue.EnQueue("Hello0")
	queue.EnQueue("Hello1")
	queue.EnQueue("Hello2")

	for len(queue) > 0 {
		ele, msg := queue.DeQueue()
		if msg == true {
			fmt.Printf("%s deleted from queue\n", ele)
		}
	}

}
