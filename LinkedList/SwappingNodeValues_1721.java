import java.util.Stack;

class SwappingNodeValues_1721{
    public ListNode swapNodes(ListNode head, int k) {

        // Create Stack and assign object reference pointers.
        Stack<ListNode> stack = new Stack<>();
        int i = 1;
        ListNode x = null, y = null, temp = head;

        // Push all elements onto stack. Make x the kth Node.
        while (temp != null) {
            stack.push(temp);
            if (i == k)
                x = temp;
            temp = temp.next;
            i++;
        }

        // Pop k nodes from the stack. Keep track of last popped.
        for (int j = 0; j < k; j++) {
            y = stack.pop();
        }

        // Swap values of marked nodes.
        swapListNodeVals(x, y);

        // Return LinkedList.
        return head;
    }

    // Swap utility for ListNodes
    public void swapListNodeVals(ListNode x, ListNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}