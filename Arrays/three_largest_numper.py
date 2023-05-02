

class Solution:
    def three_max_noo(self,arr: List[int])-> List[int]:
        # give int minvalue to a,b,c
        a,b,c= -9999,-9999,-9999
        # we will iterate through the array and compare the values
        for i in arr:
            if i > a:
                a, b, c = i, a, b
            elif i > b:
                b, c = i, b
            elif i > c:
                c = i
        # return the three max values as a sorted array
        return [a, b, c]