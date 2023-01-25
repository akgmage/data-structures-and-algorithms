class BST {
	constructor(value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	//! Average case: O(logn) time | O(1) space
	//! worst case: O(n) time | O(1) space
	insert(value) {
		let currentNode = this;
		while(true) {
			if(value < currentNode.value ) {
				if(currentNode.left == null) {
					currentNode.left = new BST(value);
					break;
				} else {
					currentNode = currentNode.left;
				}
			} else {
				if(currentNode.right == null) {
					currentNode.right = new BST(value);
					break;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
		return this;
	}

//! Average case: O(logn) time | O(1) space
//! worst case: O(n) time | O(1) space

contains(value) {
	let currentNode = this;
	while(currentNode) {
		if(value < currentNode.value) {
			currentNode = currentNode.left;
		} else if(value > currentNode) {
			currentNode = currentNode.right;
		} else {
			return true;
		}
	}
	return false;
	}

//! Average case: O(logn) time | O(1) space
//! worst case: O(n) time | O(1) space

remove(value, parentNode = null) {
	let currentNode = this;
	while(currentNode) {
		if(value < currentNode.value) {
			parentNode = currentNode
			currentNode = currentNode.left;
		} else if(value > currentNode.value) {
			parentNode = currentNode;
			currentNode.right;
		} else {
			// node to remove
			//If contains left and right
			if(currentNode.left && currentNode.right) {
				// get smallest value in the right subtree
				currentNode.value = currentNode.right.getMinValue();
				//remove smallest value from right subtree
				currentNode.right.remove(currentNode.value, currentNode);
			} else if(parentNode == null) { // root node
				// only left subtree
				if(currentNode.left) {
					currentNode.value = currentNode.left.value;
					currentNode.right = currentNode.left.right;
					currentNode.left = currentNode.left.left;
				} else if(currentNode.right) {
					currentNode.value = currentNode.right.value;
					currentNode.left = currentNode.right.left;
					currentNode.right = currentNode.right.right;
				} else {
					// only one node do nothing
				}
				
			} // only left subtree
			else if(parentNode.left == currentNode) {
				parentNode.left = currentNode.left != null ? currentNode.left: currentNode.right;
			} // only right subtree
			else if(parentNode.right == currentNode) {
				parentNode.right = currentNode.right != null ? currentNode.right: currentNode.left;
			}
			// we're done break the loop
			break;
		}
	}
	return this;
}
getMinValue() {
	let currentNode = this;
	while(currentNode.left) {
		currentNode = currentNode.left;
	}
	return currentNode.value;
}
}