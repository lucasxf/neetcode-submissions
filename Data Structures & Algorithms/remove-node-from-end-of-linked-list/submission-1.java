/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // eu recebo uma lista ligada e um inteiro n
        // preciso remover do fim da lista o enésimo (nth) nó
        // e retornar o início da lista
        // vou utilizar 2 pointers (fast & slow) para iterar a lista
        // dando uma "vantagem" de n "passos" para o fast ao início da travessia
        // quando fast chegar o final, slow estará na posição fim-n
        // essa é a primeira parte do problema.
        // a segunda parte é atualizar a lista de modo à o elemento anterior ao
        // que será removido, apontar para o elemento posterior ao que será removido
        // isto é, n-1 apontar para n+1:
        // vou precisar utilizar slow (n-1), com slow.next (n) apontando para n+1.
        // como n+1 pode ser null, vou precisar de um prev (como fast.prev numa doubly linked list)
        // para saber para onde apontar
        // posições
        // [0,   1,   2,   3,   4,   5] // tamanho = 5 (n=5)
        // [n-5, n-4, n-3, n-2, n-1, n-1]
        //  1 -> 2 -> 3 -> 4 -> 5 -> 6 // remover n=1 
        ListNode slow = head; // 1->2->3->4->null
        ListNode fast = head; // 1->2->3->4->null
        // 16 min: vou criar um dummy
        ListNode dummy = new ListNode(0); // 0->null
        ListNode tail = dummy; // 0->null
        int i = 0;
        while (i < n) {
            fast = fast.next; // 3->4->null
            i++;
        }
        while (fast != null) { // true
            // atualizo o "previous" antes de mover o ponteiro "slow"
            tail.next = slow; // 0->1 | 1->2
            tail = tail.next; // 1-> | 2->
            slow = slow.next; // 2-> | 3->
            // se fast.next = null (vou chegar ao fim da iteração)
            // armazeno o "previous" em tail para saber para onde apontar a seguir
            fast = fast.next; // 4-> | null
        }
        // quando cheguei ao final da lista original
        // slow será o nó a ser removido
        // tail vai estar apontando para slow
        // e preciso que tail aponte para slow.next
        // null safety
        if (slow != null) { // true: 3
            tail.next = slow.next; // 2-> 4
        }
        // 1ª tentativa: 
        // entrada: 1->2->3->4, n=2
        // retorno = [4] ao invés de [1, 2, 4]
        // esqueci de avançar tail
        return dummy.next;
    }
}
