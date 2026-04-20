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
    public boolean hasCycle(ListNode head) {
        // problema: identificar se na lista fornecida existe um ciclo
        // um ciclo é definido quando não é possível se chegar ao fim (node.next = null)
        // de uma lista ligada. Em algum momento da linked list, um nó aponta para
        // um nó anterior à ele criando assim um loop interminável numa iteração comum
        // abordagem: vou utilizar 2 pointers (fast & slow) no traversal da lista
        // se em um dado momento o fast "alcançar" o slow, isto é, "dar uma volta" nele
        // significa que a lista tem um laço. Se fast chegar à null, a lista tem fim
        // 2 min digitando, bora codar
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
