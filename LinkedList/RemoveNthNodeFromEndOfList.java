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