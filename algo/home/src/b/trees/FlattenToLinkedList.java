package b.trees;

public class FlattenToLinkedList {

    private void flatten(TreeNode node) {
        this.flattenTree(node);
    }

    private TreeNode flattenTree(TreeNode node) {
        // check if root is null
        if (node == null) {
            return null;
        }

        // for a leaf node, we simply return the node as it is
        if (node.left == null && node.right == null) {
            return node;
        }

        // let's recursively flatten the left subtree
        TreeNode leftTail = this.flattenTree(node.left);

        // let's recursively flatten the right subtree
        // we need the right tail
        TreeNode rightTail = this.flattenTree(node.right);

        // if there is a left subtree, we shuffle the connections around so that there is nothing on the left side anymore
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // we need to return the "rightmost" node after we are done wiring the new connections
        return rightTail == null ? leftTail : rightTail;
    }

}

