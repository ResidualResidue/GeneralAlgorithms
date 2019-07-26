package recAlgorithms;

public class BinarySearchTree {
	TreeNode root;
	public BinarySearchTree() {
		
	}
	public BinarySearchTree(TreeNode r) {
		root = r;
	}
	public void addNode(int toAdd) {
		TreeNode temp = root;
		if(root == null) {
			root = new TreeNode(toAdd);
		}else {
			while(true) {
				if(toAdd > temp.getValue()) {
					if(temp.getRight() == null) {
						temp.setRight(new TreeNode(toAdd));
						break;
					}else {
						temp = temp.getRight();
					}
				}else {
					if(temp.getLeft() == null) {
						temp.setLeft(new TreeNode(toAdd));
						break;
					}else {
						temp = temp.getLeft();
					}
				}
			}
		}
	}
	public TreeNode remove(int val) {
		if(!contains(val))
			return null;
		else {
			TreeNode toDel = root;
			TreeNode prev = root;
			boolean prevLarger = true;
			while(toDel != null) {
				if(toDel.getValue() == val) {
					if(toDel.getLeft() == null && toDel.getRight() == null) {
						if(prevLarger) {
							TreeNode temp = new TreeNode(val);							
							prev.setLeft(null);
							return temp;
							
						}
					}else if(toDel.getLeft() != null && toDel.getRight() == null) {
						toDel.setValue(toDel.getLeft().getValue());
						toDel.setLeft(null);
						TreeNode temp = new TreeNode(val);
						return temp;
					}else if(toDel.getRight() != null && toDel.getLeft() == null) {
						toDel.setValue(toDel.getRight().getValue());
						toDel.setRight(null);
						TreeNode temp = new TreeNode(val);
						return temp;
					}else {
						
					}
				}else if(toDel.getValue() > val) {
					toDel = toDel.getLeft();
					if(toDel.getValue() == val) {
						prevLarger = true;
						continue;
					}else
						prev = prev.getLeft();
				}else {
					toDel = toDel.getRight();
					if(toDel.getValue() == val) {
						prevLarger = false;
						continue;
					}else
						prev = prev.getRight();
				}
			}
		}
		return root;
	}
	public TreeNode search(int val) {
		TreeNode temp = root;
		while(temp != null) {
			if(temp.getValue() == val) {
				break;
			}else if(temp.getValue() > val) {
				temp = temp.getLeft();
			}else {
				temp = temp.getRight();
			}
		}
		return temp;
	}
	public boolean contains(int val) {
		
		if(search(val) == null)
			return false;
		return true;
	}
	public boolean isLeaf(int val) {
		TreeNode temp = search(val);
		if(temp == null)
			return false;
		if(temp.getRight() == null && temp.getLeft() == null) {
			return true;
		}
		return false;
	}
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(TreeNode node) {
		if(node != null) {
			System.out.println(node.getValue());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(TreeNode node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.println(node.getValue());
			inOrder(node.getRight());
		}
	}
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(TreeNode node) {
		if(node != null) {
			inOrder(node.getLeft());
			inOrder(node.getRight());
			System.out.println(node.getValue());
		}
	}
	public TreeNode getRoot() {
		return root;
	}
}
