# PROBLEM TO SOLVE
"""
    Remove the Nth node from the end of the linked list
    assume input is always valid and that k will be a non-negative number
    that is less than the length of the list
"""

# define node used in linked list
class node:
    def __init__(self,v=0,n=None):
        self.val = v
        self.next = n

# function to create list of length n, node values start at 1 and incrament
# this is NOT part of the algorithm, just part of the setup
def create_list(n):
    if n <= 0:
        raise Exception()
    head = node(1)
    curr = head
    for i in range(2,n+1):
        next = node(i)
        curr.next = next 
        curr=curr.next
    return head
def print_list(head):
    while head:
        print(head.val)
        head = head.next

# helper function (used in both recursive and iterative)
def __remove_node(prev,curr):
    prev.next = curr.next
# recursive function
def recursive(head, n):
    # create nested helper function called rec
    # this allows us to keep the function signature of recursive clean and consistant with iterative
    # in real life the client does not usually care if your function is iterative or recursive
    # so you want both functions to have just two arguments when the client calls them
    def rec(lag,lead, k):
        # move lead up k nodes before we even start moving lag
        if k > 0:
            k -= 1
            lead = lead.next
        else:
            if not lead: # base case 1: remove head if lead goes passed last node
                return head.next
            elif not lead.next: # base case 2: skip kth node if lead is on last node
                lag.next = lag.next.next
                return head
            else: # move both nodes up until lead is at the last node
                lead = lead.next
                lag = lag.next
        return rec(lag,lead,k) # call the recursive case
    # if we did not create a helper function, the client would need to call recursive
    # with 3 arguments instead of 2 which is confusing.
    return rec(head,head,n)


# iterative function
def iterative(head,k):
    # start lag and lead at head
    lag = lead = head
    # lead gets a headstart, it moves up k nodes before lag starts moving
    for _ in range(k):
        lead = lead.next
    # if lead made it passed the end, then lag must still be at head
    if not lead:
        return lag.next
    # we want to keep moving both lead and lag by one until lead is at the last node
    # keep in mind that we want to stop lag one bofore the node we want to delete.
    # this is because need to skip over the kth node from the end
    while lead.next:
        lead = lead.next
        lag = lag.next
    # we skip the kth from end node by assiging lag.next to lag.next.next
    # pythons built in garbage collection will recognize that the kth node
    # is unreachable and will delete it for us, no need to call del!
    lag.next = lag.next.next
    return head

# text functions below main
if __name__ == "__main__":
    head = create_list(9)
    print("before removal")
    print_list(head)
    print("after removing 2nd from last node iteratively")
    rem_head = iterative(head,2)
    print_list(rem_head)
    head = create_list(9)
    print("after removing 3rd from last recursivly")
    rem_head = recursive(head,3)
    print_list(rem_head)
