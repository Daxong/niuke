package niuke;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
/**
 * 超级简单的链表环检测算法
 */

import java.util.HashSet;
import java.util.Scanner;
public class CheckLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strings = scan.nextLine();
        String[] chars = strings.split(",");
        Node head = new Node();
        Node next = new Node();
        head = next;

        for (int i = 0; i < chars.length; i++) {
            next.next = new Node(chars[i]);
            next = next.next;
        }
        HashSet<String> set = new HashSet<>();
        while (head != null ) {
            if (set.contains(head.val)) {
                System.out.println("true");
                return;
            }
            set.add(head.val);
            head = head.next;
        }
        System.out.println("false");
    }
    private static class Node{
        Node next;
        String val;
        public Node(){}
        public Node(String val){
            this.val = val;
            this.next = null;
        }
    }
}
