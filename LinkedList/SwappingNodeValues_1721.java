//? Leetcode Problem: 1721 'Swapping Nodes in a Linked List'
//? Difficulty: 'Medium'
//? Description:

// You are given the head of a linked list, and an integer k.

// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

//? Examples: 

// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]

// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]

//? Solution Approach:
//* 1) Push() each node onto the stack
//*     -keep count of the kth element from the front pushed
//*     -store reference to this node.
//* 2) Once Stack is full, Pop() k times
//*     -store ref to the last element popped (it is kth from the back)
//* 3) swap values


//? Time Complexity = O(N)
//? Space Complexity = O(N)

import java.util.Stack;

class SwappingNodeValues_1721{
    public ListNode swapNodes(ListNode head, int k) {

        //* Create Stack and assign object reference pointers.
        Stack<ListNode> stack = new Stack<>();
        int i = 1;
        ListNode x = null, y = null, temp = head;

        //* Push all elements onto stack. Make x the kth Node.
        while (temp != null) {
            stack.push(temp);
            if (i == k)
                x = temp;
            temp = temp.next;
            i++;
        }

        //* Pop k nodes from the stack. Keep track of last popped.
        for (int j = 0; j < k; j++) {
            y = stack.pop();
        }

        //* Swap values of marked nodes.
        swapListNodeVals(x, y);

        //* Return LinkedList.
        return head;
    }

    //* Swap utility for ListNodes
    public void swapListNodeVals(ListNode x, ListNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}