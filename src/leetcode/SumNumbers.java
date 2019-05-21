package leetcode;

import java.util.LinkedList;

public class SumNumbers {

    private LinkedList<String> list = new LinkedList();
    public static void main(String[] args) {
        new SumNumbers().sumNumbers();

    }
    public void sumNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String integer = "";
        inorder(root, integer);
    }
    private void inorder(TreeNode root, String integer){
        if (root != null) {
            integer += root.val+"";
            inorder(root.left, integer);
            inorder(root.right,integer);
            if (root.right == null && root.left == null) {
                list.add(integer);
                System.out.println(integer);
            }
            
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
