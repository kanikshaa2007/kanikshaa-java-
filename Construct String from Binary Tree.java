class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        // Append current node value
        sb.append(node.val);

        // Case: left child exists OR right child exists
        if (node.left != null || node.right != null) {
            sb.append("(");
            if (node.left != null) {
                build(node.left, sb);
            }
            sb.append(")");
        }

        // Case: right child exists
        if (node.right != null) {
            sb.append("(");
            build(node.right, sb);
            sb.append(")");
        }
    }
}
