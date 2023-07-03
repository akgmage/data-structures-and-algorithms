/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram

sample Input 
1.Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The output represents the maximum area of a rectangle that can be formed using the heights in the given list.
The maximum area is achieved by selecting heights [2, 5, 6, 2], forming a rectangle of width 4 and height 2, resulting in 
an area of 4 * 2 = 10.

2.Input: heights = [2,4]
Output: 4


Code LOGIC :
this code uses two stacks to find the left and right boundaries of each rectangle in the histogram. It then calculates the areas for each
rectangle and returns the maximum area found.

Here's an explanation of the code:

1.The largestRectangleArea function takes a vector a as input and returns an integer representing the largest rectangular area.

2.The first step is to initialize some variables and containers. The variable n is assigned the size of the input vector a. If the size is 1,
the function immediately returns the single element as the largest area.

3.Two additional vectors, l and r, are created to store the indices of the left and right boundaries of each rectangle. Two stacks, s1 and s2,
are used to keep track of elements and their corresponding indices.

4.The first loop iterates through the elements of the vector a from left to right. For each element, it compares its value with the top element of s1. 
If the top element is greater than or equal to the current element, it is popped from the stack until the stack is empty or the top element is smaller.
The index of the top element at the point of popping is assigned as the left boundary of the current element (stored in l). If the stack is empty after
the popping, it means there is no smaller element on the left, so -1 is assigned as the left boundary. Finally, the current element and its index are pushed onto s1.

5.The second loop iterates through the elements of the vector a from right to left. It performs a similar operation as the first loop but using s2 instead of s1. 
The right boundary indices are assigned to the vector r in this loop.

6.After obtaining the left and right boundaries for each element, a new vector ans is created to store the areas of the rectangles. The area for each element is calculated
as the height of the rectangle (the value of the element) multiplied by the width (the difference between the right and left boundaries minus 1).

7.The max_element function is used to find the maximum value in the ans vector, representing the largest area. This value is stored in the variable h.

8.The function returns h, which is the largest rectangular area found in the histogram

TIME and SPACE complexity
The time complexity of the code is O(n) because it involves iterating through the input vector a once, where n is the size of the vector. The space complexity is also O(n) because the code uses additional stacks and vectors to store intermediate results, each with a maximum size of n.
*/

class Solution {
public:
    int largestRectangleArea(vector<int>& a) {
        int n = a.size();
        if(n==1){
            return a[0];
        }
        vector<int> l(n); vector<int> r(n);
        stack<pair<int,int>> s1;
        stack<pair<int,int>> s2;
        
        for(int i=0;i<a.size();i++){
            while(s1.size() > 0 && (s1.top().first >= a[i])){
                s1.pop();
            }
            if(s1.size()==0) l[i] = -1;
            else l[i] = (s1.top().second);
           
            s1.push(make_pair(a[i],i));
        }
        
        
        for(int i=a.size()-1;i>=0;i--){
            while(s2.size() > 0 && (s2.top().first >= a[i])){
                s2.pop();
            }
            if(s2.size()==0) r[i] = (n);
            else r[i] = (s2.top().second);
           
            s2.push(make_pair(a[i],i));
        }
        
        vector<int> ans(n);
        //int ans = -1;
        for(int i=0 ;i<a.size();i++){
            ans[i] =(a[i]*(r[i]-l[i]-1));
        }
        int h = *max_element(ans.begin(), ans.end());
        return h;
        //return ans;
    }
};

//this code can be further optimized and shortened 
//problem link : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
