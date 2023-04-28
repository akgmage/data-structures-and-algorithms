package main

func MoveElementToEnd(array []int, toMove int) []int {
	index := 0 // initialize a variable to keep track of the index where elements should be moved to
    for i := 0; i < len(array); i++ { // loop through the entire array
        if array[i] != toMove { // check if the current element is not equal to the element to be moved
            array[index] = array[i] // move the current element to the left side of the array by replacing the element at the current index (index) with the current element (array[i])
            index++ // increment the index variable by 1 to keep track of the index where the next non-target element should be moved
        }
    }
    for i := index; i < len(array); i++ { // loop through the remaining elements in the array from index to the end
        array[i] = toMove // set each element to be the target element
    }
    return array // return the modified array
}
