/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // public ListNode reverseList(ListNode head){
    //     ListNode prev = null, front = null, temp = head;

    //     while(temp != null){
    //         front = temp.next;
    //         temp.next = prev;
    //         prev = temp;
    //         temp = front;
    //     }

    //     return prev;
    // }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        int length = 0;

        ListNode temp = head;

        while (temp != null) {

            length++;

            temp = temp.next;

        }

        k %= length;

        if (k == 0) return head;

        int kthNode = length - k;
        int count = 0;

        temp = head;
        ListNode prev = null;

        while(count < kthNode){
            prev = temp;
            temp = temp.next;
            count++;
        }

        prev.next = null;
        System.out.println(prev.val);

        ListNode newHead = temp;

        temp = newHead;
        while(temp.next != null)temp = temp.next;

        temp.next = head;

        return newHead;
    }
}