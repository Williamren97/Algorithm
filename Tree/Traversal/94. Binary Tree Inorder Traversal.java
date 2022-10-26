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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;//后进先出 DFS 先给左的弹出来（已经给左的左子树做完了）
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}


// DFS
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
//         helper(res, root);
//         return res;   
//     }
//     public static void helper(List<Integer> res, TreeNode root) {
//             if (root == null) return;
//             helper(res, root.left);
//             res.add(root.val);
//             helper(res, root.right);
//         }
// }
