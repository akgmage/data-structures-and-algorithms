class Solution:
    def intToRoman(self, num: int) -> str:
        #Based on given rules, we can directly consider the other possibilities
        #Then, we can divide it directly as required and take the roman values
        arr = [["I",1],["IV",4],["V",5],["IX",9],["X",10],["XL",40],["L",50],["XC",90],["C",100],["CD",400],["D",500],["CM",900],["M",1000]]

        final_string = ""
        for i in arr[::-1]:
            rev = num//i[1]
            final_string += i[0]*rev
            num = num%i[1]
        return final_string
