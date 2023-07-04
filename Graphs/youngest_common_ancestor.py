'''
    Write a function that returns the youngest common ancestor to the two descendants.

        Sample Input:
        Top ancestor: node A
        descendantOne: node e
        descandantTwo: node I

        Output: node B
            A
        /     \
        B       C
        /   \   /   \
    D     E F     G
    /   \
    H     I
        Explanation:

        This code snippet implements a solution for finding the youngest common ancestor of two descendants in an ancestral tree.

        - `type AncestralTree struct` defines the structure of a node in the ancestral tree, which contains a name and a
        reference to its ancestor node.

        - `func GetYoungestCommonAncestor` is the main function that takes three parameters: `topAncestor` (the topmost ancestor
            in the tree), `descendantOne` (the first descendant), and `descendantTwo` (the second descendant). It calculates the depths of the two descendants from the top ancestor and then calls the `backTrackAncestralTree` function with the appropriate parameters.

        - `func getDescendantDepth` calculates the depth of a descendant node from the top ancestor. It iteratively increments the
        depth and traverses through the ancestors until reaching the top ancestor.

        - `func backTrackAncestralTree` is a helper function that backtracks the ancestral tree starting from the lowest descendant
        until the depths of both descendants are equal. It first adjusts the position of the lowest descendant based on the depth difference between the two descendants. Then, it moves both descendants up the tree in tandem until they reach the same ancestor node, which is the youngest common ancestor.

        The code assumes that the `topAncestor` provided is a valid ancestor of both `descendantOne` and `descendantTwo`.
        The `GetYoungestCommonAncestor` function returns the youngest common ancestor found in the ancestral tree.

        To use this code, you need to create instances of the `AncestralTree` struct representing the ancestral tree and its nodes.
        You can then call the `GetYoungestCommonAncestor` function with the appropriate parameters to find the youngest common
        ancestor of two descendants.

        O(d) time | O(1) space - where d is the depth (height) of the ancestral tree
'''
class AncestralTree:
    def __init__(self, name):
        self.name = name
        self.ancestor = None

# Function to calculate the depth of a descendant from the top ancestor
def get_descendant_depth(descendant, top_ancestor):
    depth = 0
    while descendant != top_ancestor:
        depth += 1
        descendant = descendant.ancestor
    return depth

# Function to backtrack and find the youngest common ancestor
def back_track_ancestral_tree(lowest_descendant, higher_descendant, diff):
    while diff > 0:
        lowest_descendant = lowest_descendant.ancestor
        diff -= 1
    while lowest_descendant != higher_descendant:
        lowest_descendant = lowest_descendant.ancestor
        higher_descendant = higher_descendant.ancestor
    return lowest_descendant

# Function to find the youngest common ancestor of two descendants
def get_youngest_common_ancestor(top_ancestor, descendant_one, descendant_two):
    depth_one = get_descendant_depth(descendant_one, top_ancestor)
    depth_two = get_descendant_depth(descendant_two, top_ancestor)

    if depth_one > depth_two:
        return back_track_ancestral_tree(descendant_one, descendant_two, depth_one - depth_two)
    return back_track_ancestral_tree(descendant_two, descendant_one, depth_two - depth_one)

# Create the ancestral tree
top_ancestor = AncestralTree("A")
B = AncestralTree("B")
C = AncestralTree("C")
D = AncestralTree("D")
E = AncestralTree("E")
F = AncestralTree("F")
G = AncestralTree("G")
H = AncestralTree("H")
I = AncestralTree("I")

# Set up the ancestral relationships

#          A
#        /   \
#       B     C
#      / \   / \
#     D   E F   G
#    /
#   H
#  /
# I

top_ancestor.ancestor = None
B.ancestor = top_ancestor
C.ancestor = top_ancestor
D.ancestor = B
E.ancestor = B
F.ancestor = C
G.ancestor = C
H.ancestor = D
I.ancestor = H

# Find the youngest common ancestor of two descendants
descendant_one = F
descendant_two = I
yca = get_youngest_common_ancestor(top_ancestor, descendant_one, descendant_two)

print("The youngest common ancestor of", descendant_one.name, "and", descendant_two.name, "is", yca.name)
