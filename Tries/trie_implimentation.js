class TrieNode {
    constructor(value) {
        this.data = value;
        this.isEndOfWord = false;
        this.children = new Map();
    }
}

function insert(root, str) {
    let temp = root;
    for(let i = 0; i < str.length; i++) {
        let data = str[i];
        if(temp.children.get(data)){
            temp = temp.children.get(data);
        } else {
            temp.children.set(data, new TrieNode(data));
            temp = temp.children.get(data);
        }
    }
    temp.isEndOfWord = true;
}

function search(root, str) {
    let temp = root;
    for(let i = 0; i < str.length; i++) {
        let data = str[i];
        if(temp.children.get(data)){
            temp = temp.children.get(data);
        } else {
            return false;
        }
    }
    return temp.isEndOfWord == true;
}

function helper(root, pre, output) {
    if(!root) return;
    if(root.isEndOfWord) {
        console.log(pre + output);
    }
    for(const [key, value] of root.children.entries()) {
        helper(value, pre, output + key);
    }
 }

function prefix_search(root, pre) {
    let temp = root;
    for(let i = 0; i < pre.length; i++) {
        let data = pre[i];
        if(temp.children.get(data)) {
            temp = temp.children.get(data);
        } else {
            console.log("Prefix not found");
            return;
        }  
    }
    helper(temp, pre, "");
}

let rootNode = new TrieNode('\0');

insert(rootNode, "bat");
insert(rootNode, "batman");
insert(rootNode, "super");
insert(rootNode, "superman");
insert(rootNode, "batgirl");
insert(rootNode, "wonder");
insert(rootNode, "woman");

// console.log(search(rootNode, "batgirl"));

prefix_search(rootNode, "bat");