/*

    1. **Class Structure:**
    - The `HashTable` class represents a hash table for storing key-value pairs.
    - It uses a nested `Node` class to encapsulate key-value pairs and handle collisions using a linked list.
    - The hash table is initialized with a default size of 7, but this size can be modified as needed.

    2. **Node Class:**
    - The `Node` class is a private nested class within the `HashTable`.
    - Each `Node` contains a key, an associated integer value, and a reference to the next `Node` in case of collisions.

    3. **Constructor:**
    - The `HashTable` constructor initializes the data map, an array of `Node` objects, with the default size.

    4. **`printTable` Method:**
    - `printTable` is used to display the contents of the hash table.
    - It iterates through the data map and prints the key-value pairs for each index.
    - If there are collisions, it prints all elements using the linked list structure.

    5. **`hash` Method:**
    - `hash` is a helper method to map a given key to an index in the data map.
    - It computes a hash code for the key by summing the ASCII values of its characters and applying a modulo operation based on the data map size.

    6. **`set` Method:**
    - The `set` method adds a new key-value pair to the hash table.
    - It computes the index for the given key using the `hash` method and creates a new `Node` for the key-value pair.
    - If there's no collision at the computed index, it directly assigns the new `Node`. If a collision occurs, it appends the new `Node` to the linked list.

    7. **`get` Method:**
    - The `get` method retrieves the value associated with a given key.
    - It computes the index for the key using the `hash` method and searches for the key in the linked list at that index.
    - If found, it returns the associated value; otherwise, it returns 0.

    8. **`keys` Method:**
    - The `keys` method returns a list of all keys stored in the hash table.
    - It iterates through the data map, collecting all keys, even in the presence of collisions.

    In summary, the `HashTable` class provides a basic implementation of a hash table for key-value storage. 
    It handles collisions through linked lists, allowing multiple key-value pairs to exist at the same index. 
    The class offers methods to set key-value pairs, retrieve values by keys, list all keys, and print the 
    contents of the hash table.
 * 
*/
import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    // Nested Node class to represent key-value pairs
    class Node {
        String key;
        int value;
        Node next;

        // Constructor to create a new Node
        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to create the HashTable with an initial size
    public HashTable() {
        dataMap = new Node[size];
    }

    // Method to print the contents of the HashTable
    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("{" + temp.key + "=" + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    // A hash function to map a key to an index in the dataMap array
    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    // Add a key-value pair to the hash table
    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Get the value associated with a key
    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) { // Use .equals() to compare strings
                return temp.value;
            }
            temp = temp.next;
        }
        return 0; // Return 0 if the key is not found
    }

    // Get a list of all keys in the hash table
    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
