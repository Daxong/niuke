package JavaProperties;
import java.util.Scanner;

class Node{
    public int val;
    public Node left,right;
    Node(int val){
        this.val = val;
        left = right = null;
    }
    Node(){}
}

public class KuaishouQiuhe {
    private Scanner in = new Scanner(System.in);
    private int prei = 0;

    public Node buildTree(int[] preorderArray,int[] inorderArray) {//根据先序-后序遍历结果构造二叉树
        if(preorderArray.length == 0 || inorderArray.length == 0 || preorderArray.length != inorderArray.length)
            return null;
        return buildTree_core(preorderArray, inorderArray, 0, inorderArray.length);
    }

    /**
     * 还原树
     * @param preorderArray
     * @param inorderArray
     * @param inleft
     * @param inright
     * @return
     */
    public Node buildTree_core(int[] preorderArray,int [] inorderArray,int inleft,int inright) {

        if(prei >= inorderArray.length || inleft > inright)
            return null;

        int key = preorderArray[prei++];
        Node root = new Node(key);
        int pos = 0;
        for(int i=0;i<inorderArray.length;++i) {
            if(inorderArray[i] == key) {
                pos = i;
                break;
            }
        }

        root.left = buildTree_core(preorderArray,inorderArray,inleft,pos-1);
        root.right = buildTree_core(preorderArray,inorderArray,pos+1,inright);

        return root;
    }

    public int[] inputLine() {
        String str = in.nextLine();
        String[] words = str.split(" ");
        int[] Array = new int[words.length];
        for(int i=0;i<words.length; ++i) {
            Array[i] = Integer.parseInt(words[i]);
        }

        return Array;
    }


    public void treeSum(Node root) {
        if(root == null)
            return;
        treeSum_Core(root);
        tranversal(root);
    }

    public int treeSum_Core(Node root) {

        int temp = 0;
        if(root != null)
            temp = root.val;
        else
            return 0;

        if(root.left == null && root.right == null) {//叶子结点
            root.val  = 0;
            return temp;
        }

        root.val = treeSum_Core(root.left) + treeSum_Core(root.right);

        return (temp + root.val);
    }

    public void tranversal(Node root) {
        if(root == null)
            return;
        tranversal(root.left);
        System.out.print(root.val+" ");
        tranversal(root.right);
    }

    public static void main(String[] args) {
        KuaishouQiuhe m = new KuaishouQiuhe();
        int []preorderArray = m.inputLine();
        int []inorderArray = m.inputLine();
        Node root =   m.buildTree(preorderArray, inorderArray);
        m.treeSum(root);
    }

}