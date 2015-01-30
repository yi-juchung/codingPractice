import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    static public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        String serialized = serializeGraph(node);

        return deSerializeGraph(serialized);
    }

    static public String serializeGraph(UndirectedGraphNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Queue<UndirectedGraphNode> pendingNodes = new LinkedList<UndirectedGraphNode>();
        pendingNodes.add(node);

        while(!pendingNodes.isEmpty()) {
            UndirectedGraphNode curNode = pendingNodes.poll();
            sb.append(curNode.label);
        }

        sb.append('}');
        return sb.toString();
    }

    static public UndirectedGraphNode deSerializeGraph(String serialized) {

    }

    public static void main(String [ ] args) {
        System.out.print(UndirectedGraphNode("LXXXVIII"));
    }
}
