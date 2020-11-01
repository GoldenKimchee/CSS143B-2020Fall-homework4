package Problem1;

import java.util.Stack;

public class ReverseStack {
    //Pop all elements out of the stack
    public static void reverseStack(Stack<Integer> stack) {
        if (stack != null && stack.size() != 0) { // check if stack is null and not empty
            int x = stack.pop();
            reverseStack(stack);
            insert(stack, x);
        }
    }

    //helper function
    //insert elements back in reverse order
    //int x: element to insert
    public static void insert(Stack<Integer> stack, int x) {
        if (stack.size() == 0) {
            stack.push(x);
        } else {
            int a = stack.pop();
            insert(stack, x);
            stack.push(a);
        }
    }
}