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

    private int n = 0;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        kthVal(root, k);
        return result;
    }

    private void kthVal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthVal(root.left, k);
        // in order
        ++n;
        if (n == k) {
            result = root.val;
        }
        kthVal(root.right, k);
    }
}