//? Problem 143: Reorder List
//? Difficulty: 'Medium'
//? Description:

// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln

// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

//? Examples:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

//? Solution Notes:
//* Find Middle of List
//* Reverse the List
//* Add Elements to a 'new' List

// 1 -> 2 -> 3 -> 4 -> 5 -> null
// Becomes:
// 1 -> 2 -> 3 <- 4 <- 5
//           |
//           v
//          null
// L                   R

//* Create New List with the above diagram as the starting point.
//* UTILIZE REVERSE LINKED LIST METHOD FROM PREVIOUS PROBLEM

public class ReorderLinkedList{
    public void reorderList(ListNode head) {
        int count = 1;
        // Find Tail.
        // Increment Count.
        ListNode tail = head;
        ListNode mid = head;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }

        int splitIndex = count / 2;
        count = 0;

        // Find mid Node
        while (count < splitIndex) {
            mid = mid.next;
            count++;
        }

        // Reverse from middle node
        ListNode back = reverseList(mid);

        // Nodes to reorder
        ListNode right = back, res = head, left = res.next;

        // reorder loop
        while (left != null && right != null && left != right) {
            res.next = right;
            right = right.next;
            res = res.next;
            res.next = left;
            left = left.next;
            res = res.next;
            if (left == right)
                res.next = right;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode i = head;
        ListNode j = head == null ? null : head.next;

        // Returns list if NONE or ONLY 1 ListNode is present.
        if (j == null)
            return head;

        // Find Tail to be new head
        ListNode tail = head;
        while (tail.next != null)
            tail = tail.next;

        // Reverse List
        reverse(i, j);
        i.next = null; // Eliminate possible cycle
        // Return head of list
        return tail;
    }

    public void reverse(ListNode i, ListNode j) {
        if (j == null)
            return;
        reverse(i.next, j.next);
        j.next = i;
    }
}