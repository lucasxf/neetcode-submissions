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
            System.out.println("leaf");
            return true;
        }
        //int max = threshold;
        //int min = threshold;
        int curr = root.val;
        if (root.left != null) {
            if (root.left.val >= curr) {
                return false;
            }
            /*if (root.left.val >= threshold) {
                return false;
            }*/
            //max = root.left.val;
            //return isBST(root.left, root.left.val);
        }
        if (root.right != null) {
            if (root.right.val <= curr) {
                return false;
            }
            //min = root.right.val;
            //return isBST(root.right, root.right.val);
        }
        return isBST(root.left, curr) && isBST(root.right, curr);
        //System.out.printf("threshold: %d | min: %d | max: %d%n", threshold, min, max);
        //return isBST(root.left, max) && isBST(root.right, min);
    }

}
