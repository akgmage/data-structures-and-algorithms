
#Tower of Hanoi explanation - https://youtu.be/YstLjLCGmgg
def TowerOfHanoi(n, A,B,C):
    if n == 0:
        return
    TowerOfHanoi(n-1, A,C,B)
    print("Move disk", n, "from", A, "to rod", B)
    TowerOfHanoi(n-1, C, B, A)