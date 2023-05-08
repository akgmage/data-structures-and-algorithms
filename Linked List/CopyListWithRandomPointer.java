/**
 * Problem Description
 * A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
 *
 * Return a deep copy of the list.
 *
 *
 *
 * Problem Constraints
 * 0 <= |A| <= 106
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the required linked list.
 *
 *
 *
 * Example Input
 * Given list
 *    1 -> 2 -> 3
 * with random pointers going from
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 *
 *
 *
 * Example Output
 *    1 -> 2 -> 3
 * with random pointers going from
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 *
 *
 *
 * Example Explanation
 * You should return a deep copy of the list. The returned answer should not
 * contain the same node as the original list, but a copy of them. The pointers
 * in the returned list should not link to any node in the original input list.
 */
package Linear.LinkedLists;

public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node tail = new Node(1);

        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = tail;
        node3.next = tail;
        node3.random = node2;

        Node ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static Node solve(Node head) {
        // O(N) time | O(1) space

        /**
         1. create new nodes in between the list
         2. update randomPointer for new-nodes
         3. split the old and new-nodes
         4. return new-list head;
         */

        //1. create the new-node in between old nodes30    \][poiytrewq
        Node currNode = head;
        while (currNode != null) {
            Node newNode = new Node(currNode.val);
            // update new-node pointers
            newNode.next = currNode.next;
            currNode.next = newNode;

            // update current node
            currNode = newNode.next;
        }

        //2. update new-nodes random pointers
        currNode = head;
        while (currNode != null) {
            if (currNode.random == null) {
                currNode.next.random = null;
                currNode = currNode.next.next;
                continue;
            }
            currNode.next.random = currNode.random.next;
            currNode = currNode.next.next;
        }
        // 3. separate the old and new nodes from the list
        Node oldHead = head;
        Node newHead = head.next;
        Node temp1 = oldHead;
        Node temp2 = newHead;

        while (temp2.next != null) {
            temp1.next = temp1.next.next;
            temp2.next = temp2.next.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        // remove all old-node pointer which is pointing to
        // new-node tail
        temp1.next = null;
        return newHead;
    }
}
