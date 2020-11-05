package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    //splits the list until one element left, then merges the lists together
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head); //split a single linked list into two lists
        return mergeLists(sortList(head), sortList(mid)); //split into halves until element by itself and put together
    }


    //makes two passes
    public static ListNode findMidAndBreak(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) { //go through list to count length
            length++;
            temp = temp.next;
        }

        temp = head; //reset to point to head
        length = length / 2; //find middle
        int iteration = 1;
        while (iteration < length) {
            iteration++;
            temp = temp.next;
        }
        ListNode address = temp.next; //store address of next node
        temp.next = null; //have the current node (at halfway point) now point to null (splits list in half)
        return address; //reference to the middle node
    }


    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode merged = null;
        //
        //
        while (temp1 != null || temp2 != null) { //both have to be empty
            if (temp1.val < temp2.val) {
                merged = temp1;
                temp1 = temp1.next;
            } else if (temp1.val > temp2.val || temp1.val == temp2.val) {
                merged = temp2;
                temp2 = temp2.next;
            } else if (temp1 == null) {
                while (temp2 != null) {
                    merged = temp2;
                    temp2 = temp2.next;
                    merged = merged.next;
                }
            } else if (temp2 == null) {
                while (temp1 != null) {
                    merged = temp1;
                    temp1 = temp1.next;
                    merged = merged.next;
                }
            }
            merged = merged.next;
        }
        return merged;
    }
}
