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
    Integer level = 0;
    public void inorderTraversal(TreeNode root, int k, List<Integer> list){
        if(root == null)return ;

        Integer val = list.get(k);
        
        list.set(k, val + root.val);
        

        inorderTraversal(root.left, k + 1, list);
        inorderTraversal(root.right, k + 1, list);

    }

    public void findLevel(TreeNode root, int currLevel){
        if(root == null)return;

        level = Math.max(currLevel, level);
        
        findLevel(root.left, currLevel + 1);
        findLevel(root.right, currLevel + 1);
    }
    
    public int maxLevelSum(TreeNode root) {

        findLevel(root, 0);


        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<=level; i++)list.add(0);

        inorderTraversal(root, 0, list);

        int ans[] = new int[2];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = -1;

        for(int i = 0 ; i<list.size(); i++){
            if(ans[0] < list.get(i)){
                ans[0] = list.get(i);
                ans[1] = i;
            }
        }
        
        return ans[1] + 1;
    }
}