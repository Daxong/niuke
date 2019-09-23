import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yfy
 * @version : printTreeZ.java,v 0.1 2019年08月28日 23:10
 */
public class printTreeZ {
    public static void print(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node cur;
        while (! queue.isEmpty()) {
            cur = queue.peek();
            System.out.println(cur.value);
            if (cur.L != null) {
                queue.add(cur.L);
            }
            if (cur.R != null) {
                queue.add(cur.R);
            }
            queue.poll();
        }
    }

    public static void printZ(Node root) {

        int layer = 1;
        //s1存奇数层节点
        Stack<Node> s1 = new Stack<Node>();
        s1.push(root);
        //s2存偶数层节点
        Stack<Node> s2 = new Stack<Node>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()) {
            if (layer%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    Node node = s1.pop();
                    if(node != null) {
                        temp.add(node.value);
                        System.out.print(node.value + " ");
                        s2.push(node.L);
                        s2.push(node.R);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    Node node = s2.pop();
                    if(node != null) {
                        temp.add(node.value);
                        System.out.print(node.value + " ");
                        s1.push(node.R);
                        s1.push(node.L);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
    }
    class Node{
        int value;
        Node L;
        Node R;
    }
}
