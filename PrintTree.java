import java.util.LinkedList;
import java.util.Queue;

public class PrintTree //层序遍历
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        levelPrint(root);
    }

    public static void levelPrint(TreeNode root)
    {
        if (root == null)
            return ;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = root;
        while( !queue.isEmpty() )
        {
            TreeNode temp = queue.poll();
            if ( temp.left != null)
            {
                queue.add(temp.left);
                nlast = temp.left;
            }
            if ( temp.right != null ) {
                queue.add(temp.right);
                nlast = temp.right;
            }

            if(last == temp) {
                System.out.println(temp.val);
                last = nlast;
            }
            else {
                System.out.print(temp.val);
            }
        }
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
