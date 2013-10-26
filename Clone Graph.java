/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

	public HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		map.clear();
		return clone(node);
	}

	public UndirectedGraphNode clone(UndirectedGraphNode node){
		if (node == null)
			return null;
		UndirectedGraphNode newNode;

		if (!map.containsKey(node.label)){
			newNode = new UndirectedGraphNode(node.label);
			map.put(newNode.label, newNode);
		}
		else
			newNode = map.get(node.label);
		
		for (UndirectedGraphNode neighbor:node.neighbors) {
			UndirectedGraphNode newNeighbor;
			if (map.containsKey(neighbor.label))
				newNeighbor = map.get(neighbor.label);
			else
				newNeighbor = clone(neighbor);
			newNode.neighbors.add(newNeighbor);
		}
		return newNode;
	}
}