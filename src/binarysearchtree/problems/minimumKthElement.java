/*
902. Kth Smallest Element in a BST
中文English
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example
Example 1:

Input：{1,#,2},2
Output：2
Explanation：
	1
	 \
	  2
The second smallest element is 2.
Example 2:

Input：{2,1,3},1
Output：1
Explanation：
  2
 / \
1   3
The first smallest element is 1.
Challenge
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Notice
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
package binarysearchtree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class minimumKthElement {
    public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
  //Solution 1: in-order traversal, get the k th element
//    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
//        if(root == null) return arr;
//        inorder(root.left, arr);
//        arr.add(root.val);
//        inorder(root.right, arr);
//        return arr;
//    }
//
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
//        return nums.get(k-1);
//    }

    //Solution 2: recursive to iteration
//    public int kthSmallest(TreeNode root, int k) {
//        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
//
//        while (true) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//            root = stack.removeLast();
//            if (--k == 0) return root.val;
//            root = root.right;
//        }
//    }
    // Solution 3: first, count child nodes for each node;
    // second, quick select on tree based on nodes
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> numOfChildren = new HashMap<>();
        countNodes(root, numOfChildren);
        return quickSelectOnTree(root, k, numOfChildren);
    }

    private int countNodes(TreeNode root, Map<TreeNode, Integer> numOfChildren) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left, numOfChildren);
        int right = countNodes(root.right, numOfChildren);
        numOfChildren.put(root, left + right + 1);
        return left + right + 1;
    }

    private int quickSelectOnTree(TreeNode root, int k, Map<TreeNode, Integer> numOfChildren) {
        if (root == null) {
            return -1;
        }

        int left = root.left == null ? 0 : numOfChildren.get(root.left);
        if (left >= k) {
            return quickSelectOnTree(root.left, k, numOfChildren);
        }
        if (left + 1 == k) {
            return root.val;
        }

        return quickSelectOnTree(root.right, k - left - 1, numOfChildren);
    }
    public static void main(String[] args) {
        System.out.println("OK");
    }
}
