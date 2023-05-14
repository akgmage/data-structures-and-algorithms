"""TASK
 Greedy: provide a greedy solution for the coin change problem
 A greedy algorithm is trying to make the best local decisions, without caring about future decisions.
 That means that a greedy algorithm is faster than better approaches but it has not always the best solution
 In some case a greedy approach does not find a solution at all.

 The coin change problem:
    -> given sum s
    -> given list of possible coin types l

    The output has to be a list r, which's elements represent coins from coin types from l.
    r[i] is in l for every i with [0 <= i < length r];
    The sum of r has to be s;
    Furthermore the length of r has to be minimal;

    In other words we need to calculate a way to reach the sum s with minimal coins from coin types l


SAMPLE DATA
 Take a look on the following Samples
 Sample A (good for greedy):
    s = 60
    l = [25, 10, 5];
    Best output r = [25,25,10] (take 2 coins from type 25 and one 10, we get 60 with only three coins)

 Sample B (bad for greedy):
    s = 50;
    l = [30, 25, 10, 5]
    Best output r = [25,25] (take 2 coins from type 25, we get 50 with only two coins)

 Sample C (greedy fails)
    s = 50
    l = [30, 25]
    Best output r = [25,25] (take 2 coins from type 25, we get 50 with only two coins)decisions

APPROACH
 The greedy approach is very simple
 1. We have to sort l in descendig order
 2. Iterate over the sorted list, in each step:
    1. if the sum of r is equal to s, break
    2. add n coins of type l[i] to r where n is maximal and sum(r) + l[i]*n <= s (add as many as we can from this coins type)
 3. if the sum of r is equal to s, return r; otherwise the greedy algorithm has failed
    
SAMPLE A
    1. l in descending order l = [25,10,5]
    2. loop over l (element 25, r=[])
    3. take 2 25 coins because 0+25*2 <= 60 but not 0+25*3 <= 60 (sum(r)+l[i]*n <= s)
    4. next iteration (elment 10, r=[25,25])
    5. take 1 10 coin because 50+10*1 <= 60 (r=[25,25,10])
    6. sumr == s => break
    7. return r

SAMPLE B
    the greedy takes one 30 coin, a 25 coin cannot be taken (30+25 > 25), but 2 10 coins
    r = [30, 10, 10]
    the number of coins is 3, but the optimal solution is 2 [25,25].
    A greedy algorithm does not provide the optimnal solution

SAMPLE C
    the greedy takes the 30 coin. But this is a bad decision for the future, because the 25 coin cannot be taken (30+25 > 50)
    that means that the greedy does not provide any solution because a bad decision was made.
    To get this solution you have to do a dynamic programmic approach

COMPLEXITY
    With sorting (random list l):
        sorting takes log(l)*l time.
        looping over l takes O(l) time
        looping over n takes O(n) time
        thats a time complexity of O(l*logl + l*n)
        n is dependend on s and l (for a big s and small l values n gets big, for heavily skewed l values too [1000000,1] for s = 1999999)
        that means that time complexity class will be O(n ^ 2) in worst case (because n is linear to s)
        If it is assumed that n is always in a certain range (i.e below 10), the time complexity class will be O(n*logn)

        sorting has O(l) space complexity
        the space complexity for the whole algorithm is O(l+r) with r being the length of r.
        Best case space complexity class is O(n) where r is assumed very small (linear or better)
        Otherwise the space complexity is O(r). r is dependend on s (linear):
            s = 9
            l = [10, 1]
            r = [1,1,1,1,1,1,1,1,1] which is O(s)

        that means that space complexity class is O(n)
    
    Without sorting (sorted list l):
        looping over l takes O(l) time
        looping over n takes O(n) time
        thats a time complexity of O(l*n)
        n is dependend on s and l (linear)
        that means that time complexity class will be O(n ^ 2) in worst case
        If it is assumed that n is always in a certain range (i.e below 10), the time complexity class will be O(n)

        the space complexity for the whole algorithm is O(r) with r being the length of r.
        Best case space complexity class is O(1) where r is assumed very small (linear or better)
        Otherwise the space complexity is O(n) r is dependend on s (linear)

        that means that space complexity class is O(n) (or O(1) in best case)
"""

def coinChangeGreedy(s:int, l:list[int]):
    #first step: sort l descending
    l.sort(reverse=True)    #uses some log(n)*n algorithm
    r = []                  #return list
    sumr:int = 0            #keep track of the current sum of r to avoid iterating over r to calculate the sum
    for coin in l:
        if(sumr == s):      #the sum of r is the target sum s
            break
        n = int((s - sumr)/coin)    #calculate the max n with sum(r) + l[i]*n <= s
        for i in range(n):          #append n elements of this coin to r
            r.append(coin)
        sumr += coin*n              #update the r sum
    if(sumr != s):      #the target sum s was not reached
        return False
    return r

#without sorting
def coinChangeGreedySorted(s:int, l:list[int]):
    r = []                  #return list
    sumr:int = 0            #keep track of the current sum of r to avoid iterating over r to calculate the sum
    for coin in l:
        if(sumr == s):      #the sum of r is the target sum s
            break
        n = int((s - sumr)/coin)    #calculate the max n with sum(r) + l[i]*n <= s
        for i in range(n):          #append n elements of this coin to r
            r.append(coin)
        sumr += coin*n              #update the r sum
    if(sumr != s):      #the target sum s was not reached
        return False
    return r


#SAMPLE 1 (optimal)
print(coinChangeGreedy(60, [5, 10, 25]))

#SAMPLE 2 (not optimal)
print(coinChangeGreedy(50, [25, 10, 30, 5]))

#SAMPLE 3 (fails)
print(coinChangeGreedy(50, [25, 30]))

print()

#SAMPLE 1 (optimal)
print(coinChangeGreedySorted(60, [25, 10, 5]))

#SAMPLE 2 (not optimal)
print(coinChangeGreedySorted(50, [30, 25, 10, 5]))

#SAMPLE 3 (fails)
print(coinChangeGreedySorted(50, [30, 25]))