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
    public TreeNode invertTree(TreeNode root) {
        // da última vez eu cometi o erro de inverter os valores
        // não os ponteiros, e utilizei BFS para comparar nível a nível
        // ao invés de BFS. Vou tentar mudar a abordagem dessa vez
        // a condição de parada ainda é a leaf (children = null)
        invert(root);
        // repete via recursividade
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null)
            return;
        // salva temps
        TreeNode left = root.left;
        TreeNode right = root.right;

        // inverte nós
        root.left = right;
        root.right = left;
        invert(root.left);
        invert(root.right);
    }
}
