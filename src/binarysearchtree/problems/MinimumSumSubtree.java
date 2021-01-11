/*
596. Minimum Subtree
中文English
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

样例
Example 1:

Input:
{1,-5,2,1,2,-4,-5}
Output:1
Explanation:
The tree is look like this:
     1
   /   \
 -5     2
 / \   /  \
1   2 -4  -5
The sum of whole tree is minimum, so return the root.
Example 2:

Input:
{1}
Output:1
Explanation:
The tree is look like this:
   1
There is one and only one subtree in the tree. So we return 1.
注意事项
LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.
 */
package binarysearchtree.problems;

public class MinimumSumSubtree {
    public static class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

//  Solution 1: traverse and record with global var
// --------------------------------------------
//    private TreeNode minTree = null;
//    private int minSum = Integer.MAX_VALUE;
//
//    public TreeNode findSubtree(TreeNode root) {
//        if(root == null) return null;
//
//        helper(root);
//        return minTree;
//
//    }
//
//    int helper(TreeNode root) {
//        if(root == null) return 0;
//
//        int sum = helper(root.left) + helper(root.right) + root.val;
//        if(sum < minSum) {
//            minSum = sum;
//            minTree = root;
//        }
//
//        return sum;
//    }
    // -----------------------------------------------------

    //solution 2: pure divided-conquer, customize return type;

    class ResultType {
        public TreeNode minSubtree;
        public int sum, minSum;
        public ResultType(TreeNode minSubtree, int minSum, int sum) {
            this.minSubtree = minSubtree;
            this.minSum = minSum;
            this.sum = sum;
        }
    }

    public TreeNode findSubtree(TreeNode root) {
        ResultType r = helper(root);
        return r.minSubtree;
    }

    public ResultType helper(TreeNode root) {
        if(root == null) return new ResultType(null, Integer.MAX_VALUE, 0);

        ResultType leftSub = helper(root.left);
        ResultType rightSub = helper(root.right);
        ResultType result = new ResultType(root,
                leftSub.sum+rightSub.sum+root.val,
                leftSub.sum+rightSub.sum+root.val);
        if(leftSub.minSum < result.minSum) {
            result.minSum = leftSub.minSum;
            result.minSubtree = leftSub.minSubtree;
        }
        if(rightSub.minSum < result.minSum) {
            result.minSum = rightSub.minSum;
            result.minSubtree = rightSub.minSubtree;
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumSumSubtree mss= new MinimumSumSubtree();
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(-5);
        TreeNode node12 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(-4);
        TreeNode node24 = new TreeNode(-5);
        root.left = node11;
        root.right = node12;
        node11.left = node21;
        node11.right = node22;
        node12.left = node23;
        node12.right = node24;

//        TreeNode result = mss.findSubtree(root);
//        System.out.println(result);
//        System.out.println(mss.minSum);

        ResultType result = mss.helper(root);
        System.out.println(result.minSubtree);
        System.out.println(result.minSum);


    }
}
