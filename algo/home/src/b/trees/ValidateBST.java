package b.trees;

class TreeNode {
    Long val;
    TreeNode left;
    TreeNode right;

    TreeNode(Long x) {
        this.val = x;
    }
}

//                   10
//                  /  \
//                /     \
//               5      15
//             /  \      \
//            3   7      13

// this is an invalid BST, 13 is not between the upper and lower limits (15 to +inf)
public class ValidateBST {

    // do not rely on the left and right child nodes
    // rely on a defined upper limit and lower limit
    public boolean validate(TreeNode root, Long lowerLimit, Long upperLimit) {

        // an empty node is a valid BST
        if(root == null) {
            return true;
        }

        // current node value must be between lowerLimit and upperLimit
        if ((root.val <= lowerLimit) || (root.val >= upperLimit)) {
            return false;
        }

        return validate(root.left, lowerLimit, root.val) && validate(root.right, root.val, upperLimit);
    }

    public boolean isValidBST (TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
