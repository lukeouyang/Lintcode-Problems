package binarytree.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTravesal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            result.add(new ArrayList<Integer>());
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                result.get(level).add(cur.val);

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTravesal bt = new BinaryTreeLevelOrderTravesal();
        // Test case: [3,9,20,null,null,15,7]
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r1 = new TreeNode(20, l2, r2);
        TreeNode l1 = new TreeNode(9);
        TreeNode root = new TreeNode(3, l1, r1);
        List<List<Integer>> result = bt.levelOrder(root);
        for(List<Integer> l : result){
            for(Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
