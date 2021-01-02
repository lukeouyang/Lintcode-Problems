/*
127. Topological Sorting
中文English
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

样例
For graph as follow:

图片

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
挑战
Can you do it in both BFS and DFS?
 */
package graph.problems;

import java.util.*;

public class TopologicalSorting {
     static class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  };
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        //An arraylist to store result and intermediate result
        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        //A map to store in-degree for each node
        Map<DirectedGraphNode, Integer> map = new HashMap<>();

        //first loop to update the map for in-degree for each node
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor: node.neighbors) {
                if(map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor)+1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        // set up a queue, put the nodes not in map to it (nodes with 0 in-degree)
        Queue<DirectedGraphNode> queue = new ArrayDeque<>();
        for(DirectedGraphNode node : graph) {
            if(!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        // start BFS
        while(!queue.isEmpty()) {
            DirectedGraphNode n = queue.poll();
            for(DirectedGraphNode node : n.neighbors) {
                map.put(node, map.get(node)-1);
                if(map.get(node) == 0) {
                    result.add(node);
                    queue.offer(node);
                }
            }
        }
        System.out.println(result);
        return result;
    }

}
