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
//自顶向下维护信息，深度作为全局变量，一个跟随结点移动而动态变化的信息
//递归一层，变量+1，在叶子处更新答案
class Solution {
    public int maxDepth(TreeNode root) {
        ans = 0;
        depth = 1;
        calc(root);
        return ans;
    }
    private void calc(TreeNode root) {
        if (root == null) return;
        ans = Math.max(ans, depth);
        depth++;
        calc(root.left);
        calc(root.right);
        depth--;
    }
    private int ans;
    private int depth;
}

//自底向上统计思想
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;//1是本层逻辑，本层走一步，底下是max
//         //本层自己一个点，和左子问题求max,再和右子问题求max,
//         //这2个max 跟 点本身 和 根 max,三个点里最大的
//     }
// }
