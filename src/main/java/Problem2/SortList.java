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

    public static ListNode findMidAndBreak(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        length = length / 2;
        int iteration = 0;
        while (iteration < length) {
            iteration++;
            temp = temp.next;
        }
        ListNode address = temp.next;
        temp.next = null;
        return address; //output should be pointing (a reference) to the middle node
    }


    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode merged;
        // 1, 3, 4
        // 2, 4, 5
        if (temp1.val < temp2.val) {
            merged = temp1;
            temp1 = temp1.next;
        } else { //if temp1.val > temp2.val || temp1.val == temp2.val
            merged = temp2;
            temp2 = temp2.next;
        }

        while (temp1 != null  && temp2 != null) { //both have to be empty
            if (temp1.val < temp2.val) {
                merged.next = temp1;
                temp1 = temp1.next;
            } else if (temp1.val > temp2.val || temp1.val == temp2.val) {
                merged.next = temp2;
                temp2 = temp2.next;
            } else if (temp1 == null) {
                while (temp2 != null) {
                    merged.next = temp2;
                    temp2 = temp2.next;
                }
            } else if (temp2 == null) {
                while (temp1 != null) {
                    merged.next = temp1;
                    temp1 = temp1.next;
                }
            }
            merged = merged.next;
        }
        return merged;
    }
}
