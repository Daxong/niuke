package niuke;

import java.util.*;

/**
 * 老虎证券笔试题
 * 环形字符串中寻找包含ABCDE的最短连续子串，返回长度
 * 暴力解法：从头出发遍历寻找再回到头 求得最短长度
 * bug
 * 目前方案没有正确找取最短子串
 */
public class SerialSubString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String   str = scan.nextLine();
        HashSet  set = new HashSet();
        //找出字符串中包含的目标字符
        Node head = new Node();
        Node prev = new Node();
        head = prev;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E') {
                set.add(c);
            }
            prev.next = new Node(c);
//            if (i != str.length()-1){
                prev = prev.next;

        }
        prev.next = head.next;
        //确定队列长度
        LinkedList<Node> queue = new LinkedList<>();
        Queue<Character> queueInt = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Node index = new Node();
        boolean flag = true;
        HashSet setclone = set;
        int size = set.size();
        int count = 0;
        int lock = 0;
        while (head != null) {
            if (set.contains(head.value) && !queueInt.contains(head.value)) {
                queue.add(head);
                queueInt.add(head.value);
                count++;
                lock = 1;
                if (queue.size() == size) {
                    priorityQueue.add(count);
                    count = 0;
                    queue.poll();
                    queueInt.poll();
                    Node node = queue.getFirst();
                    if (index == node) {
                        break;
                    }
                    queue.clear();
                    queueInt.clear();
                    head = node;
                    continue;
                }
                if (flag) {
                    index = head;
                    flag  = false;
                }
            }else if (lock == 1){
                count++;
            }
            head = head.next;
        }

        System.out.println(priorityQueue.peek());
    }

    private static class Node{
        char value;
        Node next;
        public Node(char value){
            this.value = value;
        }
        public Node(){

        }
    }

}
