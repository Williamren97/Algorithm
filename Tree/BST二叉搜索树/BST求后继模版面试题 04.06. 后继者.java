/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return findSucc(root, p.val);
    }

    private TreeNode findSucc(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode ans = null;
        while (curr != null) {
            if (curr.val > val) { // case2：当后继存在于经过的点中（找到一个>val的最小点）
                // 含义：ans=min(ans, curr.val);
                if (ans == null || ans.val > curr.val)
                    ans = curr;
            }
            if (curr.val == val) {
                if (curr.right != null) { // case1：检索到val且右子树存在，右子树一路向左
                    curr = curr.right;
                    while (curr.left != null) curr = curr.left;
                    return curr;
                }
                break;
            }
            if (val < curr.val) curr = curr.left;
            else curr = curr.right;
        }
        return ans;
    }

}


//在该代码中，使用了循环来遍历二叉树，依次比较当前节点 curr 的值与目标值 val（即 p.val）。根据二叉搜索树的性质，如果目标值小于当前节点的值，那么后继节点一定存在于当前节点的左子树中，所以更新当前节点为其左子节点（curr = curr.left）。反之，如果目标值大于等于当前节点的值，那么后继节点要么存在于当前节点的右子树中，要么当前节点就是后继节点的父节点。所以更新当前节点为其右子节点（curr = curr.right）。
