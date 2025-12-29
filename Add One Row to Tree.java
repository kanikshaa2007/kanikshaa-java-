/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Special case: insert at depth 1 -> new root
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        // Otherwise, insert recursively
        insertRow(root, val, 1, depth);
        return root;
    }

    private void insertRow(TreeNode node, int val, int currentDepth, int targetDepth) {
        if (node == null) return;
        
        // If we reach the depth just above target, insert new nodes
        if (currentDepth == targetDepth - 1) {
            TreeNode oldLeft = node.left;
            TreeNode oldRight = node.right;

            node.left = new TreeNode(val);
            node.left.left = oldLeft;

            node.right = new TreeNode(val);
            node.right.right = oldRight;
        } else {
            // Recurse further
            insertRow(node.left, val, currentDepth + 1, targetDepth);
            insertRow(node.right, val, currentDepth + 1, targetDepth);
        }
    }

    // Test example
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, 
                           new TreeNode(2, new TreeNode(3), new TreeNode(1)), 
                           new TreeNode(6, new TreeNode(5), null));
        
        Solution sol = new Solution();
        TreeNode newRoot = sol.addOneRow(root, 1, 2);
        printTree(newRoot); // Optional: implement preorder print to check
    }
    
    // Optional helper to print tree (preorder)
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
