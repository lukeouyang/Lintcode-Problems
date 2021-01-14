/*
453. Flatten Binary Tree to Linked List
中文English
Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Example
Example 1:

Input:{1,2,5,3,4,#,6}
Output：{1,#,2,#,3,#,4,#,5,#,6}
Explanation：
     1
    / \
   2   5
  / \   \
 3   4   6

1
\
 2
  \
   3
    \
     4
      \
       5
        \
         6
Example 2:

Input:{1}
Output:{1}
Explanation：
         1
         1
Challenge
Do it in-place without any extra memory.

Notice
Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.
 */
package binarysearchtree.problems;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        //必须要存right，因为root.right 会被flatten(root.left)覆盖
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    // version 2: Divide & Conquer
//    public class Solution {
//        /**
//         * @param root: a TreeNode, the root of the binary tree
//         * @return: nothing
//         */
//        public void flatten(TreeNode root) {
//            helper(root);
//        }
//
//        // flatten root and return the last node
//        private TreeNode helper(TreeNode root) {
//            if (root == null) {
//                return null;
//            }
//
//            TreeNode leftLast = helper(root.left);
//            TreeNode rightLast = helper(root.right);
//
//            // connect leftLast to root.right
//            if (leftLast != null) {
//                leftLast.right = root.right;
//                root.right = root.left;
//                root.left = null;
//            }
//
//            if (rightLast != null) {
//                return rightLast;
//            }
//
//            if (leftLast != null) {
//                return leftLast;
//            }
//
//            return root;
//        }
//    }

    // version 3: Non-Recursion
//    class solution {
//        public void flatten(TreeNode root) {
//            if (root == null) {
//                return;
//            }
//
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//
//            while (!stack.empty()) {
//                TreeNode node = stack.pop();
//                if (node.right != null) {
//                    stack.push(node.right);
//                }
//                if (node.left != null) {
//                    stack.push(node.left);
//                }
//
//                // connect
//                node.left = null;
//                if (stack.empty()) {
//                    node.right = null;
//                } else {
//                    node.right = stack.peek();
//                }
//            }
//        }
//    }
}

