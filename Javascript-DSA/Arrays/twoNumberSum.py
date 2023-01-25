# O(n^2) | O(1) space

# def twoNumberSum(array, targetSum):
#     for i in range(len(array) -  1):
#         firstNum = array[i]
        
#         for j in range(i + 1, len(array)):
#             secondNum = array[j]
#             if firstNum + secondNum == targetSum:
#                 return [firstNum, secondNum]
#     return []

# USING DICTIONARY / HASH TABLE
# O(n) | O(n) space

# def twoNumberSum(array, targetSum):
#     nums = {}
#     for num in array:
#         potentialMatch = targetSum - num
#         if potentialMatch in nums:
#             return [targetSum - num, num]
#         else:
#              nums[num] = True
#     return []

# USING OPTIMAL SOLUTION
# O(nLog(n)) | O(1) space

def twoNumberSum(array, targetSum):
    array.sort()
    left = 0
    right = len(array) - 1
    while left < right:
        currentSum = array[left] + array[right]
        if currentSum == targetSum:
            return [array[left], array[right]]
        elif currentSum < targetSum:
            left += 1
        elif currentSum > targetSum:
            right += 1
    return []

array = [3, 5, -4, 8, 11, 1, -1, 6]
targetSum = 8

twoNumberSum(array, targetSum)
