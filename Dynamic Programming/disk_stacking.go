/*
  You're given a non-empty array of arrays where each subarray holds three integers and represents a disk.
  These integers denote each disk's width, depth, and height, respectively. Your goal is to stack up the
  disks and to maximize the total height of the stack. A disk must have a strictly smaller width, depth,
  and height than any other disk below it.

  Write a function that returns an array of the disks in the final stack, starting with the top disk and
  ending with the bottom disk. Note that you can't rotate disks; in other words, the integers in each subarray must
  represent [width, depth, height] at all times

  Sample input :  = [[2, 1, 2], [3, 2, 3], [2, 2, 8], [2, 3, 4], [1, 3, 1], [4, 4, 5]]
  Output: [[2, 1, 2], [3, 2, 3], [4, 4, 5]] // 10 (2 + 3 + 5) is the tallest height we can get by
*/
package main

import "sort"
type Disk []int
type Disks []Disk

func (disks Disks) Len() int           { return len(disks) }
func (disks Disks) Swap(i, j int)      { disks[i], disks[j] = disks[j], disks[i] }
func (disks Disks) Less(i, j int) bool { return disks[i][2] < disks[j][2]} 

func DiskStacking(input [][]int) [][]int {
    disks := make(Disks, len(input))
    for i, disk := range input {
        disks[i] = disk
    }
    
    sort.Sort(disks)
    heights := make([]int, len(disks))
    sequences := make([]int, len(disks))
    
    for i := range disks {
        heights[i] = disks[i][2]
        sequences[i] = -1
    }

    for i := 1; i < len(disks); i++ {
        currentDisk := disks[i]
        for j := 0; j < i; j++ {
            other := disks[j]
            // conditions met
            if areValidDimensions(other, currentDisk) {
                if heights[i] <= currentDisk[2] + heights[j] {
                    heights[i] = currentDisk[2] + heights[j]
                    sequences[i] = j
                }
            }
        }
    }
    maxIndex := 0
    for i, height := range heights {
        if height > heights[maxIndex] {
            maxIndex = i
        }
    }
    sequence := buildSequence(disks, sequences, maxIndex)
    return sequence
}

func areValidDimensions(o Disk, c Disk) bool {
    return o[0] < c[0] && o[1] < c[1] && o[2] < c[2]
}

func buildSequence(disks []Disk, sequences []int, index int) [][]int {
    sequence := [][]int{}
    for index != -1 {
        sequence = append(sequence, disks[index])
        index = sequences[index]
    }
    reverse(sequence)
    return sequence
}
func reverse(numbers [][]int) {
    for i, j := 0, len(numbers) - 1; i < j; i, j = i + 1, j - 1 {
        numbers[i], numbers[j] = numbers[j], numbers[i]
    }
}