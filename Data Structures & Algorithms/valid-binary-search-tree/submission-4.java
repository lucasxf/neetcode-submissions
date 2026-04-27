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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, root.val);
    }

    private boolean isBST(TreeNode root, int threshold) {
        if (root == null) {
            return true;
        }
        int max = threshold;
        int min = threshold;
        if (root.left != null) {
            if (root.left.val >= max) {
                return false;
            }
            max = root.left.val;
        }
        if (root.right != null) {
            if (root.right.val <= threshold) {
                return false;
            }
            min = root.right.val;
        }
        return isBST(root.left, max) && isBST(root.right, min);
    }

}
