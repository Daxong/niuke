package niuke;

import java.util.Scanner;

public class ReverseList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(",");
        int k = scan.nextInt();
        //构造链表
        Node head = new Node();
        Node curr = new Node();
        curr.prev = curr;
        curr.next = curr;
        head = curr;

        for (int i = 0; i < str.length; i++) {
            curr.next = new Node(str[i]);
            Node temp = curr;
            curr = curr.next;
            curr.prev = temp;
        }
        Node node = reverse(head.next,2);

    }

    public static Node reverse(Node node, int k){
        Node curr = node;
        int count = 0;
        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverse(curr,k);
            while (count > 0) {
                Node temp = node.next;
                node.next = curr;
                curr = node;
                node = temp;
                count--;
            }
            node = curr;
        }
        return node;
    }


    private static class Node{
        Node prev;
        Node next;
        String val;
        public Node(String val){
            this.val = val;
        }
        public Node() {}
    }

}
