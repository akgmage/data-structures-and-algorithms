#Given a 2D integer array coordinates and an integer k, where coordinates[i] = [xi, yi] are the coordinates of the ith point in a 2D plane.

#We define the distance between two points (x1, y1) and (x2, y2) as (x1 XOR x2) + (y1 XOR y2) where XOR is the bitwise XOR operation.

#Return the number of pairs (i, j) such that i < j and the distance between points i and j is equal to k.

def count_pairs(coordinates, k):
    result = 0
    seen = {}
    
    for x, y in coordinates:
        for split in range(k + 1):
            x_complement = x ^ split
            y_complement = y ^ (k - split)
            result += seen.get((x_complement, y_complement), 0)
        seen[x, y] = seen.get((x, y), 0) + 1
    
    return result

# Take user input for coordinates
coordinates = []
num_coordinates = int(input("Enter the number of coordinates: "))

for i in range(num_coordinates):
    x = int(input(f"Enter x-coordinate for point {i + 1}: "))
    y = int(input(f"Enter y-coordinate for point {i + 1}: "))
    coordinates.append((x, y))

# Take user input for k
k = int(input("Enter the value of k: "))

pair_count = count_pairs(coordinates, k)
print(f"Number of pairs that satisfy the condition: {pair_count}")
