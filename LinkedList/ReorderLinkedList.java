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