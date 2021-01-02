/*
137. Clone Graph
中文English
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. Nodes are labeled uniquely.

You need to return a deep copied graph, which has the same structure as the original graph, and any changes to the new graph will not have any effect on the original graph.

样例
Example1

Input:
{1,2,4#2,1,4#4,1,2}
Output:
{1,2,4#2,1,4#4,1,2}
Explanation:
1------2
 \     |
  \    |
   \   |
    \  |
      4
说明
How we serialize an undirected graph: http://www.lintcode.com/help/graph/

注意事项
You need return the node with the same label as the input node.
 */
package graph.problems;

import java.util.*;

public class CloneGraph {
     static class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
  }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        // BFS find all the nodes, store to a list
        ArrayList<UndirectedGraphNode> listNodes = getNodes(node);

        // loop through node list and create copied node, store the mapping for each other
        // to a hashmap
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode n : listNodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        // iterate through the listNodes to copy all the neighbors of original nodes to copied ones
        for(UndirectedGraphNode n : listNodes) {
            UndirectedGraphNode newNode = map.get(n);
            for(UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Set<UndirectedGraphNode> nodeSet = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        nodeSet.add(node);

        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode n : cur.neighbors) {
                if(!nodeSet.contains(n)) {
                    queue.offer(n);
                    nodeSet.add(n);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(nodeSet);
    }
}
