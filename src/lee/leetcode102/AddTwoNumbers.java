package lee.leetcode102;

import java.util.List;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
//        l4.next = l5;
//        l5.next = l6;

        ListNode head = addTwoNumbers(l1,l4);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode head = new ListNode(0);
        head.next = list;
        int carry = 0;
        int sum   = 0;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if(sum > 9 ){
                list.val = sum -10;
                carry = 1;
            }else{
                list.val = sum;
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null){
                list.next = new ListNode(0);

            }
            list = list.next;
        }
        //直接连接剩余链表
        if(l1 != null ) {
            list = l1;
        }else if (l2 != null){
            list = l2;
        }
        //如果此时仍然有进位
        while(carry == 1) {
            sum = list.val + 1;
            if(sum > 9 ){
                list.val = sum -10;
                carry = 1;
                if (list.next == null && carry == 1) {
                    list.next = new ListNode(0);
                }
                list = list.next;
            }else{
                list.val = sum;
                carry = 0;
            }
        }

        return head.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
