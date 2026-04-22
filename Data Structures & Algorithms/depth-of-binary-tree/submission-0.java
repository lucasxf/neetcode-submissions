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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0, 0);
    }

    int dfs(TreeNode root, int depth, int max) {
        max = Math.max(depth, max);
        System.out.printf("max: %d | depth: %d%n", max, depth);
        if (root == null) {
            return max;
        }
        if (root.left != null) {
            System.out.println("l");
            return dfs(root.left, ++depth, max);
        } else {
            System.out.println("r");
            return dfs(root.right, ++depth, max);
        }
    }
}
