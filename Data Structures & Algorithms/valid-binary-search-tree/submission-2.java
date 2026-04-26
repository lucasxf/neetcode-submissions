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
        // uma BST (binary search tree) é uma árvore
        // onde a cada nó - incluindo o root - possui
        // TODOS os nós filhos à esquerda dele são MENORES que ele: root.left.val < root.val
        // TODOS os nós filhos à direita dele são MAIORES que ele: root.right.val > root.val
        // isso se mantém verdade a nível da árvore, ou seja, todas as sub árvores de uma BST
        // também são BSTs.
        // como vou resolver?
        // a cada nível, vou comparar o valor atual (root.val) com os valores filhos 
        //(root.left.val) e (root.right.val), se eu chegar à "folha" (root == null), 
        // aquele "ramo" é uma BST válida, se eu for interrompido antes, ou seja,
        // as condições left.val < root.val ou right.val > root.val se provarem inválidas

        // 7 min
        // o problema não diz se a árvore é "completa e balanceada", isto é, se há nós
        // filhos preenchidos à esquerda e à direita em TODOS os níveis, portanto,
        // é necessário null check dos filhos à cada nível
        // 10 min: quebrou no case [2, 2, 2], adicionei "=" à comparação
        // 11 min: quebrou no caso: root=[5,4,6,null,null,3,7]
        // 3 está à esquerda de 6, o que o torna válid0, mas está à direita de 5, o que o torna inválido
        // preciso salvar o menor valor da raiz original e o maior também
        // para comparar nível a nível
        // vou exportar a função (parece gambiarra)
        // 18 min exportar com um "int val" não deu certo
        // pois um nó pode ser menor que o valor da raiz, mas estar à direita
        return isBST(root, root.val);
    }

    private boolean isBST(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {    
            // 22 min: preciso comparar também o valor atual de root
            if (root.val > val) {
                // estou no lado direito da árvore
                // então mesmo uma ramificação à esquerda,
                // precisa ser maior que o valor original da raiz
                if (root.left.val < val) {
                    return false;
                }
            }
            if (root.val <= root.left.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val < val) {
                if (root.right.val > val) {
                    return false;
                }
            }
            if (root.val >= root.right.val) {
                return false;
            }
        }
        return isBST(root.left, val) && isBST(root.right, val);
    }
}
