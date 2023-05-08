#by TheCodeVenturer[Niraj Modi]
class Solution:
    def maxArea(self,matrix, rows, cols):
        shiftRow = [0]*cols
        sol=0
        for row in matrix:
            for i,ele in enumerate(row):
                if ele==1:
                    shiftRow[i]+=1
                else:
                    shiftRow[i]=0
            st = []
            for i in range(cols+1):
                while(len(st)>0 and(i==cols or shiftRow[st[-1]]>=shiftRow[i])):
                    height = shiftRow[st[-1]]
                    st.pop()
                    width = i
                    if(len(st)>0): 
                        width = i - st[-1] - 1
                    sol = max(height*width,sol)
                st.append(i)
        return sol

if __name__ == '__main__':
    t=int(input())
    for _ in range(t):
        R,C = map(int, input().strip().split())
        A = []
        for i in range(R):
            line = [int(x) for x in input().strip().split()]
            A.append(line)
        print(Solution().maxArea(A, R, C)) 
"""
Input Format
1       No.Of Test Cases
4 4     rows,columns
next rows*columns lines
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
"""
	
