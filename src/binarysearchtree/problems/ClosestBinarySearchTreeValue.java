/*
900. Closest Binary Search Tree Value
中文English
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

样例
Example1

Input: root = {5,4,9,2,#,8,10} and target = 6.124780
Output: 5
Explanation：
Binary tree {5,4,9,2,#,8,10},  denote the following structure:
        5
       / \
     4    9
    /    / \
   2    8  10
Example2

Input: root = {3,2,4,1} and target = 4.142857
Output: 4
Explanation：
Binary tree {3,2,4,1},  denote the following structure:
     3
    / \
  2    4
 /
1
注意事项
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
package binarysearchtree.problems;

public class ClosestBinarySearchTreeValue {
    static class TreeNode {
     public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
         this.val = val;
        this.left = this.right = null;
    }
 }
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;

        TreeNode lower = lowerBound(root, target);
        TreeNode upper = upperBound(root, target);

        if(lower == null) return upper.val;
        if(upper == null) return lower.val;

        int result = Math.abs(target - lower.val) < Math.abs(upper.val - target) ? lower.val : upper.val;
        return result;
    }

    private TreeNode lowerBound(TreeNode root, double target) {
        if(root == null) return null;
        if(target == root.val) return root;
        if(target < root.val) {
            return lowerBound(root.left, target);
        } else {
            TreeNode tn = lowerBound(root.right, target);
            if(tn != null) {
                return tn;
            } else {
                return root;
            }
        }
    }

    private TreeNode upperBound(TreeNode root, double target) {
        if(root == null) return null;
        if(target == root.val) return root;
        if(target > root.val) {
            return upperBound(root.right, target);
        } else {
            TreeNode tn = upperBound(root.left, target);
            if(tn != null) {
                return tn;
            } else {
                return root;
            }
        }
    }
}
