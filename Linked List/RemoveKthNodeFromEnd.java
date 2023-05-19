//Problem Number : 19 - Leetcode

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * Problem Description :
 * Given the head of a linked list, remove the nth node
 * from the end of the list and return its head.
 * 
 * linkedlist = 1 -> 2 -> 3 -> 4 -> 5-> null
 * n = 2
 */

/*
 * Approach we follow to solve this Problem.
 * Given : head of linkedlist and n = number of node to remove from end
 * Solution :
 * => Since we have to remove node from end , we need to calculate length of
 * linkedlist.
 * To do so lets create a function calcLength() , it take head node as parameter
 * and return length of linked list .
 * => Store the length of linkedlist in variable namely (len) by calling
 * function calcLength().
 * => To make it simple , lets calculate position of node from start of
 * linkedlist by subtracting length of node with nth node to remove.
 * and store the result in another variable called target. [ target = len - n]
 * => Now, we check for target == 0 and if its true than we have to remove our
 * head and point the head to next element .
 * for ex : head.next = head
 * After just return our head because we have no need to check other part.
 * => create a pointer = 1 and store head of LikedList to temp variable .
 * => After that , we have to iterate over linkedlist till our temp is not equal
 * to null to find our target element.
 * (Note : target element is always prev of node of node to remove for ex : 1-> 2-> 3->4-> 5 
 * In this case 3 is our target because we have to remove 4.)
 * => for each iteration , we check if our target == pointer , In case its true
 * the we have to handle two case :
 * Case 1 : if our target node is last node of linked list ,then point temp to
 * null
 * explanation : 1-> 2-> 3-> 4-> 5 -> null
 * if our target is 5 the our new linkedlist will we like this : 1-> 2-> 3-> 4->
 * null
 * Case 2 : Target is in middle of linkedlist then , update temp pointer to
 * temp.next.next
 * explanation : 1-> 2-> 3-> 4-> 5 -> null
 * let say we have to remove 3 : then temp = 2
 * temp.next = 3 : node to remove
 * temp.next.next = 4
 * output : 1-> 2-> 4-> 5 -> null
 * => increment pointer and update temp to next node.
 * => In last just return node
 */

class Solution {

    public int calcLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = calcLength(head);
        int target = len - n;
        if (target == 0) {
            head = head.next;
            return head;
        }
        int pointer = 1;

        ListNode temp = head;
        while (temp != null) {
            if (pointer == target) {
                ListNode key = temp.next;
                if (key == null) {
                    temp = null;
                } else {
                    temp.next = key.next;
                }

            }
            pointer++;
            temp = temp.next;
        }

        return head;

    }
}