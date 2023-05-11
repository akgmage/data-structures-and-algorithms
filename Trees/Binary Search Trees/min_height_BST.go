package main

func MinHeightBST(array []int) *BST {
	// call helper method with start index, end index array and nil node
	return constructMinHeightBST(array, nil, 0, len(array)-1)
}

func constructMinHeightBST(array []int, bst *BST, start int, end int) *BST {
	// base case
	if end < start {
		return nil
	}
	mid := (start + end) / 2
	value := array[mid]
	// there are no value in bst
	if bst == nil {
		bst = &BST{Value: value}
	} else {
		bst.Insert(value)
	}
	constructMinHeightBST(array, bst, start, mid-1)
	constructMinHeightBST(array, bst, mid+1, end)
	return bst
}

type BST struct {
	Value int

	Left  *BST
	Right *BST
}

func (tree *BST) Insert(value int) *BST {
	if value < tree.Value {
		if tree.Left == nil {
			tree.Left = &BST{Value: value}
		} else {
			tree.Left.Insert(value)
		}
	} else {
		if tree.Right == nil {
			tree.Right = &BST{Value: value}
		} else {
			tree.Right.Insert(value)
		}
	}
	return tree
}
