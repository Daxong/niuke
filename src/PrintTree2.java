import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class PrintTree2 {
	public int[][] printTree(TreeNode root) {
		// write code here
		if(root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		queue.add(root);
		TreeNode last = root;
		TreeNode nlast = last;
		int row = 0;
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp.left != null) {
				queue.add(temp.left);
				nlast = temp.left;
			}
			if(temp.right != null) {
				queue.add(temp.right);
				nlast = temp.right;
			}

			if(last == temp) {
				list.add(temp.val);
				list.add(-1);
				last = nlast;
				row++;

			} else {
				list.add(temp.val);
				row++;
			}
		}
		System.out.println(row);

		int[][] ints = new int[row][row];

		int i = 0;
		for(int j = 0, len = i; j < list.size() - len; len++) {

			if(list.get(len) == -1) {
				i++;
				j = 0;
				continue;
			} else {
				ints[i][j] = list.get(len);
				System.out.println("[" + i + "]" + "[" + j + "] : " + ints[i][j]);
				/**
				 * 此处打印的结果和预期相同
				 */
				j++;
			}


		}
		for(int n = 0; n < row; n++) {
			for(int j = 0; j < row; j++) {
				System.out.println(ints[n][j]);
			}
		}
		return ints;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		PrintTree2 p = new PrintTree2();
		int[][] ints = p.printTree(root);

//        for (int i=0;i<ints.length;i++){
//            for (int j=0; j<ints[i].length;j++){
//                System.out.println(ints[i][j]);
//            }
//        }
	}
}