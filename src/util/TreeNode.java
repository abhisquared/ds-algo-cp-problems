package util;

public class TreeNode<T> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;

	public TreeNode() {
	}

	public TreeNode(T val) {
		this.val = val;
	}

	TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	TreeNode(T val, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public T getVal() {
		return val;
	}

	public T val() {
		return this.getVal();
	}

	public void setVal(T val) {
		this.val = val;
	}

	public TreeNode<T> val(T val) {
		this.setVal(val);
		return this;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public TreeNode<T> left() {
		return this.getLeft();
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> left(TreeNode<T> left) {
		this.setLeft(left);
		return this;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public TreeNode<T> right() {
		return this.getRight();
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> right(TreeNode<T> right) {
		this.setRight(right);
		return this;
	}

	public static TreeNode<Integer> withCount(int count) {
		Integer[] array = new Integer[count];
		for (int i = 1; i <= count; i++) {
			array[i - 1] = i;
		}
		return withAllNodesGiven(array);
	}

	@SuppressWarnings("unchecked")
	public static <T> TreeNode<T> withAllNodesGiven(T... array) {
		TreeNode<T>[] nodes = (TreeNode<T>[]) new TreeNode[array.length];
		for (int i = 0; i < array.length; i++) {
			if (null != array[i]) {
				nodes[i] = new TreeNode<T>(array[i]);
			} else {
				nodes[i] = null;
			}

		}
		TreeNode<T> root = nodes[0];
		for (int i = 0; i < array.length; i++) {
			if (null != nodes[i]) {
				if (i * 2 + 1 < array.length && null != nodes[i * 2 + 1]) {
					nodes[i].left = nodes[i * 2 + 1];
				}
				if (i * 2 + 2 < array.length && null != nodes[i * 2 + 2]) {
					nodes[i].right = nodes[i * 2 + 2];
				}
			}
		}
		return root;
	}
}