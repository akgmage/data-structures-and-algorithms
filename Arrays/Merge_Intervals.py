# Array: Merge intervals in Python #1115
#Program Author : TheCodeVenturer [Niraj Modi]

class Solution:
    def mergeIntervals(self, Intervals):
        Intervals.sort()                #Sorting the intervals to make the starting time in increasing order to maintain the sequence
        sol = []
        start = Intervals[0][0]
        end = Intervals[0][1]
        for [l, u] in Intervals:
            if (l > end):
                sol.append([start, end])
                start, end = l, u
            else:
                end = max(end, u)
        sol.append([start, end])
        return sol


if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        n = int(input())
        a = list(map(int, input().strip().split()))
        Intervals = []
        j = 0
        for i in range(n):
            x = a[j]
            j += 1
            y = a[j]
            j += 1
            Intervals.append([x, y])
        obj = Solution()
        ans = obj.mergeIntervals(Intervals)
        for i in ans:
            for j in i:
                print(j, end=" ")
        print()

'''
Input Format
t=1   No.of Test Cases
Intervals = 2 3 1 2 6 8 9 10       A 2-d Array [[2,3],[1,2],[6,8],[9,10]]
'''