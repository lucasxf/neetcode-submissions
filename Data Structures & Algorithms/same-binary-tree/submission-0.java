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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // vou receber 2 nós "raízes", p e q e preciso compará-los
        // se representam a mesma árvore binária.
        // uma árvore é igual a outra quando todos os nós de uma árvore
        // estão no mesmo nível (depth), valor, e "posição" (left or right)
        // em relação à árvore sendo comparada
        // 2 árvores podem ter os mesmos valores, mas se os "children" estiverem
        // invertidos, as árvore NÃO são iguais
        // vou trabalhar com recursão até o caso base: onde ambos são nulos, aí retorno true
        // se apenas um lado for nulo, as árvores são diferentes
        // se os valores no mesmo nível e lado forem diferentes, as árvores são diferentes
        // 4 min
        // condições de parada
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        // se valores forem diferentes, as árvores são diferentes
        if (p.val != q.val) {
            return false;
        }
        // senão, avanço um nível na procura
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}
