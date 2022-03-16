//? Leetcode <String> Problem 20: Valid Parentheses
//? Difficulty: 'Easy'
//? Description: 
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.

//? Examples: 
// Input: s = "()"
// Output: true

// Input: s = "()[]{}"
// Output: true

// Input: s = "(]"
// Output: false

// Input: s = "{[()]}"
// Output: true

//? Solution Approach: Stack Solution
//* push onto stack any number of open parentheses
//* if closed parantheses, pop stack and verify complement parantheses

//? Solution Notes: 
//* 1) Create Hash Map, (Key -> Closing Char, Value -> Opening Char)
//* 2) Create Char Stack
//* 3) implement Stack Solution described above
//* 4) At the end, if the stack is empty -> true, false otherwise

//? Time & Space
//* TC: O(N), SC: O(N)
import java.util.HashMap;
import java.util.Stack;

class ValidParentheses_20{
    public boolean isValid(String s) {
        HashMap<Character, Character> closeMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        closeMap.put(']', '[');
        closeMap.put('}', '{');
        closeMap.put(')', '(');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (closeMap.containsKey(ch) && stack.isEmpty())
                return false;
            else if (closeMap.containsKey(ch) && !stack.isEmpty()) {
                char match = stack.pop();
                if (match != closeMap.get(ch))
                    return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}