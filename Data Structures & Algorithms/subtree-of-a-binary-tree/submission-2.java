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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // vou receber 2 árvores distintas, root e sub root
        // e preciso comparar se há em `root` uma estrutura
        // idêntica à subRoot, isto é, se há filhos de root
        // com o mesmo formato de subRoot, implicando que sub root
        // é uma "sub árvore" de root.
        // vou reutilizar parte da lógica de "isSameTree", no sentido
        // de comparar bottom-up se as leafs (children sem filhos) são idênticas
        // ou não. A condição de parada são as leafts (root/sub root == null)
        // o problema é que a sub root pode estar em qualquer posição da root, (ou não)
        // ou seja, no começo, meio ou fim da root. Então simplesmente comparar nó a nó
        // do fim pro começo, sozinho não resolve
        // ao encontrar nós idênticos é preciso mudar a direção das validações
        // e ao encontrar nós distintos, é preciso aprofundar (ou subir o nível?) das buscas
        // recursão é complexo
        // 4min
        // condição de parada
        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        // no exemplo: root = [1, 2, 3, 4, 5, null, null] e subroot = [2, 4, 5], sub root é
        // uma subtree de root, mas no nível da raíz [1], a comparação entre elas será negativa
        // então talvez o critério seja aprofundar em root apenas quando os valores forem distintos
        // 7 min
        // na verdade, eu avanço AMBAS quando forem iguais, e avanço root quando forem distintas
        // 10 min, vou começar a codar
        // boolean rootLevel = false;
        // sem risco de null pointer, pois o null check foi realizado acima
        // se os valores forem iguais nos mesmos níveis, atravesso ambas árvores
        return isSameTree(root, subRoot) || isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
        /*System.out.printf("root: %d | subRoot: %d | root.left: %s | subRoot.left: %s | root.right: %s | subRoot.right: %s%n",
        
        root.val, subRoot.val, root.left, subRoot.left, root.right, subRoot.right);
        if (root.val == subRoot.val) {
            System.out.println("true");
            return isSameTree(root, subRoot) || isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
        }
        System.out.println("false");
        // root não é igual a subRoot, então avanço pelo lado esquerdo de root
        // a fim de encontrar um nó igual à base de subRoot (não atravesso sub root ainda)
        // 17 min: percebi que esse if é desnecessário
        //if (root.left != null) {
        // percorro APENAS a root até que a condição do if anterior seja verdadeira
        // quando for, inicio a travessia de ambas simultaneamente,
        // 19 min, esse return deu errado  
        //return isSubtree(root.left, subRoot) && isSubtree(root.right, subRoot);
        //}
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        System.out.printf("left: %s | right: %s%n", left, right);
        // aos 27 min troquei "&&" por "||"
        // 28 min: desisti
        return left || right;*/
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
