package recAlgorithms;

public class TreeNode {
	int value;
	TreeNode l;
	TreeNode r;
	public TreeNode(int val) {
		value = val;
	}
	public void setRight(TreeNode right) {
		r = right;
	}
	public void setLeft(TreeNode left) {
		l = left;
	}
	public TreeNode getRight() {
		return r;
	}
	public TreeNode getLeft() {
		return l;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int i) {
		value = i;
	}
}
