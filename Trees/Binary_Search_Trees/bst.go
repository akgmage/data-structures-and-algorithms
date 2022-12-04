// Binary Search tree implementation
package main

import (
	"math/rand"
)

type BSTNode struct {
	left *BSTNode
	data int
	right *BSTNode
}
func ConstructBST(n, k int) *BSTNode {
	var root *BSTNode
	for _, v := range rand.Perm(n) {
		root = Insert(root, (1 + v) * k)
	}
} 


func main() {

}