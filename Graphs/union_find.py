'''
	Write a UnionFind class that implements the union-find (also called a disjoint set) data structure.
	This class should support three methods:


	The union-find data structure is similar to a traditional set data structure in that it contains a collection
	of unique values. However, these values are spread out amongst a variety of distinct disjoint sets, meaning that no set
	can have duplicate values, and no two sets can contain the same value.

	createSet(value) : : Adds a given value in a new set containing only that value.

	union(valueOne, valueTwo) : : Takes in two values and determines which sets they are in. If they are in different sets, the sets are combined
    into a single set. If either value is not in a set or they are in the same set, the function should have no effect.

	find(value): : Returns the "representative" value of the set for which a value belongs to. This can be any value in the set, but it should
    always be the same value, regardless of which value in the set find  is passed. If the value is not in a set, the function
    should return null / none

	Explanation:
	The provided code snippet is an optimized version of the Union-Find data structure. Here's a detailed explanation:

	- `UnionFind` struct: It contains two fields, `parents` and `ranks`. The `parents` map stores the parent of
	each element, and the `ranks` map stores the rank of each element. The rank is used to optimize the Union operation.

	- `NewUnionFind` function: It initializes a new instance of the UnionFind struct by creating empty maps for
	`parents` and `ranks`.

	- `CreateSet` method: It creates a new set with the given value. It sets the parent of the value to itself and
	initializes its rank to 0.

	- `Find` method: It finds the root/representative of the set to which the given value belongs. It starts from the
	given value and traverses the parent pointers until it reaches the root. It uses path compression optimization to
	update the parent pointers along the path to the root. Finally, it returns a pointer to the root.

	`Union` method: It performs the union of two sets represented by the given values. It first checks if both values exist
	in the data structure. If either value is missing, it returns without performing any union operation. Otherwise, it finds
	the roots of the two sets using the `Find` method. It compares the ranks of the two roots and performs the union accordingly:

	If the rank of the root of `valueOne` is less than the rank of the root of `valueTwo`, it sets the parent of `valueOne`'s
	root to `valueTwo`'s root.

	If the rank of the root of `valueOne` is greater than the rank of the root of `valueTwo`, it sets the parent of `valueTwo`'s
	root to `valueOne`'s root.

	If the ranks are equal, it chooses one root as the parent and increments its rank by 1.

	By considering the ranks of the roots during the union, the height of the resulting union-find tree can be minimized.

	The time and space complexity of the operations in the `UnionFind` data structure are as follows:

	CreateSet : O(n) time O(1) space
	Find : O(log(n)) time O(1) space where n is total number of values
	Union : O(log(n)) time O(1) space where n is total number of values

'''
class UnionFind:
    def __init__(self):
        self.parents = {}  # Map to store the parent of each element
        self.ranks = {}  # Map to store the rank of each element

    def create_set(self, value):
        self.parents[value] = value  # Set the parent of the value to itself
        self.ranks[value] = 0  # Initialize the rank of the value to 0

    def find(self, value):
        if value not in self.parents:
            return None  # Return None if the value is not found (not part of any set)
        
        current_parent = value
        while current_parent != self.parents[current_parent]:
            current_parent = self.parents[current_parent]  # Traverse the parent pointers until reaching the root

        # Perform path compression by updating parent pointers along the path to the root
        # This optimization flattens the tree structure, reducing future lookup time
        while value != current_parent:
            next_parent = self.parents[value]
            self.parents[value] = current_parent
            value = next_parent

        return current_parent  # Return the root/representative

    def union(self, value_one, value_two):
        if value_one not in self.parents or value_two not in self.parents:
            return  # Return if either value is not found (not part of any set)

        value_one_root = self.find(value_one)  # Find the root of the set containing value_one
        value_two_root = self.find(value_two)  # Find the root of the set containing value_two

        if self.ranks[value_one_root] < self.ranks[value_two_root]:
            self.parents[value_one_root] = value_two_root  # Set the parent of value_one's root to value_two's root
        elif self.ranks[value_one_root] > self.ranks[value_two_root]:
            self.parents[value_two_root] = value_one_root  # Set the parent of value_two's root to value_one's root
        else:
            self.parents[value_one_root] = value_two_root  # Set the parent of value_one's root to value_two's root
            self.ranks[value_two_root] += 1  # Increment the rank of value_two's root


# Create a new instance of UnionFind
union = UnionFind()

# Create individual sets
union.create_set(1)
union.create_set(2)
union.create_set(3)

# Perform union operations
union.union(1, 2)
union.union(2, 3)

# Find representatives of values
representative = union.find(3)

# Check if the representative is found
if representative is not None:
    print("The representative of 3 is:", representative)
else:
    print("Value 3 is not found.")
