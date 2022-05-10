//? Problem 19: Remove the Nth Node From the End of a Linked List
//? Difficulty: 'Medium'
//? Description:

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Follow up: Could you do this in one pass?

//? Examples:

// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Input: head = [1], n = 1
// Output: []

// Input: head = [1,2], n = 1
// Output: [1]

//? Solution Approach: 2Ptr + DummyNode (w/DummyNode.next)
//* Have 2 Ptrs (left & right)
//* Dummy Node inserted in front of head (left starts here)
//* Right is forward by 'n' elements of head initially.

//* Then:
    //* move left & right until right hits 'null'
    //* redirect around the node to be removed.

//* Return dummyNode.next


//? Time Complexity = O(N)
//? Space Complexity = O(1)
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;

        ListNode left = preHead;
        ListNode right = head;

        if (head.next == null)
            return null;

        for (int i = 0; i < n; i++)
            right = right.next;

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return preHead.next;
    }
}