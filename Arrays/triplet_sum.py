'''
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum equals the target.
Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
'''

def find3Numbers(A, arr_size, sum):

	# Sort the elements
	A.sort()

	# Now fix the first element
	# one by one and find the
	# other two elements
	for i in range(0, arr_size-2):
		
		# index of the first element
		# in the remaining elements
		l = i + 1
		
		# index of the last element
		r = arr_size-1
		while (l < r):
		
			if( A[i] + A[l] + A[r] == sum):
				return True
			elif (A[i] + A[l] + A[r] < sum):
				l += 1
			else: # A[i] + A[l] + A[r] > sum
				r -= 1

	# If we reach here, then
	# no triplet was found
	return False

# Driver program to test above function
A = [1, 2, 3, 4, 5, 6]
sum = 9
arr_size = len(A)

print(find3Numbers(A, arr_size, sum))