//? Leetcode Problem 155: MinStack
//? Difficulty: 'Easy' -> really 'medium'
//? Description: 

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.

//? Example:

// Input["MinStack","push","push","push","getMin","pop","top","getMin"][[],[-2],[0],[-3],[],[],[],[]]

// Output[null,null,null,null,-3,null,0,-2]

// Explanation MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
//minStack.getMin(); // return -3
// minStack.pop();
//minStack.top(); // return 0
// minStack.getMin(); // return -2

//? Solution Approach: Parallel Stacks
//* Push(val):
    //* Use MainStack to add all values that come
    //* Use MinStack to add a value IFF it is less than Top of MinStack OR MinStack is Empty
//* Pop():
    //* Pop MainStack as normal
    //* If popped value EQUALS top of MinStack -> Pop MinStack
import java.util.Stack;

public class MinStack{
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.peek().equals(minStack.peek()))
            minStack.pop();
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        int[] testVals = {5, 7, 0, -3, 2, 1, 7};

        for(int val : testVals){
            stack.push(val);
        }

        System.out.println("current min is: " + stack.getMin()); // -3
        System.out.println("top of stack is: " + stack.top()); // 7
        for(int i = 0; i < 4; i++)
        stack.pop();
        System.out.println("current min is: " + stack.getMin()); //0
        System.out.println("top of stack is: " + stack.top()); // 0
        stack.pop();
        System.out.println("current min is: " + stack.getMin()); //5
        System.out.println("top of stack is: " + stack.top()); // 7
    }
}
