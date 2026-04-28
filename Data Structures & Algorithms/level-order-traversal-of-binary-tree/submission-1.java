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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        // o problema pede que eu transforme a árvore de entrada "root"
        // numa lista de listas, onde cada lista interna possui os valores
        // de um nível da árvore.
        // vou utilizar BFS para percorrer a árvore salvando na lista
        List<List<Integer>> valuesPerLevel = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            // coloquei aqui pq a queue tava passando por resize dinâmico no loop com os add/remove
            int fixedSize = queue.size();
            for (int i = 0; i < fixedSize; i++) {
                TreeNode curr = queue.remove();
                if (curr != null) {
                    currLevel.add(curr.val);
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }
            valuesPerLevel.add(currLevel);
        }
        // 6 min
        return valuesPerLevel;
    }
}
