#extended version of Euclid's algorithm to find GCD of 2 numbers
#runs in O(log N) time/space complexity for GCD of numbers a and b 
#in comparison, the standard Euclidean algorithm runs in O (log (min (a,b)))

def euclidExtended(a,b):
    if a==0:
        return b,0, 1 
    result, a1, b1 = euclidExtended(b%a,a)
    
    a2 = b1- (b//a) *a1
    b2 = a1
    return result, a2, b2 #used as input to recursive call, 

#example driver, change a and b as desired

a,b = 45,10
g,x,y = euclidExtended(a,b)
print("gcd of", a,"," ,b ,"is equal to: " , g)
    
    
        
