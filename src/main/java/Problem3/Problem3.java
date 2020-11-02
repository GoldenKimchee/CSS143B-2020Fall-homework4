package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        if (list == null) { //if no items in list
            return;
        }

        //main function
        //recurse till at the end of the list
        if (list.next != null) {
            printListInReverse(list.next, print);
        }
        print.println(list.val); //finally, print items in reverse order
    }
}
