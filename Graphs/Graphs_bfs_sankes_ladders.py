from collections import deque

def snakesAndLadders(board):
    n = len(board)
    target = n*n
    moves = {1: 0}
    queue = deque([1])

    while queue:
        curr = queue.popleft()
        if curr == target:
            return moves[curr]
        for i in range(1, 7):
            next = curr + i
            if next > target:
                break
            row, col = getRowCol(next, n)
            if board[row][col] != -1:
                next = board[row][col]
            if next not in moves:
                moves[next] = moves[curr] + 1
                queue.append(next)
    
    return -1

def getRowCol(idx, n):
    row = (idx - 1) // n
    col = (idx - 1) % n
    if row % 2 == 1:
        col = n - col - 1
    row = n - row - 1
    return row, col
