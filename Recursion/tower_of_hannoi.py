
'''
	Towers of Hanoi puzzle.
	Source(https://en.wikipedia.org/wiki/Tower_of_Hanoi)
	Object of the game is to move all the disks over to Tower 3.
	But you cannot place a larger disk onto a smaller disk.

    Approach
	1 Move the top 􀝊 − 1 disks from 􀜵􀝋􀝑􀝎􀜿􀝁 to 􀜣􀝑􀝔􀝅􀝈􀝅􀜽􀝎􀝕 tower,
	2 Move the 􀝊􀯧􀯛 disk from 􀜵􀝋􀝑􀝎􀜿􀝁 to 􀜦􀝁􀝏􀝐􀝅􀝊􀜽􀝐􀝅􀝋􀝊 tower,
	3 Move the 􀝊 − 1disks from 􀜣􀝑􀝔􀝅􀝈􀝅􀜽􀝎􀝕 tower to 􀜦􀝁􀝏􀝐􀝅􀝊􀜽􀝐􀝅􀝋􀝊 tower.
'''
#Tower of Hanoi explanation - https://youtu.be/YstLjLCGmgg
def TowerOfHanoi(n, A,B,C):
    if n == 0:
        return
    TowerOfHanoi(n-1, A,C,B)
    print("Move disk", n, "from", A, "to rod", B)
    TowerOfHanoi(n-1, C, B, A)