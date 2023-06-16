'''
Issue#528
Date:16/06/2023
Input:
Linked List: Reverse Linked List Recursively and Iteratively in Python 

Example 1:
Enter the values for the linked list (space-separated): 1 2 3 4 5
Choose the reversal method (iterative or recursive): iterative
5 4 3 2 1

Explanation:
*The `create_linked_list()` function:
   - This function prompts the user to enter values for the linked list, which are expected to be space-separated.
   - The input values are split into a list of strings using the `split()` method.
   - The function then iterates over the input values, creating a new `ListNode` object for each value.
   - The `next` pointers of the nodes are appropriately set to form the linked list.
   - Finally, the function returns the head of the linked list.

* The `reverse_linked_list_iterative()` function:
   - This function takes the head of a linked list as input.
   - It initializes two pointers: `prev` and `current`. `prev` is initially set to `None`, and `current` is set to the head.
   - The function iterates over the linked list using a while loop.
   - In each iteration, it stores the next node in a variable called `next_node`.
   - Then, it updates the `next` pointer of the current node to point to the previous node (`prev`).
   - The `prev` pointer is updated to the current node, and the `current` pointer is updated to the next node (`next_node`).
   - This process continues until `current` becomes `None`, which means the end of the original linked list has been reached.
   - Finally, the function returns the new head of the reversed linked list, which is stored in `prev`.

* The `reverse_linked_list_recursive()` function:
   - This function is a recursive implementation of reversing a linked list.
   - It takes the head of a linked list as input.
   - First, it checks two base cases: if the head is `None` or the head's `next` pointer is `None`. In these cases, it simply returns the head as it is.
   - If the base cases are not met, it recursively calls itself on the next node (`head.next`) to reverse the remaining sublist.
   - Once the recursion reaches the last node in the original linked list, it starts updating the `next` pointers to reverse the sublist.
   - The `next` pointer of the current node (`head`) is set to the previous node (`head.next.next`), effectively reversing the connection.
   - The `next` pointer of the current node is then set to `None` to complete the reversal.
   - Finally, the function returns the new head of the reversed linked list.

Time Complexity:
O(n)(both recursive and iterative method)
Space Complexity:
Iterative approach: O(1) space complexity.
Recursive approach: O(n) space complexity.
'''
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def create_linked_list():
    # Take user input for the linked list values
    values = input("Enter the values for the linked list (space-separated): ").split()
    
    # Create the linked list from the input values
    head = None
    prev = None
    
    for val in values:
        node = ListNode(int(val))
        
        if not head:
            head = node
        else:
            prev.next = node
        
        prev = node
    
    return head

def reverse_linked_list_iterative(head):
    prev = None
    current = head
    
    while current:
        next_node = current.next
        current.next = prev
        prev = current
        current = next_node
    
    return prev

def reverse_linked_list_recursive(head):
    if not head or not head.next:
        return head
    
    reversed_list = reverse_linked_list_recursive(head.next)
    head.next.next = head
    head.next = None
    
    return reversed_list

def reverse_linked_list(head, method='iterative'):
    if method == 'iterative':
        return reverse_linked_list_iterative(head)
    elif method == 'recursive':
        return reverse_linked_list_recursive(head)
    else:
        raise ValueError('Invalid method specified.')

# Create the linked list based on user input
head = create_linked_list()

# Ask the user to choose the reversal method
method = input("Choose the reversal method (iterative or recursive): ")

# Reverse the linked list using the chosen method
reversed_list = reverse_linked_list(head, method=method)

# Traverse the reversed linked list and print the values
current = reversed_list
while current:
    print(current.val, end=' ')
    current = current.next


