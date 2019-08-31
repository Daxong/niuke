package leetcode;

import javax.xml.soap.Node;

/**
 * @author yfy
 * @version : IsBST.java,v 0.1 2019年08月30日 23:38
 */
public class IsBST {
    public static boolean isBST(Node root){
        Node prev = null;

        // 中序遍历这棵树，并保存前驱节点至prev中
        if (root != null)
        {
            if (!isBST(root.left))
                return false;

            // 检测节点值的合法性
            if (prev != null  && root.val <= prev.val)
                return false;

            prev = root;

            //右子树
            return isBST(root.right);
        }

        return true;
    }
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int i) {
            this.val = i;
            this.left = null;
            this.left = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(isBST(root));
    }
}
