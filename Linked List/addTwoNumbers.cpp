/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };       
 */
class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode *ansHead = new ListNode((l1->val + l2->val) % 10);
        ListNode *ans = ansHead;
        int carry = (l1->val + l2->val) / 10;
        l1 = l1->next;
        l2 = l2->next;
        while (l1 != NULL && l2 != NULL)
        {
            ListNode *temp = new ListNode((l1->val + l2->val + carry) % 10);
            carry = (l1->val + l2->val + carry) / 10;
            l1 = l1->next;
            l2 = l2->next;
            ans->next = temp;
            ans = temp;
        }
        while (l1 != NULL)
        {
            ListNode *temp = new ListNode((l1->val + carry) % 10);
            carry = (l1->val + carry) / 10;
            l1 = l1->next;
            ans->next = temp;
            ans = temp;
        }
        while (l2 != NULL)
        {
            ListNode *temp = new ListNode((l2->val + carry) % 10);
            carry = (l2->val + carry) / 10;
            l2 = l2->next;
            ans->next = temp;
            ans = temp;
        }
        if (carry > 0)
        {
            ListNode *temp = new ListNode(carry);
            ans->next = temp;
            ans = temp;
        }
        return ansHead;
    }
    ListNode *solve(ListNode *&head1, ListNode *&head2)
    {
        if (head1 == NULL)
        {
            return head2;
        }
        if (head2 == NULL)
        {
            return head1;
        }

        // linked list which contains the final answer
        ListNode *ansHead = NULL;
        ListNode *ansTail = NULL;

        int carry = 0;
        while (head1 != NULL && head2 != NULL)
        {
            int sum = head1->val + head2->val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode *newNode = new ListNode(digit);
            if (ansHead == NULL)
            {
                ansHead = newNode;
                ansTail = newNode;
            }
            else
            {
                ansTail->next = newNode;
                ansTail = newNode;
            }
            head1 = head1->next;
            head2 = head2->next;
        }

        // head1 linked list pending to be solved
        while (head1 != NULL)
        {
            int sum = carry + head1->val;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode *newNode = new ListNode(digit);
            if (ansHead == NULL)
            {
                ansHead = newNode;
                ansTail = newNode;
            }
            else
            {
                ansTail->next = newNode;
                ansTail = newNode;
            }
            head1 = head1->next;
        }

        // head2 linked list pending to be solved
        while (head2 != NULL)
        {
            int sum = carry + head2->val;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode *newNode = new ListNode(digit);
            if (ansHead == NULL)
            {
                ansHead = newNode;
                ansTail = newNode;
            }
            else
            {
                ansTail->next = newNode;
                ansTail = newNode;
            }
            head2 = head2->next;
        }

        while (carry != 0)
        {
            int sum = carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode *newNode = new ListNode(digit);
            if (ansHead == NULL)
            {
                ansHead = newNode;
                ansTail = newNode;
            }
            else
            {
                ansTail->next = newNode;
                ansTail = newNode;
            }
        }
        return ansHead;
    }
};