import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        vertices.putIfAbsent(label, vertex);
    }

    public void addEdge(Edge edge) {
        Vertex vertex = edge.getToVertex();
     
        if (!vertices.containsValue(vertex)) {
            throw new IllegalArgumentException("Vertex does not exist.");
        }
        vertex.addEdge(edge);
    }

    public void removeVertex(String label) {
        Vertex removedVertex = vertices.remove(label);
        if (removedVertex != null) {
            removedVertex.getEdges().forEach(edge -> {
                Vertex connectedVertex = edge.getConnectedVertex(removedVertex);
                connectedVertex.removeEdge(edge);
            });
        }
    }

    public void removeEdge(String label1, String label2) {
        Vertex vertex1 = vertices.get(label1);
        Vertex vertex2 = vertices.get(label2);
        if (vertex1 == null || vertex2 == null) {
            throw new IllegalArgumentException("One or both vertices do not exist.");
        }
        Edge edgeToRemove = vertex1.getEdges().stream()
                .filter(edge -> edge.isConnectedTo(vertex2))
                .findFirst()
                .orElse(null);
        if (edgeToRemove != null) {
            vertex1.removeEdge(edgeToRemove);
            vertex2.removeEdge(edgeToRemove);
        }
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices.values());
    }

    public Vertex getVertex(String label) {
        return vertices.get(label);
    }

    public int getIndex(Vertex vertex) {
        int index = -1;
        int i = 0;
        for (Vertex v : vertices.values()) {
            if (v.equals(vertex)) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }
}