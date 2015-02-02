import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    static public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer,UndirectedGraphNode> newNodeMap = new HashMap<Integer, UndirectedGraphNode>();

        Queue<UndirectedGraphNode> oldNodeQueue = new LinkedList<UndirectedGraphNode>();
        oldNodeQueue.add(node);

        UndirectedGraphNode newRootNode = new UndirectedGraphNode(node.label);
        newNodeMap.put(node.label, newRootNode);

        while (!oldNodeQueue.isEmpty()) {
            UndirectedGraphNode curNode = oldNodeQueue.poll();
            UndirectedGraphNode newNode = null;

            if (!newNodeMap.containsKey(curNode.label)) {
                newNode = new UndirectedGraphNode(curNode.label);
                newNodeMap.put(curNode.label, newNode);
            } else {
                newNode = newNodeMap.get(curNode.label);
            }

            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                UndirectedGraphNode newNeighbor = null;
                if (newNodeMap.containsKey(neighbor.label)) {
                    newNeighbor = newNodeMap.get(neighbor.label);
                } else {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    newNodeMap.put(neighbor.label, newNeighbor);
                    oldNodeQueue.add(neighbor);
                }
                newNode.neighbors.add(newNeighbor);
            }
        }

        return newRootNode;
    }

    public static void main(String [ ] args) {
        UndirectedGraphNode rootNode = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        rootNode.neighbors.add(node1);
        rootNode.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        UndirectedGraphNode cloned = cloneGraph(rootNode);

        System.out.print("123");
    }
}
