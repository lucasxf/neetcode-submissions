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
        // vou percorrer a árvore até as folhas (left & right children = null)
        // e retornar "0" (elemento neutro da adição) na condição de parada
        // a cada nível, vou retornar "pra cima" + 1
        if (root == null) {
            return 0;
        }
        //int left = maxDepth(root.left);
        //int right = maxDepth(root.right);
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
