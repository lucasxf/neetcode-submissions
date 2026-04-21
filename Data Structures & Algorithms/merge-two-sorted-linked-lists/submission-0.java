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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // vou utilizar 2 pointers com dummy node e tail
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // enquanto ambos forem válidos
        // vou selecionar o menor valor deles e 
        // salvar na tail
        // quando uma lista se tornar inválida, mesmo que a outra
        // ainda tenha valores, eu só preciso "apendá-la" ao final da tail
        while (list1 != null && list2 != null) {
            // se o valor de list1 < valor list2
            // o próximo nó da tail = list1
            if (list1.val < list2.val) {
                tail.next = list1;
                // traversal list1
                list1 = list1.next;
            } else {
                tail.next = list2;
                // traversal list 2
                list2 = list2.next;
            }
            // tail avança em todas iterações
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}