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
        Map<String, List<Integer>> gambiarra = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.printf("queue size 1: %d%n", queue.size());
            List<Integer> currLevel = new ArrayList<>();
            String key = "";
            // coloquei aqui pq a queue tava passando por resize dinâmico no loop com os add/remove
            int fixedSize = queue.size();
            for (int i = 0; i < fixedSize; i++) {
                System.out.printf("queue size 2: %d%n", queue.size());
                TreeNode curr = queue.remove();
                System.out.printf("queue size 3: %d%n", queue.size());
                if (curr != null) {
                    currLevel.add(curr.val);
                    if (curr.left != null) {
                        queue.add(curr.left);
                        key += curr.left.val;
                        System.out.printf("queue size 4: %d%n", queue.size());
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                        key += curr.right.val;
                        System.out.printf("queue size 5: %d%n", queue.size());
                    }
                }
                System.out.printf("key: %s | map: %s%n", key, gambiarra);

            }
            valuesPerLevel.add(currLevel);
        }
        // 6 min
        return valuesPerLevel;
    }
}
