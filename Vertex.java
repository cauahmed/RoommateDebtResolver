import java.util.*;

public class Vertex {
    private String label;
    private List<Edge> edges;

    public Vertex(String label) {
        this.label = label;
        edges = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean hasEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.isConnectedTo(vertex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Edge edge : edges) {
            sb.append(edge).append(", ");
        }
        return sb.length() > 0 ? sb.toString().substring(0, sb.length() - 2) : "";
    }
}
