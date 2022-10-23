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
        return check(root, -(1l << 31), (1l << 31) - 1);
    } //Integer.INT_MIN 2的31次方

    //最小，最大，如果正好是负的INT_MIN -1就会越界，这里要用long
    private boolean check(TreeNode root, long rangeLeft, long rangeRight) {
        if (root == null) return true;
        if (root.val < rangeLeft || root.val > rangeRight) return false;//先看点本身root.val 再看剩余的
        return check(root.left, rangeLeft, (long)root.val - 1) && //root.left在左和右里面，并且不能超过root.val，严格小于所以要-1
            check(root.right, (long)root.val + 1, rangeRight);
    }
}
