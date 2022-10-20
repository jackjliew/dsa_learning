package gmail.jackjliew.test;
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

import java.util.List;

//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]

//Input: head = [1,2,3,4,5, 6, 7, 8], n = 3
//Output: [1,2,3,5, 7, 8]
public class RemoveNthFromEndOfList {

    public int count(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            System.out.println("count++");
            count++;
            cursor = cursor.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = count(head);
        // get mth from the beginning of the linked list
        int m = count - n + 1;
        // dummy head

        ListNode nodeToBeRemovedLeft = new ListNode(0, head);
        ListNode newHead = nodeToBeRemovedLeft;

        for (int i = 0; i < m - 1; i++) {
            nodeToBeRemovedLeft = nodeToBeRemovedLeft.next;
        }
        System.out.println("nodeToBeRemovedLeft.val=" + nodeToBeRemovedLeft.val);
        nodeToBeRemovedLeft.next = nodeToBeRemovedLeft.next.next != null ? nodeToBeRemovedLeft.next.next : null;

        return newHead.next;
    }

    public void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("head=" + null);
            return;
        }
        do {
            System.out.print(head.val + " ");
        } while ((head = head.next) != null);
        System.out.println("");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head = new ListNode(4, head);
        head = new ListNode(3, head);
        head = new ListNode(2, head);
        head = new ListNode(1, head);

        RemoveNthFromEndOfList sut = new RemoveNthFromEndOfList();
        int count = sut.count(head);
        System.out.println("count=" + count);

        ListNode removed = sut.removeNthFromEnd(head, 2);
        System.out.println(removed);


        sut.printListNode(removed);



        ListNode head2 = new ListNode(8);
        head2 = new ListNode(7, head2);
        head2 = new ListNode(6, head2);
        head2 = new ListNode(5, head2);
        head2 = new ListNode(4, head2);
        head2 = new ListNode(3, head2);
        head2 = new ListNode(2, head2);
        head2 = new ListNode(1, head2);

        ListNode removed2 = sut.removeNthFromEnd(head2, 3);
        System.out.println(removed2);
        sut.printListNode(removed2);

        //Example 2:

        //Input: head = [1], n = 1
//        Output: []
//        Example 3:

        ListNode head3 = new ListNode(1);
        sut.printListNode(sut.removeNthFromEnd(head3, 1));

//        Input: head = [1,2], n = 1
//        Output: [1]
        ListNode head4 = new ListNode(2);
        head4 = new ListNode(1, head4);
        sut.printListNode(sut.removeNthFromEnd(head4, 1));

    }

}
