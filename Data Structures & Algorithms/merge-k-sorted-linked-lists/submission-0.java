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
    public ListNode mergeKLists(ListNode[] lists) {
        // eu vou receber um array de listas ligadas com elementos em ordem crescente
        // e preciso retornar uma linked list única com todos os elementos das k listas
        // do array de entrada devidamente ordenados
        // como eu não sei o tamanho k das listas, nested loops são complicados
        // pois ficariam O(N^N*M) em time, onde N é o tamanho do array lists e 
        // m é o tamanho de cada lista dentro dele
        // sempre que encontro tamanhos "variáveis" de nested loops,
        // me sinto inclinado à utilizar recursão
        // como preciso preservar a lista de saída, penso que precisarei
        // das técnicas de dummy + tail nodes, onde o tail será passado adiante
        // a cada iteração da minha recursividade.
        // podem haver valores repetidos entre listas, então Min/Max são mais complicados
        // 7 min, li todas as dicas e não tenho ideia do que fazer ou de por onde começar.
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftMerger = mergeLists(lists, left, mid);
        ListNode rightMerger = mergeLists(lists, mid + 1, right);
        return combine2Lists(leftMerger, rightMerger);
    }

    private ListNode combine2Lists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }
}
