#BUBLLE SORT

data = []
n = int(input("Enter the number of elements"))  # Total number of elements in an array

for i in range(0,n):
    num = int(input()) # Asking user the element of an array
    data.append(num) # Appending the element in an array

data_copy = data[:]  # Making copy of the array data

for i in range(0, len(data_copy)):
    for j in range(0, len(data_copy) - i - 1):
        if(data_copy[j] > data_copy[j + 1]):
            data_copy[j], data_copy[j + 1] = data_copy[j + 1], data_copy[j]

print(data_copy)
print(sorted(data))
