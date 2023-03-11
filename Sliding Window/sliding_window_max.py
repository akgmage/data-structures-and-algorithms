# Given an integer array and a window of size windowSize, find the current maximum value in the window as it slides through the entire array

from collections import deque

def slidingWindowMax(arr,windowSize) -> list[int]:
    dq = deque()
    max_elements = []
    for i in range(len(arr)):
        if(len(dq) != 0 and dq[0]== i - windowSize):
            dq.popleft()
        while(len(dq) !=0 and arr[dq[-1]] < arr[i]):
            dq.pop()
        dq.append(i)
        if(i >= windowSize - 1):
            max_elements.append(arr[dq[0]])
    return max_elements

arr = list(map(int, input().split()))
windowSize = int(input())
print(slidingWindowMax(arr, windowSize))
