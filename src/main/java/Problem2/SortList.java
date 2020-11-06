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
        ListNode head = new ListNode(); //sort of like dummy node
        ListNode pointer = head; //so that the original head is not changed. only want to set what "next" will point to

        while (list1 != null && list2 != null) { //continue loop as long as both lists have element left
            if (list1.val < list2.val) {
                pointer.next = list1; //set up next item in the list we will return
                list1 = list1.next; //move to next item in list1
            } else { //if list1.val > list2.val or equal to each other
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next; //move over one step in the list
        }

        if (list1 != null) { //if list1 has items left, while list2 has no more items
            pointer.next = list1; //set pointer.next to the list1, since list1 contains the references to the rest
            //of its items
        } else { //if list2 has items left, while list1 has no more items
            pointer.next = list2;
        }
        return head.next; //skips over "dummy" node
    }
}
