//! O(n) time | O(d) space
function nodeDepths(root, depth = 0) {
	
	if(root === null) return 0;
	
	return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1);
}

//! O(n) time | O(d) space
function nodeDepths(root) {

	let sumOfDepths = 0;
	
	const stack = [{node: root, depth: 0}];
	
	while(stack.length > 0) {
		const {node, depth} = stack.pop();
		if(node === null) continue;
		
		sumOfDepths += depth;
		
		stack.push({node: node.left, depth: depth + 1});
		stack.push( {node: node.right, depth: depth + 1});
	}
	return sumOfDepths;
}


class BinaryTree {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

