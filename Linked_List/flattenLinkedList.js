//! https://www.codingninjas.com/codestudio/problems/1112655

function flatten(root) {
    if(root == null || root.next == null) return root;

    root.next = flatten(root.next);

    root = mergeLists(root, root.next);

    return root;
}


function mergeLists(list1, list2) {
    if(list1 == null || list2 == null) return list1 || list2;

    let dummyNode = new Node(0);
    let currentNode = dummyNode;

    while(list1 != null && list2 != null) {
        if(list1.value < list2.value) {
            currentNode.bottom = list1;
            currentNode = currentNode.bottom;
            list1 = list1.bottom;
        } else {
            currentNode.bottom = list2;
            currentNode = currentNode.bottom;
            list2 = list2.bottom;
        }
    }

    if(list1) currentNode.bottom = list1;
    else currentNode.bottom = list2;

    return dummyNode.bottom;
}


