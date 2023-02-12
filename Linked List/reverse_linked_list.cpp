//iterative solution-----

ListNode* reverseList(ListNode* head) {
        if(head==NULL){
            return NULL;
        }
        ListNode* prev=NULL;
        ListNode* curr=head;
        ListNode* next;
        while(curr!=NULL){
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        curr=prev;
        return curr;
        
    }


//recursive solution---
ListNode* reverseList(ListNode* head) {
        if (!head || !(head -> next)) {
            return head;
        }
        ListNode* node = reverseList(head -> next);
        head -> next -> next = head;
        head -> next = NULL;
        return node;
    }
