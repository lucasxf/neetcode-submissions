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
    public void reorderList(ListNode head) {
        // reordenar em 3 etapas:
        // 1. identifico a metade da lista com 2 pointers: fast & slow
        // 2. inverto a segunda metade da lista com "reverse linked list". 
        // Como a primeira metade é de tamanho maior ou igual a segunda,
        // ao "encaixá-las", eu não tenho problemas de parear os valores
        // com ponteiros temporários, realoco as listas para o resultado
        // head fica intacta do começo ao fim
        // head = 0->1->2->3->4->5->6->null
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 1, 2, 3,
            fast = fast.next.next; // 2, 4, 6
        }
        // head = 0->1->2->3->4->5->6->null
        // slow = 3->4->5->6->null
        // fast = null
        // agora vou "romper" os ponteiros entre a primeira e segunda metade da lista
        // head = 0->1->2->3->4->5->6->null
        ListNode secondHalf = slow.next; // 4->5->6->null
        slow.next = null;
        // head = 0->1->2->3->null
        ListNode reverse = null;
        while (secondHalf != null) {
            ListNode next = secondHalf.next; // 5-> | 5->4...
            secondHalf.next = reverse; // 4->null |
            reverse = secondHalf; // 5->
            secondHalf = next;
            //secondHalf = reverse; // null
        }
        // reverse = 6->5->4->null
        // head = 0->1->2->3->null
        ListNode result = head; // 0->1->2->3->null
        while (reverse != null) {
            // salvar o ponteiro seguinte para colocar o nó de reverse entre o primeiro e o terceiro
            // elo de head
            ListNode temp1 = result.next; // 1->2->3->null
            // salvar o próximo ponteiro de reverse
            ListNode temp2 = reverse.next; // 5->4->null

            result.next = reverse; // 0->6->5->4->null
            reverse.next = temp1; // 0->6->2->3->null
            result = temp1;
            reverse = temp2;
            // result=0->6->2->3->null   
        }
    }
}
