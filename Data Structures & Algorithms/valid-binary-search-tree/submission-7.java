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
        return isBST(root, root.val, root.val);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        System.out.println("start");
        //int max = threshold;
        //int min = threshold;
        //int curr = root.val;
        if (root.left == null && root.right == null) {
            System.out.println("leaf");
            return true;
        }
        if (root.left != null && root.right != null) {
            //max = root.left.val;
            //min = root.right.val;
            int curr = root.val;
            System.out.printf("val: %d | min: %d | max: %d%n", root.val, root.left.val, root.right.val);
            if (root.left.val >= curr || root.right.val <= curr) {
                System.out.println("here");
                return false;
            }
            return isBST(root.left, min, root.left.val) && isBST(root.right, root.right.val, max);
        }
        else if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
            //return isBST(root.left, min, root.left.val);
            //if (root.left.val >= threshold) {
            //    return false;
            //}
            max = root.left.val;
            return isBST(root.left, min, root.left.val);
        }
        else {
            if (root.right.val <= min) {
                return false;
            }
            min = root.right.val;
            return isBST(root.right, root.right.val, max);
        }
        //if (root.val < min || root.val > max || min > max )
        //return isBST(root.left, curr) && isBST(root.right, curr);
        //System.out.printf("val: %d | min: %d | max: %d%n", root.val, min, max);
        //return isBST(root.left, max) && isBST(root.right, min);
       //return min < root.val && max > root.val;
      // return true;
    }

}
