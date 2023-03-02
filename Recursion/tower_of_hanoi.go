/*
	Towers of Hanoi puzzle.
	Source(https://en.wikipedia.org/wiki/Tower_of_Hanoi)
	Object of the game is to move all the disks over to Tower 3.
	But you cannot place a larger disk onto a smaller disk.
*/
/*
Approach
	1 Move the top 􀝊 − 1 disks from 􀜵􀝋􀝑􀝎􀜿􀝁 to 􀜣􀝑􀝔􀝅􀝈􀝅􀜽􀝎􀝕 tower,
	2 Move the 􀝊􀯧􀯛 disk from 􀜵􀝋􀝑􀝎􀜿􀝁 to 􀜦􀝁􀝏􀝐􀝅􀝊􀜽􀝐􀝅􀝋􀝊 tower,
	3 Move the 􀝊 − 1disks from 􀜣􀝑􀝔􀝅􀝈􀝅􀜽􀝎􀝕 tower to 􀜦􀝁􀝏􀝐􀝅􀝊􀜽􀝐􀝅􀝋􀝊 tower.
*/
package main

import "fmt"
func TowerOfHanoiHelper(n int, from, to, temp string) {
	// Base case
	// If only 1 disk, make the move and return 
	if n == 1 {
		fmt.Println("Move disk ", n, " from peg ", from, " to peg ", to)
		return
	}

	// Move top n-1 disks from A to B, using C as auxiliary 
	TowerOfHanoiHelper(n-1, from, temp, to)

	// Move remaining disks from A to C 
	fmt.Println("Move disk ", n, " from peg ", from, " to peg ", to)
	
	// Move n-1 disks from B to C using A as auxiliary
	TowerOfHanoiHelper(n-1, temp, to, from)
}

func TowersOfHanoi(n int) {
	TowerOfHanoiHelper(n, "A", "C", "B")
}
func main() {
	TowersOfHanoi(3)
}