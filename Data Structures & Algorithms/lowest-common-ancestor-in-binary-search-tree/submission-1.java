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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // eu recebo uma árvore `root` e 2 nós `p` e `q`
        // o objetivo é retornar o nó que representa o menor ancestral em comum entre os nós p e q
        // quando eles estão no mesmo nível, ex.: root = [1, 2, 3], p = 2, q = 3, result=1
        // é tranquilo
        // mas eles podem estar separados por MUITAS "gerações" e em lados distintos
        // daquela "família". Como um nó pode ser ancestral dele mesmo
        // talvez eu precise fazer 2 travessias em recursão distintas
        // pensando em iterações, seria o caso de "armazenar" o `min` onde 
        // min pode ser:
        // 1. min = parent de p && parent de q      -> root=[1, 2, 3],          p=2, q=3, min=1
        // 2. min = p e p ser ancestral de q        -> root=[1, 2, 3, 4, 5],    p=2, q=5, min=p=2
        // 3. parent de q e q ser ancestral de p    -> root=[5, 6, 7, 8, 9],    p=8, q=6, min=q=6
        // 14 min
        // mesmo com recursão, vou precisar de uma função auxiliar para esse problema
        // a condição de parada será encontrar p ou q (o que vier por último)
        // e retornar bottom-up a árvore `root`, até encontrar um ancestral comum à ambos
        // o problema garante que todos os nós são únicos
        // outra condição de parada: cheguei à uma folha: `left & right == null`,
        // significa que preciso procurar do outro lado, então não encontrei ainda o LCA
        // neste caso, mantenho o LCA como ROOT
        // 19 min
        // medir apenas profundidade não ajuda, pois, p e q podem estar no mesmo nível, mas em lados distintos
        // de root
        // talvez eu precise identificar se Q está numa subroot de P e vice-versa
        // reutilizando parte da lógica de isSubtree
        // é garantido que P e Q ambos estejam em root
        // somente aos 20 min eu percebi que não é uma "binary tree", mas uma "BST" ¬¬
        // pq li a primeira dica
        TreeNode lca = root;
        return lca(root, p, q, lca);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q, TreeNode lca) {
        if (root == null) {
            return lca;
        }
        // 40 min: o LCA só atualiza quando ambos estão do mesmo lado
        // p e q estão à direita (lca atual = root.right)
        if (root.val < p.val && root.val < q.val) {
            // os dois estão no mesmo lado, logo o novo LCA é o filho/nó à direita
            // null safety
            if (root.right != null) {
                lca = root.right;
            }
            return lca(root.right, p, q, lca);
        // p e q estão à esquerda (lca atual = root.left)
        } else if (root.val > p.val && root.val > q.val) {
            // os dois estão no mesmo lado, logo o novo LCA é o filho/nó à direita
            // null safety
            if (root.left != null) {
                lca = root.left;
            }
            return lca(root.left, p, q, lca);
        }
        return lca;
    }
}
