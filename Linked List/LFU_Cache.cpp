// Question--> LFU Cache
// Design and implement a data structure for a Least Frequently Used (LFU) cache.

// Implement the LFUCache class:

// LFUCache(int capacity) Initializes the object with the capacity of the data structure.
// int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
// void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
// To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

// When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

// The functions get and put must each run in O(1) average time complexity


// solution -->

//minFreq is the smallest frequency so far
//The main idea is to put all keys with the same frequency to a linked list so the most recent one can be evicted;
//mIter stored the key's position in the linked list;


#include <bits/stdc++.h>
using namespace std;


class LFUCache {
    int cap;
    int size;
    int minFreq;
    unordered_map<int, pair<int, int>> m; //key to {value,freq};
    unordered_map<int, list<int>::iterator> mIter; //key to list iterator;
    unordered_map<int, list<int>>  fm;  //freq to key list;
public:
    LFUCache(int capacity) {
        // initialize your data structure here
        cap=capacity;
        size=0;
    }
    
    int get(int key) {
        if(m.count(key)==0) return -1; // if key not found return -1;
        
        fm[m[key].second].erase(mIter[key]); //erase from old freq list
        m[key].second++; // increase freq;
        fm[m[key].second].push_back(key); // add to new freq list;
        mIter[key]=--fm[m[key].second].end();// point to new freq list;
        
        // if old min freq list empty, increase min freq;
        if(fm[minFreq].size()==0 ) 
              minFreq++;
        
        return m[key].first; // return value
    }
    
   void put(int key, int value) {
        if(cap<=0) return; // corner case
        
        int storedValue=get(key); // get value if already present

        // if already present update value, increase freq;
        if(storedValue!=-1)
        {
            m[key].first=value;
            return;
        }
        
        // if capacity full, erase least freq used element from this list
        if(size>=cap )
        {
            m.erase( fm[minFreq].front() );
            mIter.erase( fm[minFreq].front() );
            fm[minFreq].pop_front();
            size--;
        }
        
        m[key]={value, 1}; // insert new key value pair with freq 1;
        fm[1].push_back(key); // add to freq list 1;
        mIter[key]=--fm[1].end(); // point to new freq list;
        minFreq=1; // since new element added min freq will be 1;
        size++; // increase size
    }
};


// https://leetcode.com/problems/lfu-cache/