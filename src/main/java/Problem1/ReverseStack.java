package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack != null && stack.size() != 0) { // check if stack is null and not empty
            int x = stack.pop(); //Pop all elements out of the stack
            reverseStack(stack); //so all elements are popped out first
            insert(stack, x); //reverses list
        }
    }

    //helper function
    //insert elements back in reverse order by removing all elements each time and placing int x into bottom
    //of the list
    //int x: element to insert
    public static void insert(Stack<Integer> stack, int x) {
        if (stack.size() == 0) { //to push x to the bottom of the list, this is how the list
            stack.push(x);       //will get reversed
        } else {
            int a = stack.pop();
            insert(stack, x); //to keep popping out items while there is items in list
            stack.push(a); //push back items into list
        }
    }
}