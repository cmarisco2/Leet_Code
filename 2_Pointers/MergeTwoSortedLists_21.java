class MergeTwoSortedLists_21{

      public class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // edge cases:
            if (list1 == null && list2 == null)
                return null;
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;
            // 2 Pointers
            ListNode head;
            ListNode tail;

            // Pick Head of List
            if (list1.val < list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }
            tail = head;
            head.next = null;
            tail.next = null;

            // Merge until 1 list is exhausted
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    tail = tail.next;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    tail = tail.next;
                    list2 = list2.next;
                }
                tail.next = null;
            }

            // Merge the remaining list (if both not exhausted)
            if (list2 != null)
                tail.next = list2;
            if (list1 != null)
                tail.next = list1;
            while (tail.next != null)
                tail = tail.next;
            // Return list
            return head;
        }

}