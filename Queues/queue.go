// Implement Stack Data Structure

package main

type Queue []string

func (q *Queue) IsEmpty() bool{
	return len(*q) == 0
}

func (q *Queue) EnQueue(str string) {
	*q = append(*q, str)
}

func (q *Queue) DeQueue(str string) (string, bool) {
	if q.IsEmpty() {
		return "", false
	} else {
		element := (*q)[0]
		*q = (*q)[1:]
		return element, true
	}
}

