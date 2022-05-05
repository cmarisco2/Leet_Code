public class  ReverseLinkedList{
    public ListNode reverseList(ListNode head) {
        ListNode i = head;
        ListNode j = head == null ? null : head.next;
        
        // Returns list if NONE or ONLY 1 ListNode is present.
        if (j == null) return head;

        // Find Tail to be new head
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;

        // Reverse List
        reverse(i, j);
        i.next = null; // Eliminate possible cycle
        // Return head of list
        return tail;
    }

    public void reverse(ListNode i, ListNode j) {
        if (j == null) return;
        reverse(i.next, j.next);
        j.next = i;
    }
}