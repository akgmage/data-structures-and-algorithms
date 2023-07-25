package main

import "math"

func MaxSumIncreasingSubsequence(array []int) (int, []int) {
    sums := make([]int, len(array))
    sequences := make([]int, len(array))
    for i := range sequences {
        sequences[i] = math.MinInt32
        sums[i] = array[i]
    }
    maxSumIndex := 0
    for i, currNum := range array {
        for j := 0; j < i; j++ {
            otherNum := array[j]
            if otherNum < currNum && currNum + sums[j] >= sums[i] {
                sums[i] = currNum + sums[j]
                sequences[i] = j
            }
        }
        if sums[i] > sums[maxSumIndex] {
            maxSumIndex = i
        }
    }
    sum := sums[maxSumIndex]
    sequence := buildSequence(array, sequences, maxSumIndex)
    return sum, sequence
}

func buildSequence(array []int, sequences []int, index int) []int {
    sequence := []int{}
    for index != math.MinInt32 {
        sequence = append(sequence, array[index])
        index = sequences[index]
    }
    reverse(sequence)
    return sequence
}

func reverse(numbers []int) {
    for i, j := 0, len(numbers) - 1; i < j; i, j = i+1, j-1 {
        numbers[i], numbers[j] = numbers[j], numbers[i]
    }
}