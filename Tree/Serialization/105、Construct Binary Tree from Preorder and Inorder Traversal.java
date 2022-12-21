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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
        //使用整段的前序和中序构建
    }

    // 用 preorder[l1..r1] 和 inorder[l2..r2] 还原二叉树，preorder[0]就是根
    TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1) return null;
        TreeNode root = new TreeNode(preorder[l1]);
        int mid = l2; // mid是root在inorder中的位置，mid前面的点就是左子树
        while (inorder[mid] != root.val) mid++;
        // l2~mid-1就是左子树中序
        // mid+1~r2就是右子树中序
        //r - l + 1 
        root.left = build(l1 + 1, l1 + (mid - 1 - l2 + 1), l2, mid - 1);
        //(mid - 1 - l2 + 1)是左子树点数，也就是开始到结束有几个点
        root.right = build(l1 + (mid - l2) + 1, r1, mid + 1, r2);
        //右子树前序开始结束 和 右子树中序开始借宿
        return root;
    }


    int[] preorder;
    int[] inorder;
}
