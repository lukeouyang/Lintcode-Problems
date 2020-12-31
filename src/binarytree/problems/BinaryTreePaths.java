package binarytree.problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) return paths;

        String path = String.valueOf(root.val);
        findPath(root, path, paths);

        return paths;
    }
// use a path var to store the current path to current node
    private void findPath(TreeNode node, String path, List<String> paths) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        if(node.left != null) {
            findPath(node.left, path + "->" + node.left.val, paths);
        }
        if(node.right != null) {
            findPath(node.right, path + "->" + node.right.val, paths);
        }
    }
}
