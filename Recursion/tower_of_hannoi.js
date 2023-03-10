/*
	Towers of Hanoi puzzle.
	Source(https://en.wikipedia.org/wiki/Tower_of_Hanoi)
	Object of the game is to move all the disks over to Tower 3.
	But you cannot place a larger disk onto a smaller disk.

  Approach
	1 Move the top 􀝊 − 1 disks from 􀜵􀝋􀝑􀝎􀜿􀝁 to 􀜣􀝑􀝔􀝅􀝈􀝅􀜽􀝎􀝕 tower,
	2 Move the 􀝊􀯧􀯛 disk from 􀜵􀝋􀝑􀝎􀜿􀝁 to 􀜦􀝁􀝏􀝐􀝅􀝊􀜽􀝐􀝅􀝋􀝊 tower,
	3 Move the 􀝊 − 1disks from 􀜣􀝑􀝔􀝅􀝈􀝅􀜽􀝎􀝕 tower to 􀜦􀝁􀝏􀝐􀝅􀝊􀜽􀝐􀝅􀝋􀝊 tower.
*/
function towerOfHanoi(numDisks, fromPeg, toPeg, auxPeg) {
  if (numDisks === 1) {
    console.log(`Move disk 1 from peg ${fromPeg} to peg ${toPeg}`);
  } else {
    towerOfHanoi(numDisks - 1, fromPeg, auxPeg, toPeg);
    console.log(`Move disk ${numDisks} from peg ${fromPeg} to peg ${toPeg}`);
    towerOfHanoi(numDisks - 1, auxPeg, toPeg, fromPeg);
  }
}

// Example usage:
towerOfHanoi(3, "A", "C", "B"); // Move disk 1 from peg A to peg C, Move disk 2 from peg A to peg B, Move disk 1 from peg C to peg B, Move disk 3 from peg A to peg C, Move disk 1 from peg B to peg A, Move disk 2 from peg B to peg C, Move disk 1 from peg A to peg C

// This implementation uses recursion to solve the problem. The towerOfHanoi function takes four arguments: numDisks (the number of disks to move), fromPeg (the peg the disks start on), toPeg (the peg the disks should end up on), and auxPeg (the auxiliary peg used for moving the disks).
// If numDisks is 1, the function simply moves the single disk from fromPeg to toPeg. Otherwise, it first moves numDisks - 1 disks from fromPeg to auxPeg using toPeg as the auxiliary peg. Then it moves the largest remaining disk from fromPeg to toPeg. Finally, it moves the numDisks - 1 disks from auxPeg to toPeg using fromPeg as the auxiliary peg.
// The function prints out the moves it makes to the console, so running towerOfHanoi(3, "A", "C", "B") would output:

// Move disk 1 from peg A to peg C
// Move disk 2 from peg A to peg B
// Move disk 1 from peg C to peg B
// Move disk 3 from peg A to peg C
// Move disk 1 from peg B to peg A
// Move disk 2 from peg B to peg C
// Move disk 1 from peg A to peg C
