class ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

def find_middle(head):
    # Initialize slow and fast pointers to the head of the linked list
    slow_ptr = head
    fast_ptr = head

    # Traverse the linked list with slow and fast pointers
    while fast_ptr is not None and fast_ptr.next is not None:
        # Move slow pointer one step at a time
        slow_ptr = slow_ptr.next
        # Move fast pointer two steps at a time
        fast_ptr = fast_ptr.next.next

    # When the fast pointer reaches the end, the slow pointer will be at the middle
    return slow_ptr

# Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head.next.next.next.next = ListNode(5)

# Find the middle node of the linked list
middle_node = find_middle(head)

# Print the value of the middle node
print("Middle Node:", middle_node.value)  # Output: Middle Node: 3
