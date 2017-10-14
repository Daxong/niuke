package lee.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> nowBuf = new LinkedList<>(), nextBuf = new LinkedList<>();
		ArrayList<List<Integer>> rst = new ArrayList<>();
		if(root != null) {
			nowBuf.add(root);
			while(!nowBuf.isEmpty()) {
				ArrayList<Integer> level = new ArrayList<>();
				while(!nowBuf.isEmpty()) {
					TreeNode t = nowBuf.poll();
					if(t.left != null) nextBuf.add(t.left);
					if(t.right != null) nextBuf.add(t.right);
					level.add(t.val);
				}
				rst.add(level);

				// 真·无用注释 // swap 这一层和下一层的 queue. 虽然 nowBuf 已空，直接 nowBuf=nextBuf, nextBuf=new ArrayList<>() 也行。但是 swap 省一点新建对象的资源？…… 但是变得难读了一些。那就不 swap 了。
//			tmp=nowBuf;
//			nowBuf=nextBuf;
//			nextBuf=tmp;
				nowBuf = nextBuf;
				nextBuf = new LinkedList<>();
			}
		}

		return rst;
	}
}