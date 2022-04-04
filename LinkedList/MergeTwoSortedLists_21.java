//? Leetcode Problem 21: Merge Two Sorted Lists
//? Difficulty: Easy

// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

//? Examples: 
// List1 = 1 -> 3 -> 4
// List2 = 1 -> 2 -> 4

// O/P: 1 -> 1 -> 2 -> 3 -> 4 -> 4

//? Solution Notes: (Same subproblem as merge sort except with linked lists)
//? 2 Ptr Approach (given 2 sorted linear structures)
//* 1) Create 2 new ptrs to the front of the list w/ smallest value
    //* Head, 1st ptr above, will remain at front of the list.
//* 2) Tail equals Head initially, then selects the lesser of the 2 lists vals as its next node
//* 3) Continue until 1 list is exhausted
//* 4) Remaining list appended to Tail. Return Head.


//? TC -> O(N), SC -> O(1) as no new list is created. Just 2 pointers.
class MergeTwoSortedLists_21{
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