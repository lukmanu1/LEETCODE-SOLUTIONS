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

    public int levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int levelSum = 0;
        int currLevel = 0;

        int size = 0;

        TreeNode temp = null;

        while(!queue.isEmpty()){
            size = queue.size();
            levelSum = 0;
            currLevel++;

            for(int i = 0; i<size; i++){
                temp = queue.poll();
                levelSum += temp.val;

                if(temp.left != null)queue.offer(temp.left);
                if(temp.right != null)queue.offer(temp.right);
            }

            // System.out.println(levelSum+" "+currLevel);

            if(levelSum > maxSum ){
                maxSum = levelSum;
                level = currLevel;
            }
        }


        return level;
    }
    public int maxLevelSum(TreeNode root) {
        return levelOrderTraversal(root);
    }
}