class HashTable {
    constructor() {
        this.loadFactor = 0;
        this.MAX_LOAD_FACTOR = 0.5;
        this.sizeOfHashTable = 2;
        this.noOfElements = 0;
        this.hash_table = new Array(this.sizeOfHashTable);
    }
    hash(key) {
        let result = 0;
        let prime = 5381;
        for(let i = 0; i < key.length; i++) {
            result = (result + (key.charCodeAt(i)*prime)%this.sizeOfHashTable)%this.sizeOfHashTable;
            prime *= 5381;
        }
        return result;
    }
    rehash() {
        console.log("rehashing...");
        this.sizeOfHashTable *= 2;
        let old_hash_table = this.hash_table;
        this.hash_table = new Array(this.sizeOfHashTable);
        this.noOfElements = 0;
        for(let i = 0; i < old_hash_table.length; i++) {
            if(old_hash_table[i] == undefined) continue;
            for(let j = 0; j < old_hash_table[i].length; j++) {
                this.insert(old_hash_table[i][j][0], old_hash_table[i][j][1]);
            }
        }
    }
    insert(key, value) {
        const hash_table_index = this.hash(key);
        if(this.hash_table[hash_table_index] == undefined) {
            this.hash_table[hash_table_index] = [];
            this.hash_table[hash_table_index].push([key, value]);
        } else {
            for(let i = 0; i < this.hash_table[hash_table_index].length; i++) {
                if(this.hash_table[hash_table_index][i][0] == key) {
                    console.log(this.hash_table);
                    this.hash_table[hash_table_index][i][1] = value;
                    console.log("-------------------");
                    console.log(this.hash_table);
                    return;
                }
            }
            this.hash_table[hash_table_index].push([key, value]);
        }
        this.noOfElements += 1;
        this.loadFactor = this.noOfElements / this.sizeOfHashTable;
        if(this.loadFactor > this.MAX_LOAD_FACTOR) {
        this.rehash();
        }
    } 
    search(key) {
        const hi = this.hash(key);
        if(this.hash_table[hi] == undefined) return undefined;
        for(let i = 0; i < this.hash_table[hi].length; i++) {
            if(this.hash_table[hi][i][0] == key) {
                console.log(hash_table[hi][i][0]);
               return this.hash_table[hi][i][1];
            }
        }
    }
    printHashTable() {
        return this.hash_table;
    }
    remove(key) {
            const hi = this.hash(key);
            if(this.hash_table[hi] == undefined) return -1;
            for(let i = 0; i < this.hash_table[hi].length; i++) {
            if(this.hash_table[hi][i][0] == key) {
                this.noOfElements--;
                return {
                    key: this.hash_table[hi][i].pop(),
                    value: this.hash_table[hi][i].pop()
                }
            }
        }
    }
}
let ht = new HashTable();
ht.insert("a", "1");
ht.insert("b", "2");
ht.insert("c", "3");
ht.insert("d", "4");
ht.insert("a", "5");
// console.log(ht.search("a"));

// console.log(ht.remove("d"));
console.log(ht.printHashTable());

