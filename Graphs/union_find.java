/*
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

*/
import java.util.HashMap;
import java.util.Map;

class UnionFind {
    private Map<Integer, Integer> parents; // Map to store the parent of each element
    private Map<Integer, Integer> ranks;   // Map to store the rank of each element

    public UnionFind() {
        parents = new HashMap<>();
        ranks = new HashMap<>();
    }

    public void createSet(int value) {
        parents.put(value, value); // Set the parent of the value to itself
        ranks.put(value, 0);       // Initialize the rank of the value to 0
    }

    public int find(int value) {
        if (!parents.containsKey(value)) {
            return -1; // Return -1 if the value is not found (not part of any set)
        }

        int currentParent = value;
        while (currentParent != parents.get(currentParent)) {
            currentParent = parents.get(currentParent); // Traverse the parent pointers until reaching the root
        }

        // Perform path compression by updating parent pointers along the path to the root
        // This optimization flattens the tree structure, reducing future lookup time
        while (value != currentParent) {
            int nextParent = parents.get(value);
            parents.put(value, currentParent);
            value = nextParent;
        }

        return currentParent; // Return the root/representative
    }

    public void unionSets(int valueOne, int valueTwo) {
        if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
            return; // Return if either value is not found (not part of any set)
        }

        int valueOneRoot = find(valueOne); // Find the root of the set containing valueOne
        int valueTwoRoot = find(valueTwo); // Find the root of the set containing valueTwo

        if (ranks.get(valueOneRoot) < ranks.get(valueTwoRoot)) {
            parents.put(valueOneRoot, valueTwoRoot); // Set the parent of valueOne's root to valueTwo's root
        } else if (ranks.get(valueOneRoot) > ranks.get(valueTwoRoot)) {
            parents.put(valueTwoRoot, valueOneRoot); // Set the parent of valueTwo's root to valueOne's root
        } else {
            parents.put(valueOneRoot, valueTwoRoot); // Set the parent of valueOne's root to valueTwo's root
            ranks.put(valueTwoRoot, ranks.get(valueTwoRoot) + 1); // Increment the rank of valueTwo's root
        }
    }
}

public class Main {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind();

        // Create individual sets
        unionFind.createSet(1);
        unionFind.createSet(2);
        unionFind.createSet(3);

        // Perform union operations
        unionFind.unionSets(1, 2);
        unionFind.unionSets(2, 3);

        // Find representatives of values
        int representative = unionFind.find(3);

        // Check if the representative is found
        if (representative != -1) {
            System.out.println("The representative of 3 is: " + representative);
        } else {
            System.out.println("Value 3 is not found.");
        }
    }
}
