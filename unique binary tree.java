/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public List<TreeNode> generateTrees(int n) {

		List<TreeNode> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {

			List<TreeNode> leftRoots = recursive(1, i - 1);
			List<TreeNode> rightRoots = recursive(i + 1, n);

			if (leftRoots.isEmpty() && !rightRoots.isEmpty()) {

				for (TreeNode rightNode : rightRoots) {
					TreeNode root = new TreeNode(i);
					root.right = rightNode;
					list.add(root);
				}

			} else if ((!leftRoots.isEmpty()) && rightRoots.isEmpty()) {
				for (TreeNode leftNode : leftRoots) {
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					list.add(root);
				}
			} else if (leftRoots.isEmpty() && rightRoots.isEmpty()) {

				TreeNode root = new TreeNode(i);
				list.add(root);
			} else {
				for (TreeNode leftNode : leftRoots) {
					for (TreeNode rightNode : rightRoots) {
						TreeNode root = new TreeNode(i);
						root.left = leftNode;
						root.right = rightNode;
						list.add(root);
					}
				}

			}
		}
		return list;
	}

	public List<TreeNode> recursive(int start, int end) {

		List<TreeNode> list = new LinkedList<>();
		if (start <= end) {
			if (start == end) {
				TreeNode root = new TreeNode(start);
				list.add(root);
			} else {
				for (int i = start; i <= end; i++) {
					List<TreeNode> leftRoots = recursive(start, i - 1);
					List<TreeNode> rightRoots = recursive(i + 1, end);

					if (leftRoots.isEmpty() && !rightRoots.isEmpty()) {

						for (TreeNode rightNode : rightRoots) {
							TreeNode root = new TreeNode(i);
							root.right = rightNode;
							list.add(root);
						}

					} else if ((!leftRoots.isEmpty()) && rightRoots.isEmpty()) {
						for (TreeNode leftNode : leftRoots) {
							TreeNode root = new TreeNode(i);
							root.left = leftNode;
							list.add(root);
						}
					} else if (leftRoots.isEmpty() && rightRoots.isEmpty()) {

						TreeNode root = new TreeNode(i);
						list.add(root);
					} else {
						for (TreeNode leftNode : leftRoots) {
							for (TreeNode rightNode : rightRoots) {
								TreeNode root = new TreeNode(i);
								root.left = leftNode;
								root.right = rightNode;
								list.add(root);
							}
						}

					}

				}
			}
		}
		return list;
	}

}
