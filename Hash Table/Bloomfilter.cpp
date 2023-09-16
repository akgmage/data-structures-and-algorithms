#include <iostream>
#include <vector>
#include <bitset>
#include <functional>

class BloomFilter {
private:
    int size;                    // Size of the Bloom Filter bitset
    std::vector<std::function<size_t(const std::string&)>> hash_functions;
    std::bitset<1000000> bitset; // Bitset to represent the Bloom Filter

public:
    // Constructor to initialize the Bloom Filter with a given size and hash functions
    BloomFilter(int size, std::vector<std::function<size_t(const std::string&)>> hash_functions)
        : size(size), hash_functions(hash_functions) {}

    // Function to add an element to the Bloom Filter
    void add(const std::string& element) {
        for (const auto& hash_function : hash_functions) {
            size_t index = hash_function(element) % size;
            bitset.set(index);
        }
    }

    // Function to check if an element may exist in the Bloom Filter
    bool contains(const std::string& element) {
        for (const auto& hash_function : hash_functions) {
            size_t index = hash_function(element) % size;
            if (!bitset.test(index)) {
                return false;  // If any bit is not set, the element is definitely not in the filter
            }
        }
        return true; // If all bits are set, the element may exist in the filter (false positives are possible)
    }
};

// Example hash function using std::hash
size_t hash1(const std::string& str) {
    return std::hash<std::string>{}(str);
}

// Example hash function using a custom hash function
size_t hash2(const std::string& str) {
    size_t hash = 0;
    for (char c : str) {
        hash = (hash * 31) + c;
    }
    return hash;
}

int main() {
    // Create a Bloom Filter with a size of 1000000 and two hash functions
    BloomFilter bloomFilter(1000000, {hash1, hash2});

    // Add elements to the Bloom Filter
    bloomFilter.add("apple");
    bloomFilter.add("banana");
    bloomFilter.add("cherry");

    // Check if elements may exist in the Bloom Filter
    std::cout << "Contains 'apple': " << bloomFilter.contains("apple") << std::endl;     // Should return 1 (true)
    std::cout << "Contains 'grape': " << bloomFilter.contains("grape") << std::endl;     // Should return 0 (false)
    std::cout << "Contains 'cherry': " << bloomFilter.contains("cherry") << std::endl;   // Should return 1 (true)
    
    return 0;
}
